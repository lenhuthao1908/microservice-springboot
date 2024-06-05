package com.microserives.config.security;

import com.microserives.constant.MessageErrorException;
import com.microserives.dto.request.IntrospectRequestDto;
import com.microserives.service.IAuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.text.ParseException;
import java.util.Objects;

/**
 * CustomJwtDecoder
 *
 * @author haoln
 * @version 01-00
 * @since 6/5/2024
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class CustomJwtDecoder implements JwtDecoder {

    @NonFinal
    @Value("${jwt.signerKey}")
    String SIGNER_KEY;

    IAuthenticationService iAuthenticationService;

    @NonFinal
    NimbusJwtDecoder nimbusJwtDecoder = null;



    @Override
    public Jwt decode(String token) throws JwtException {
        try {
            var result = iAuthenticationService.introspect(IntrospectRequestDto.builder()
                    .token(token)
                    .build());
            if (!result.isValid()) {
                throw new JwtException(MessageErrorException.TOKEN_ISVALID);
            }
        } catch (ParseException | JOSEException e) {
            throw new RuntimeException(e.getMessage());
        }

        if (Objects.isNull(nimbusJwtDecoder)){
            SecretKeySpec secretKeySpec = new SecretKeySpec(SIGNER_KEY.getBytes(), "HS512");
            nimbusJwtDecoder = NimbusJwtDecoder
                    .withSecretKey(secretKeySpec)
                    .macAlgorithm(MacAlgorithm.HS512)
                    .build();
        }

        return nimbusJwtDecoder.decode(token);

    }
}
