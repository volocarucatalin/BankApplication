package service;

import controller.AccountController;
import controller.TransferController;
import database.DbConnection;
import database.DbConnectionImpl;
import org.modelmapper.ModelMapper;
import repository.AccountRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReceiver {
    private ModelMapper modelMapper;
    private DbConnection connection;
    private AccountRepository accountRepository;
    private AccountService accountService;
    private TransferService transferService;
    private AccountController accountController;
    private TransferController transferController;


    public InputReceiver() throws SQLException {
        setupApplication();
    }

    private void setupApplication() throws SQLException {
        modelMapper = new ModelMapper();
        connection = new DbConnectionImpl();
        connection.connect();
        accountRepository = new AccountRepository(connection);
        accountService = new AccountService(accountRepository);
        accountController = new AccountController(accountService, modelMapper);
        transferService = new TransferService(accountRepository);
        transferController = new TransferController(transferService);

    }

    public void result() {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();


        switch (option) {
            case "1":
                for (int i = 0; i < accountController.getAllAccounts().size(); i++) {
                    System.out.println(accountController.getAllAccounts().get(i));
                }

                break;

            case "2":
                System.out.println(accountController.findAccountBySortCode(scanner.nextLine()));


                break;

            case "0":
                System.out.println("Program Close\nThank you for work whit our Bank ");
                break;

            case "3":
                System.out.println("Please enter your Sort Code \n " +
                        "Receiver Sort Code \n" +
                        " Amount you would like to send");
                transferController.transferBetween(scanner.nextLine(), scanner.nextLine(), Long.parseLong(scanner.nextLine()));
                break;

            default:
                System.out.println("Option not found");
                System.out.println("Please enter a valid number");
                result();
                break;


        }
    }
}
