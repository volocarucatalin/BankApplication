package controller;

import model.Account;
import org.modelmapper.ModelMapper;
import service.AccountService;
import view.AccountDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AccountController {

    private AccountService accountService;
    private ModelMapper modelMapper;

    public AccountController(AccountService accountService, ModelMapper modelMapper) {
        this.accountService = accountService;
        this.modelMapper = modelMapper;
    }


    public List<AccountDTO> getAllAccounts() {

        List<Account> accounts = accountService.getAllAccounts();
        return accounts
                .stream()
                .map(account -> modelMapper.map(account, AccountDTO.class))
                .collect(Collectors.toList());
    }

    public AccountDTO findAccountBySortCode(int sortCode) {
        Account account = accountService.findAccountBySortCode(sortCode);
        return modelMapper.map(account, AccountDTO.class);

    }



}
