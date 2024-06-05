package com.microserives.service.impl;

import com.microserives.common.ConstantCommon;
import com.microserives.constant.MessageErrorException;
import com.microserives.dto.request.AuthenticationRequestDto;
import com.microserives.dto.request.IntrospectRequestDto;
import com.microserives.dto.request.LogoutDto;
import com.microserives.dto.response.AuthenticationResponseDto;
import com.microserives.dto.response.IntrospectResponseDto;
import com.microserives.entity.InvalidateTokenEntity;
import com.microserives.entity.UserEntity;
import com.microserives.exception.AppException;
import com.microserives.repository.InvalidateTokenRepository;
import com.microserives.repository.UserRepository;
import com.microserives.service.IAuthenticationService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationServiceImpl implements IAuthenticationService {

    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    static final int ONE = 1;

    UserRepository userRepository;
    InvalidateTokenRepository invalidateTokenRepository;

    @Override
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto authenticationRequestDto) {
        var userEntity = userRepository.findByUsername(authenticationRequestDto.getUsername())
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(ConstantCommon.STRENGTH_PASSWORD);
        boolean checkPassword = passwordEncoder.matches(authenticationRequestDto.getPassword(), userEntity.getPassword());
        if (!checkPassword)
            throw new AppException(MessageErrorException.NOT_FOUND);

        var accessToken = generateAccessToken(userEntity, ONE);
        var refreshToken = generateRefreshToken(ONE);

        return AuthenticationResponseDto.builder()
                .statusAuthentication(checkPassword)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public void logout(LogoutDto logoutDto) throws ParseException {
        var signToken = verifyToken(logoutDto.getToken());

        var jit = signToken.getJWTClaimsSet().getJWTID();
        var expiryTime = signToken.getJWTClaimsSet().getExpirationTime();

        InvalidateTokenEntity entity = InvalidateTokenEntity.builder()
                .code(jit)
                .expiryTime(expiryTime)
                .build();

        invalidateTokenRepository.save(entity);
    }

    private SignedJWT verifyToken(String token) {
        try {
            JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes(StandardCharsets.UTF_8));
            SignedJWT signedJWT = SignedJWT.parse(token);

            Date expiration = signedJWT.getJWTClaimsSet().getExpirationTime();

            var verified = signedJWT.verify(verifier);

            if (!(verified && expiration.after(new Date()))) {
                throw new AppException(MessageErrorException.EXPIRED_TOKEN);
            }

            if (invalidateTokenRepository.existsByCode(signedJWT.getJWTClaimsSet().getJWTID())) {
                throw new AppException(MessageErrorException.UNAUTHENTICATED);
            }

            return signedJWT;
        } catch (JOSEException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AuthenticationResponseDto refreshToken(String refreshToken, String currentAccessToken) {
        try {
            JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes(StandardCharsets.UTF_8));
            SignedJWT signedJWT = SignedJWT.parse(refreshToken);
            var verified = signedJWT.verify(verifier);
            var expiration = signedJWT.getJWTClaimsSet().getExpirationTime();

            if (verified && expiration.after(new Date())) {
                // Extend the access token expiration by 1 hour from the current time
                var newAccessToken = generateTokenWithExtendedExpiry(currentAccessToken, ONE);

                return AuthenticationResponseDto.builder()
                        .statusAuthentication(true)
                        .accessToken(newAccessToken)
                        .refreshToken(refreshToken)
                        .build();
            } else {
                throw new AppException(MessageErrorException.UNAUTHENTICATED);
            }
        } catch (JOSEException | ParseException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public IntrospectResponseDto introspect(IntrospectRequestDto introspectRequestDto) throws JOSEException, ParseException {
        var token = introspectRequestDto.getToken();
        boolean isTokenValid = true;
        try {
            JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes(StandardCharsets.UTF_8));
            SignedJWT signedJWT = SignedJWT.parse(token);

            Date expiration = signedJWT.getJWTClaimsSet().getExpirationTime();
            Date now = new Date();

            var verified = signedJWT.verify(verifier);
            isTokenValid = verified && expiration.after(now);

            verifyToken(token);
        } catch (AppException e) {
            isTokenValid = false;
        }
        return IntrospectResponseDto.builder()
                .valid(isTokenValid)
                .build();
    }


    private String generateAccessToken(UserEntity entity, int time) {
        // build token
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(entity.getUsername())
                .issuer("com.microserives")
                .issueTime(new Date())
                .expirationTime(Date.from(Instant.now().plus(time, ChronoUnit.HOURS)))
                .claim("scope", buildScope(entity))
                .jwtID(UUID.randomUUID().toString())
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        try {
            // sign token
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes(StandardCharsets.UTF_8)));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("could not generate token", e);
            throw new RuntimeException(e);
        }
    }

    private String generateRefreshToken(int time) {
        // build token
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .issueTime(new Date())
                .expirationTime(Date.from(Instant.now().plus(time, ChronoUnit.DAYS)))
                .jwtID(UUID.randomUUID().toString())
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        try {
            // sign token
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes(StandardCharsets.UTF_8)));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("could not generate token", e);
            throw new RuntimeException(e);
        }
    }

    private String generateTokenWithExtendedExpiry(String currentAccessToken, int extendTime) {
        try {
            JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);
            SignedJWT signedJWT = SignedJWT.parse(currentAccessToken);
            var claimsSet = signedJWT.getJWTClaimsSet();

            var newExpirationTime = Date.from(Instant.now().plus(extendTime, ChronoUnit.HOURS));

            JWTClaimsSet newClaimsSet = new JWTClaimsSet.Builder(claimsSet)
                    .expirationTime(newExpirationTime)
                    .build();

            Payload payload = new Payload(newClaimsSet.toJSONObject());
            JWSObject jwsObject = new JWSObject(jwsHeader, payload);

            // sign
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes(StandardCharsets.UTF_8)));
            return jwsObject.serialize();
        } catch (JOSEException | ParseException e) {
            log.error("could not extend token expiry", e);
            throw new RuntimeException(e);
        }
    }

    private String buildScope(UserEntity userEntity) {
        StringJoiner stringJoiner = new StringJoiner(" ");
         if (!CollectionUtils.isEmpty(userEntity.getRoles())) {
             userEntity.getRoles().forEach(role -> {
                 stringJoiner.add("ROLE_" + role.getRoleName());
                 if (!CollectionUtils.isEmpty(role.getPermissions())) {
                     role.getPermissions().forEach(permission -> {
                         stringJoiner.add(permission.getPermissionName());
                     });
                 }
             });
         }
        return stringJoiner.toString();
    }
}
