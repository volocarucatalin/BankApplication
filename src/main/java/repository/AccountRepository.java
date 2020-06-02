package repository;

import builder.BuilderAccount;
import database.DbConnection;
import model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private DbConnection connection;

    public AccountRepository(DbConnection connection) {
        this.connection = connection;
    }


    public List<Account> findAllAccounts() {
        List<Account> result = new ArrayList<>();
        String query = "select * from accounts ";

        try {
            Statement statement = connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result.add(BuilderAccount.build(resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getLong("card_number"),
                        resultSet.getLong("account_number"),
                        resultSet.getInt("sort_code"),
                        resultSet.getInt("security_code"),
                        resultSet.getLong("balance")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public Account findAccountBySortCode(int sortCode) {
        String query = "select  * from accounts where sort_code = ?";


        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(query);
            statement.setInt(1, sortCode);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            return BuilderAccount.build(resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getLong("card_number"),
                    resultSet.getLong("account_number"),
                    resultSet.getInt("sort_code"),
                    resultSet.getInt("security_code"),
                    resultSet.getLong("balance"));


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Account not found with sort_code ");
            return null;
        }

    }




    public void updateAccount(Account account) {
        String query = "update accounts set balance = ? where sort_code = ?";

        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(query);
            statement.setDouble(1, account.getBalance());
            statement.setInt(2, account.getSortCode());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
