package service;

import controller.AccountController;
import database.DbConnection;
import database.DbConnectionImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReceiver {

    public InputReceiver() {
    }

    public static void result() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        List<String> accounts = new ArrayList<>();
        DbConnection connection = new DbConnectionImpl();
        connection.connect();
        AccountController accountController = new AccountController(connection);
        boolean input = false;

        switch (option) {
            case "1":
                for (int i = 0; i < accountController.getAllAccounts().size(); i++) {
                    System.out.println(accountController.getAllAccounts().get(i));
                }
                input = true;
                break;

            case "2":
                System.out.println(accountController.findAccount(scanner.nextLine()));

                input = true;
                break;

            case "0":
                System.out.println("Program Close\nThank you for work whit our Bank ");
                break;

            case "3":
                MoneyTransfer.moneyTransfer();
                break;

            default:
                System.out.println("Option not found");
                System.out.println("Please enter a valid number");
                input = false;
                result();
                break;


        }
    }
}
