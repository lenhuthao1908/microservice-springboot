package com.microserives.service.impl;

import com.microserives.common.ConstantCommon;
import com.microserives.constant.MessageErrorException;
import com.microserives.dto.request.CreateUserDto;
import com.microserives.dto.request.UpdateUserDto;
import com.microserives.dto.response.UserDto;
import com.microserives.entity.UserEntity;
import com.microserives.enums.RolesEnum;
import com.microserives.exception.AppException;
import com.microserives.mapper.UserMapper;
import com.microserives.repository.UserRepository;
import com.microserives.service.IUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements IUserService {

    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> findAllUser() {
        List<UserEntity> entityList = userRepository.findAll();
        return userMapper.INSTANCE.toUserDtos(entityList);
    }

    @Override
    public UserDto createUser(CreateUserDto createUserDto) {
        var userEntity = userMapper.toUserEntity(createUserDto);
        userEntity.setCreatedDate(new Date());
        userEntity.setPassword(new BCryptPasswordEncoder(ConstantCommon.STRENGTH_PASSWORD).encode(userEntity.getPassword()));
        HashSet<String> roles = new HashSet<>();
        roles.add(RolesEnum.USER.name());
        // userEntity.setRoles(roles);
        return userMapper.INSTANCE.toUserDto(userRepository.save(userEntity));
    }

    @Override
    public UserDto updateUser(UpdateUserDto updateUserDto) {
        var findUserById = userRepository.findById(updateUserDto.getId())
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        var entity = userMapper.INSTANCE.toUserEntity(findUserById, updateUserDto);
        entity.setUpdatedDate(new Date());
        entity.setPassword(new BCryptPasswordEncoder(ConstantCommon.STRENGTH_PASSWORD).encode(entity.getPassword()));
        var result = userRepository.save(entity);
        return userMapper.INSTANCE.toUserDto(result);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public UserDto findUserById(Long id) {
        var entity = userRepository.findById(id)
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        return userMapper.INSTANCE.toUserDto(entity);
    }

    @Override
    @PostAuthorize("returnObject.username == authentication.name")
    public UserDto getUserInfo() {
        var context = SecurityContextHolder.getContext();
        var name = context.getAuthentication().getName();
        var entity = userRepository.findByUsername(name)
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        return userMapper.INSTANCE.toUserDto(entity);
    }

    @Override
    public void deleteUser(Long id) {
        var entity = userRepository.findById(id)
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        entity.setDeletedDate(new Date());
        userRepository.save(entity);
    }
}
