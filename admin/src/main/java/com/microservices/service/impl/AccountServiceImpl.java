package com.microservices.service.impl;

import com.microservices.common.ConstantCommon;
import com.microservices.constant.MessageErrorException;
import com.microservices.dto.request.CreateAccountDto;
import com.microservices.dto.request.UpdateAccountDto;
import com.microservices.dto.response.AccountDto;
import com.microservices.entity.AccountEntity;
import com.microservices.exception.AppException;
import com.microservices.repository.AccountRepository;
import com.microservices.repository.RoleRepository;
import com.microservices.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@Transactional(readOnly = true)
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    // @PreAuthorize("hasRole('ADMIN')")
    public List<AccountDto> findAllUser() {
        List<AccountDto> entityList = accountRepository.getAllAccount();
        return entityList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AccountDto createUser(CreateAccountDto createAccountDto) {
        AccountEntity entity = new AccountEntity();
        entity.setCreatedDate(new Date());
        entity.setUsername(createAccountDto.getUsername());
        entity.setPassword(new BCryptPasswordEncoder(ConstantCommon.STRENGTH_PASSWORD).encode(createAccountDto.getPassword()));
        entity.setFirstName(createAccountDto.getFirstName());
        entity.setLastName(createAccountDto.getLastName());
        entity.setBirthDate(createAccountDto.getBirthDate());
        accountRepository.create(entity);
        AccountDto dto = new AccountDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public AccountDto updateUser(UpdateAccountDto updateAccountDto) {
        var entity = accountRepository.findOne(updateAccountDto.getId());
        entity.setUpdatedDate(new Date());
        entity.setPassword(new BCryptPasswordEncoder(ConstantCommon.STRENGTH_PASSWORD).encode(updateAccountDto.getPassword()));
        entity.setFirstName(updateAccountDto.getFirstName());
        entity.setLastName(updateAccountDto.getLastName());
        entity.setBirthDate(updateAccountDto.getBirthDate());
        accountRepository.update(entity);
        var dto = new AccountDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }


    @Override
    // @PreAuthorize("hasRole('ADMIN')")
    public AccountDto findUserById(Long id) {
        var entity = accountRepository.findOne(id);
        if (Objects.isNull(entity)) {
            throw new AppException(MessageErrorException.NOT_FOUND);
        }
        var dto = new AccountDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    @PostAuthorize("returnObject.username == authentication.name")
    public AccountDto getUserInfo() {
        var context = SecurityContextHolder.getContext();
        var name = context.getAuthentication().getName();
        var entity = accountRepository.getAccountByUsername(name);
        var dto = new AccountDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public void deleteUser(Long id) {
        var entity = accountRepository.findOne(id);
        entity.setDeletedDate(new Date());
        accountRepository.update(entity);
    }

    // @Override
    // @Transactional(rollbackFor = Exception.class)
    // public void createAdminAccountIfNotExists() {
    //     AccountEntity adminUserOpt = accountRepository.getAccountByUsername("admin");
    //     if (Objects.isNull(adminUserOpt)) {
    //         AccountEntity adminDefault = new AccountEntity();
    //         adminDefault.setUsername("admin");
    //         adminDefault.setPassword(new BCryptPasswordEncoder(ConstantCommon.STRENGTH_PASSWORD).encode("123123"));
    //         adminDefault.setFirstName(null);
    //         adminDefault.setLastName(null);
    //         adminDefault.setBirthDate(null);
    //         adminDefault.setCreatedDate(new Date());
    //         accountRepository.create(adminDefault);
    //         log.info("Create account ADMIN default with username: admin, password: 123123, created date: {}", adminDefault.getCreatedDate());
    //     }
    // }

}
