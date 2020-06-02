package repository;

import builder.BuilderStatement;
import database.DbConnection;
import model.Statement;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatementRepository {
    private DbConnection connection;

    public StatementRepository(DbConnection connection) {
        this.connection = connection;
    }


    public void updateStatement(int senderSortCode, int receiverSortCode, double amount, String statusTransaction) {
        String query = "INSERT INTO statements VALUES (?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(query);
            statement.setInt(1, senderSortCode);
            statement.setDouble(2, amount);
            statement.setInt(3, receiverSortCode);
            statement.setString(4, statusTransaction);
            statement.setDate(5, new Date(System.currentTimeMillis()));
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Statement> getStatement(int sortCode) {
        List<Statement> statements = new ArrayList<>();

        String query = "SELECT a.first_name as sender_first_name,\n" +
                "                a.last_name as sender_last_name,\n" +
                "                s.sort_code ,\n" +
                "                s.amount, acc_rec.FIRST_NAME as receiver_first_name , \n" +
                "                acc_rec.last_name as receiver_last_name, \n" +
                "                s.status , \n" +
                "                s.DATE_TRANSACTION \n" +
                "FROM Accounts a \n" +
                "INNER JOIN Statements s ON a.sort_code = s.sort_code \n" +
                "INNER JOIN Accounts acc_rec ON acc_rec.sort_code = s.REC_SORT_CODE\n" +
                "where a.sort_code=? or s.REC_SORT_CODE = 325488";



        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(query);
            statement.setInt(1, sortCode);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                statements.add(BuilderStatement.build(resultSet.getString("sender_first_name"),
                        resultSet.getString("sender_last_name"),
                        resultSet.getInt("sort_code"),
                        resultSet.getDouble("amount"),
                        resultSet.getString("receiver_first_name"),
                        resultSet.getString("receiver_last_name"),
                        resultSet.getString("status"),
                        resultSet.getString("date_transaction")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query can't be execute");

        }
        return statements;
    }
}
