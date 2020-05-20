package service;

import controller.AccountController;
import database.DbConnection;
import database.DbConnectionImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoneyTransfer {


    public MoneyTransfer() {
    }



    public static void moneyTransfer() throws SQLException {
        List<String> sendingInfo;
        List<String> receiverInfo;
        List<String> receiverAccount = new ArrayList<>();

        DbConnection connection = new DbConnectionImpl();
        connection.connect();
        AccountController accountController = new AccountController(connection);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your Sort Code ");
        System.out.println(accountController.findAccount(scanner.nextLine()));
        System.out.println("Is this your account\nPlease type: Yes if its your account\nPlease type : No if is not");
       String answer = scanner.nextLine();
        if(answer.equals("Yes")){
            System.out.println("Please enter receiver details ");
            System.out.println("Receiver full name");
            String receiverFirstName = scanner.nextLine();
            String receiverLastName = scanner.nextLine();
            System.out.println("Receiver account number");
            String receiverAccountNumber = scanner.nextLine();
            System.out.println("Receiver sort code");
            String receiverSortCode = scanner.nextLine();
            System.out.println("Confirming the details:");
            System.out.println(accountController.findAccount(receiverSortCode));
            System.out.println("Type Yes if you would like to continue or No if you would like to stop now");
            String result = scanner.nextLine();
            if(result.equals("Yes")){
                CheckBalance.readAndCheckBalance(scanner.nextLine());
            }else{
                System.out.println("You cancel the transfer have a good day");
            }

        }else{
            System.out.println("We cant find the account .\nPlease try again");
        }

    }

}
