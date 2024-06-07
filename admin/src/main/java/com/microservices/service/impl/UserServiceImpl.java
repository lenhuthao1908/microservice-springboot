package com.microservices.service.impl;

import com.microservices.dto.request.CreateUserDto;
import com.microservices.dto.request.UpdateUserDto;
import com.microservices.dto.response.UserDto;
import com.microservices.repository.RoleRepository;
import com.microservices.repository.UserRepository;
import com.microservices.service.IUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements IUserService {

    UserRepository userRepository;
    RoleRepository roleRepository;

    @Override
    public List<UserDto> findAllUser() {
        return null;
    }

    @Override
    public UserDto createUser(CreateUserDto createUserDto) {
        return null;
    }

    @Override
    public UserDto updateUser(UpdateUserDto updateUserDto) {
        return null;
    }

    @Override
    public UserDto findUserById(Long id) {
        return null;
    }

    @Override
    public UserDto getUserInfo() {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }


    //     @Override
// //    @PreAuthorize("hasRole('ADMIN')")
//     @PreAuthorize("hasAuthority('CREATE_DATA')")
//     public List<UserDto> findAllUser() {
//         List<UserEntity> entityList = userRepository.getAllUser();
//     }
//
//     @Override
//     public UserDto createUser(CreateUserDto createUserDto) {
//         var userEntity = userMapper.toUserEntity(createUserDto);
//         userEntity.setCreatedDate(new Date());
//         userEntity.setPassword(new BCryptPasswordEncoder(ConstantCommon.STRENGTH_PASSWORD).encode(userEntity.getPassword()));
//         HashSet<String> roles = new HashSet<>();
//         roles.add(RolesEnum.USER.name());
//         // userEntity.setRoles(roles);
//         return userMapper.INSTANCE.toUserDto(userRepository.save(userEntity));
//     }
//
//     @Override
//     public UserDto updateUser(UpdateUserDto updateUserDto) {
//         var findUserById = userRepository.findById(updateUserDto.getId())
//                 .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
//         var entity = userMapper.INSTANCE.toUserEntity(findUserById, updateUserDto);
//         entity.setUpdatedDate(new Date());
//         entity.setPassword(new BCryptPasswordEncoder(ConstantCommon.STRENGTH_PASSWORD).encode(entity.getPassword()));
//         var roles = roleRepository.findAllByRoleNameIn(updateUserDto.getRoles());
//         log.info(roles.toString());
//         entity.setRoles(new HashSet<>(roles));
//         var result = userRepository.save(entity);
//         var roleDto = roleMapper.toRoleDtos(roles);
//         var data = userMapper.INSTANCE.toUserDto(result);
//         data.setRoles(new HashSet<>(roleDto));
//         return data;
//     }
//
//
//     @Override
//     @PreAuthorize("hasRole('ADMIN')")
//     public UserDto findUserById(Long id) {
//         var entity = userRepository.findById(id)
//                 .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
//         return userMapper.INSTANCE.toUserDto(entity);
//     }
//
//     @Override
//     @PostAuthorize("returnObject.username == authentication.name")
//     public UserDto getUserInfo() {
//         var context = SecurityContextHolder.getContext();
//         var name = context.getAuthentication().getName();
//         var entity = userRepository.findByUsername(name)
//                 .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
//         return userMapper.INSTANCE.toUserDto(entity);
//     }
//
//     @Override
//     public void deleteUser(Long id) {
//         var entity = userRepository.findById(id)
//                 .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
//         entity.setDeletedDate(new Date());
//         userRepository.save(entity);
//     }
}
