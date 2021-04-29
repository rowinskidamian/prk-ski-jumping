package prk.ski.jumping.controller.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtilities {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306";
    static final String DATABASE_USERNAME = "admin";
    static final String DATABASE_PASSWORD = "password";

    public static Connection connectToDatabase() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
    }
}
