package service;

import model.Account;
import repository.AccountRepository;
import repository.StatementRepository;

public class TransferService {
    private AccountRepository accountRepository;
    private StatementRepository statementRepository ;

    public TransferService(AccountRepository accountRepository, StatementRepository statementRepository) {
        this.accountRepository = accountRepository;
        this.statementRepository = statementRepository;
    }

    public void transferBetween(int senderSortCode, int receiverSortCode, double amount) {

        Account accountSender = accountRepository.findAccountBySortCode(senderSortCode);

        if (accountSender == null) {
            insertStatement(senderSortCode, receiverSortCode, amount, "fail");
            throw new RuntimeException("Sender Sort Code is not valid");
        }
        if (!(accountSender.getBalance() >= amount)) {
            insertStatement(senderSortCode, receiverSortCode, amount, "fail");
            throw new RuntimeException("Your balance is less then what you would like to transfer ");
        }

        Account accountReceiver = accountRepository.findAccountBySortCode(receiverSortCode);

        if (accountReceiver == null) {
            insertStatement(senderSortCode, receiverSortCode, amount, "fail");
            throw new RuntimeException("Receiver Sort Code is not valid");
        }

        accountSender.setBalance(accountSender.getBalance() - amount);
        accountReceiver.setBalance(accountReceiver.getBalance() + amount);

        accountRepository.updateAccount(accountSender);
        accountRepository.updateAccount(accountReceiver);

        insertStatement(senderSortCode, receiverSortCode, amount, "complete");

        System.out.println("Transaction have been successful!");
    }

    private void insertStatement(int senderSortCode, int receiverSortCode, double amount, String statusTransaction) {
        statementRepository.updateStatement(senderSortCode,receiverSortCode,amount,statusTransaction);
    }
}
