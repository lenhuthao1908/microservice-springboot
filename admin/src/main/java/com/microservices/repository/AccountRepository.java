package com.microservices.repository;

import com.microservices.config.miragesql.repository.DbRepository;
import com.microservices.dto.response.AccountDto;
import com.microservices.entity.AccountEntity;

import java.util.List;

public interface AccountRepository extends DbRepository<AccountEntity, Long> {

    AccountEntity getAccountByUsername(String username);

    List<AccountDto> getAllAccount();
}
