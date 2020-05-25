package repository;

import database.DbConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementRepository {
    private DbConnection connection;

    public StatementRepository(DbConnection connection) {
        this.connection = connection;
    }


    public void updateStatement(int senderSortCode, int receiverSortCode, long amount, String statusTransaction) {
        String query = "INSERT INTO statements VALUES (?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(query);
            statement.setInt(1, senderSortCode);
            statement.setLong(2, amount);
            statement.setInt(3, receiverSortCode);
            statement.setString(4, statusTransaction);
            statement.setDate(5, new Date(System.currentTimeMillis()));
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
