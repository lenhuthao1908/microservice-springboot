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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements IUserService {

    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    public List<UserDto> findAllUser() {
        List<UserEntity> entityList = userRepository.findAll();
        return userMapper.INSTANCE.toUserDtos(entityList);
    }

    @Override
    public UserDto createUser(CreateUserDto createUserDto) {
        UserEntity userEntity = userMapper.toUserEntity(createUserDto);
        userEntity.setCreatedDate(new Date());
        userEntity.setPassword(new BCryptPasswordEncoder(ConstantCommon.STRENGTH_PASSWORD).encode(userEntity.getPassword()));
        HashSet<String> roles = new HashSet<>();
        roles.add(RolesEnum.USER.name());
        userEntity.setRoles(roles);
        UserEntity entity = userRepository.save(userEntity);
        return userMapper.INSTANCE.toUserDto(entity);
    }

    @Override
    public UserDto updateUser(UpdateUserDto updateUserDto) {
        UserEntity findUserById = userRepository.findById(updateUserDto.getId())
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        UserEntity entity = userMapper.INSTANCE.toUserEntity(findUserById, updateUserDto);
        entity.setUpdatedDate(new Date());
        entity.setPassword(new BCryptPasswordEncoder(ConstantCommon.STRENGTH_PASSWORD).encode(entity.getPassword()));
        UserEntity result = userRepository.save(entity);
        return userMapper.INSTANCE.toUserDto(result);
    }

    @Override
    public UserDto findUserById(Long id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        return userMapper.INSTANCE.toUserDto(entity);
    }

    @Override
    public void deleteUser(Long id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        entity.setDeletedDate(new Date());
        userRepository.save(entity);
    }
}
