package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionImpl implements DbConnection {
    private Connection connection;

    @Override
    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
