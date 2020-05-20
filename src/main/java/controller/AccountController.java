package controller;

import builder.BuilderAccount;
import database.DbConnection;
import model.Account;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountController {

    private DbConnection dbConnection;

    public AccountController(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }


    public List<Account> getAllAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String query = "select * from accounts ";
        Statement statement = dbConnection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            accounts.add(BuilderAccount.build(resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getLong("card_number"),
                    resultSet.getLong("account_number"),
                    resultSet.getInt("sort_code"),
                    resultSet.getInt("security_code")));
        }


        return accounts;
    }

    public Account findAccount(String sortCode) throws SQLException {
        String query = "select *  from accounts";
        Statement statement = dbConnection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

       while (resultSet.next()) {
           if (resultSet.getInt("sort_code") == Integer.parseInt(sortCode)) {
               return BuilderAccount.build(resultSet.getString("first_name"),
                       resultSet.getString("last_name"),
                       resultSet.getLong("card_number"),
                       resultSet.getLong("account_number"),
                       resultSet.getInt("sort_code"),
                       resultSet.getInt("security_code"));

           }
       }
            return null;

    }

    public  long reedBalance(String sortCode ) throws SQLException {
        long balance = 0;
        String query = "select balance from accounts where sort_code = ?";
        PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);
        statement.setString(1,sortCode);
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        balance = resultSet.getLong("balance");

        return balance;
    }

    public List<String> saveAccountInfo(List<String> accountInfo , String sortCode) throws SQLException {
        String query = "select *  from accounts";
        Statement statement = dbConnection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {

            if (resultSet.getString("sort_code").equals(sortCode)) {
                accountInfo.add(resultSet.getString("first_name"));
                accountInfo.add(resultSet.getString("last_name"));
                accountInfo.add(resultSet.getString("sort_code"));
                accountInfo.add(resultSet.getString("account_number"));

            }
        }
        return accountInfo;

    }

}
