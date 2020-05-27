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

    public List<Statement> getStatement(int sortCode  ) throws SQLException {
         List<Statement>  statements = new ArrayList<>();
        String query = " SELECT a.first_name, a.last_name, acc_rec.FIRST_NAME,acc_rec.last_name, s.amount, s.status , s.DATE_TRANSACTION \n" +
                "FROM Accounts a \n" +
                "INNER JOIN Statements s ON a.sort_code = s.sort_code \n" +
                "INNER JOIN Accounts acc_rec ON acc_rec.sort_code = s.REC_SORT_CODE\n" +
                "where a.sort_code=?";

            PreparedStatement statement = connection.getConnection().prepareStatement(query);
            statement.setInt(1, sortCode);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                statements.add(BuilderStatement.build(resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("sort_code"),
                        resultSet.getDouble("amount"),
                        resultSet.getString("status"),
                        resultSet.getString("date_transaction")));
            }

        return statements;
    }
}
