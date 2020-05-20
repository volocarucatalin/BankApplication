package service;

import controller.AccountController;
import model.Account;

import java.sql.SQLException;
import java.util.Scanner;

public class CheckBalance {
    static String sortCode;

    public CheckBalance(String sortCode) {
        this.sortCode = sortCode;
    }
    public static AccountController accountController;

    public static void readAndCheckBalance(String amount) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean amountToHigh = true;
        long balance;

        do {
            System.out.println("Enter the amount you want to transfer :");
             amount = scanner.nextLine();
            balance = accountController.reedBalance(sortCode);
            if (Long.parseLong(amount) > balance) {
                System.out.println("You don't have enough money to transfer\nRe enter the amount:");
                amountToHigh  = false;
            } else {
                readAndCheckBalance(amount);
                amountToHigh = true;
            }
        }while (false);


    }
}
