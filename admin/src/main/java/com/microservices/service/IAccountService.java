package com.microservices.service;

import com.microservices.dto.request.CreateAccountDto;
import com.microservices.dto.request.UpdateAccountDto;
import com.microservices.dto.response.AccountDto;

import java.util.List;

public interface IAccountService {
    List<AccountDto> findAllUser();
    AccountDto createUser(CreateAccountDto createAccountDto);
    AccountDto updateUser(UpdateAccountDto updateUserDto);
    AccountDto findUserById(Long id);
    AccountDto getUserInfo();
    void deleteUser(Long id);
    // void createAdminAccountIfNotExists();
}
