package com.bank.service;

import com.bank.dto.AccountCreateRequest;
import com.bank.dto.AccountResponse;

import java.util.List;

public interface AccountService {
    List<AccountResponse> getAllAccounts();
    AccountResponse createAccount(AccountCreateRequest request);
    AccountResponse getAccountById(Long id);
}
