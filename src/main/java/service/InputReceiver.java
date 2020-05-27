package service;

import controller.AccountController;
import controller.StatementController;
import controller.TransferController;
import database.DbConnection;
import database.DbConnectionImpl;
import org.modelmapper.ModelMapper;
import repository.AccountRepository;
import repository.StatementRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class InputReceiver {
    private ModelMapper modelMapper;
    private DbConnection connection;
    private AccountRepository accountRepository;
    private StatementRepository statementRepository;
    private AccountService accountService;
    private TransferService transferService;
    private StatementService statementService;
    private AccountController accountController;
    private TransferController transferController;
    private StatementController statementController;



    public InputReceiver() throws SQLException {
        setupApplication();
    }

    private void setupApplication() throws SQLException {
        modelMapper = new ModelMapper();
        connection = new DbConnectionImpl();
        connection.connect();
        accountRepository = new AccountRepository(connection);
        statementRepository = new StatementRepository(connection);
        accountService = new AccountService(accountRepository);
        accountController = new AccountController(accountService, modelMapper);
        transferService = new TransferService(accountRepository, statementRepository);
        transferController = new TransferController(transferService);
        statementService = new StatementService(statementRepository);
        statementController = new StatementController(statementService);


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
                int sortCode = Integer.parseInt(scanner.nextLine());
                System.out.println(accountController.findAccountBySortCode(sortCode));


                break;

            case "0":
                System.out.println("Program Close\nThank you for work whit our Bank ");
                break;

            case "3":
                System.out.println("Please enter your Sort Code:");
                int senderSortCode = Integer.parseInt(scanner.nextLine());
                System.out.println("Please enter Receiver Sort Code:");
                int receiverSortCode = Integer.parseInt(scanner.nextLine());
                System.out.println("Please enter the amount you would like to transfer:");
                double amount = Double.parseDouble(scanner.nextLine());
                transferController.transferBetween(senderSortCode, receiverSortCode,  amount);
                break;

            case "4":
                System.out.println("Please enter your Sort Code:");
                int yourSortCode = Integer.parseInt(scanner.nextLine());
                System.out.println("Connecting to your account...");

                try {
                    for (int i = 0; i <statementController.getStatementBySortCode(yourSortCode).size(); i++) {

                        System.out.println(statementController.getStatementBySortCode(yourSortCode).get(i));
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Option not found");
                System.out.println("Please enter a valid number");
                result();
                break;


        }
    }
}
