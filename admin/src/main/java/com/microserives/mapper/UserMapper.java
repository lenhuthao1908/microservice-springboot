package com.microserives.mapper;

import com.microserives.dto.request.CreateUserDto;
import com.microserives.dto.request.UpdateUserDto;
import com.microserives.dto.response.UserDto;
import com.microserives.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "roles", ignore = true)
    UserEntity toUserEntity(CreateUserDto createUserDto);

    @Mapping(target = "roles", ignore = true)
    UserDto toUserDto(UserEntity userEntity);

    List<UserDto> toUserDtos(List<UserEntity> userEntities);

    @Mapping(target = "roles", ignore = true)
    UserEntity toUserEntity(@MappingTarget UserEntity userEntity, UpdateUserDto updateUserDto);

    // static List<UserDto> toListDto(List<Object[]> list) {
    //     List<UserDto> result = new ArrayList<>();
    //     for (Object[] d : list) {
    //         UserDto userDto = new UserDto();
    //         userDto.setUsername(d[0].toString());
    //         userDto.setPassword(d[1].toString());
    //         result.add(userDto);
    //     }
    //     return result;
    // }
}

