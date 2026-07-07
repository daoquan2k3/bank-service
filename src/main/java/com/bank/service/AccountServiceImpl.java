package com.bank.service;

import com.bank.dto.AccountCreateRequest;
import com.bank.dto.AccountResponse;
import com.bank.entity.Account;
import com.bank.repository.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements  AccountService {

    private final IAccountRepository accountRepository;

    @Override
    public List<AccountResponse> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(acc -> new AccountResponse(acc.getId(), acc.getCustomerName(), acc.getBalance()))
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponse createAccount(AccountCreateRequest request) {
        Account account = new Account();
        account.setCustomerName(request.getCustomerName());
        account.setBalance(request.getBalance());

        Account savedAccount = accountRepository.save(account);
        return new AccountResponse(savedAccount.getId(), savedAccount.getCustomerName(), savedAccount.getBalance());
    }

    @Override
    public AccountResponse getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản với ID: " + id));
        return new AccountResponse(account.getId(), account.getCustomerName(), account.getBalance());
    }
}
