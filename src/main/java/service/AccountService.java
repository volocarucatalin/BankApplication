package service;

import model.Account;
import repository.AccountRepository;

import java.util.List;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService() {
    }

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }

    public Account findAccountBySortCode(int sortCode) {
        return accountRepository.findAccountBySortCode(sortCode);
    }
}
