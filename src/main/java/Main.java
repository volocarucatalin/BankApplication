package main.java;

import controller.AccountController;
import database.DbConnection;
import database.DbConnectionImpl;
import model.Account;
import service.InputReceiver;
import service.MoneyTransfer;

import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Press 0 to close the program");
        System.out.println("Press 1 if you what to show all of teh accounts");
        System.out.println("Press 2 if you want to find out id the account exist");
        System.out.println("Press 3 if you want to make a transfer");

        InputReceiver.result();

    }
}
