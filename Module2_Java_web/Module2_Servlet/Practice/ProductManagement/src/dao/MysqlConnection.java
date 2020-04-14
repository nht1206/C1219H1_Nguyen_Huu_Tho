package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection connection = null;
        String username = "root";
        String password = "toor";
        String connectionString = "jdbc:mysql://localhost:3306/";
        String databaseName = "product";
        Class.forName(driver);
        connection = DriverManager.getConnection(connectionString + databaseName, username, password);
        return connection;
    }
}
