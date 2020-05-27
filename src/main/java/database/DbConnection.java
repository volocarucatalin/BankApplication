package database;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnection {
    String url = "jdbc:oracle:thin:@localhost:1522:orcl";
    String user = "catalin";
    String password = "catalin";

    void connect() throws SQLException;

    Connection getConnection();
}
