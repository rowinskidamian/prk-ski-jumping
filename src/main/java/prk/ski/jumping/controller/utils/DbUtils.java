package prk.ski.jumping.controller.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author DamianRowinski
 */

public class DbUtils {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/prk_ski_jumping?serverTimezone=UTC";
    static final String DB_USERNAME = "root";
    static final String DB_PASSWORD = "coderowo";

    public static Connection connectToDatabase() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DB_USERNAME, DB_PASSWORD);
    }

}
