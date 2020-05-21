package service;

import model.Account;
import repository.AccountRepository;

public class TransferService {
   private AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transferBetween(String senderSortCode, String receiverSortCode, long amount) {

        Account accountSender = accountRepository.findAccountBySortCode(senderSortCode);

        if (accountSender == null) {
            throw new RuntimeException("Sender Sort Code is not valid");
        }
        if (!(accountSender.getBalance() >= amount)) {

            throw new RuntimeException("Your balance is less then what you would like to transfer ");
        }

        Account accountReceiver = accountRepository.findAccountBySortCode(receiverSortCode);

        if (accountReceiver == null) {
            throw new RuntimeException("Receiver Sort Code is not valid");
        }

        accountSender.setBalance(accountSender.getBalance() - amount);
        accountReceiver.setBalance(accountReceiver.getBalance() + amount);

        accountRepository.updateAccount(accountSender);
        accountRepository.updateAccount(accountReceiver);

        insertStatement(senderSortCode , receiverSortCode , amount);

        System.out.println("Transaction have been successful!");
    }

    private void insertStatement(String senderSortCode, String receiverSortCode, long amount) {
        //TODO:need to be implemented

    }
}
