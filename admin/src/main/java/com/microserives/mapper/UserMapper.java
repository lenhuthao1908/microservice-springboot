package com.microserives.mapper;

import com.microserives.dto.request.CreateUserDto;
import com.microserives.dto.request.UpdateUserDto;
import com.microserives.dto.response.UserDto;
import com.microserives.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toUserEntity(CreateUserDto createUserDto);
    UserDto toUserDto(UserEntity userEntity);
    List<UserDto> toUserDtos(List<UserEntity> userEntities);
    UserEntity toUserEntity(@MappingTarget UserEntity userEntity, UpdateUserDto updateUserDto);
}

