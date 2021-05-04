package prk.ski.jumping.controller.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author DamianRowinski
 */

public class DbUtils {
    private static DbUtils dbUtil;
    private HikariDataSource dataSource;

    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/prk_ski_jumping?serverTimezone=UTC";
    static final String DB_USERNAME = "root";
    static final String DB_PASSWORD = "coderowo";

    private DbUtils() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DATABASE_URL);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername(DB_USERNAME);
        config.setPassword(DB_PASSWORD);
        dataSource = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void close() {
        if(dataSource != null)
            dataSource.close();
    }

    public static DbUtils getInstance() {
        if (dbUtil == null) {
            dbUtil = new DbUtils();
        }
        return dbUtil;
    }

    public static Connection connectToDatabase() throws SQLException {
//        return DriverManager.getConnection(DATABASE_URL, DB_USERNAME, DB_PASSWORD);
        return getInstance().getConnection();
    }

}
