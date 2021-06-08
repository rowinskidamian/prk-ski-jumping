package prk.ski.jumping.controller.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author DamianRowinski
 */

public class DbUtilities {
    private static DataSource dataSource;

    private static DataSource getInstance() {
        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                dataSource = (DataSource) envContext.lookup("jdbc/prk-ski-jumping");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }

    public static Connection connectToDatabase() throws SQLException {
        return getInstance().getConnection();
    }

    public static void close() throws SQLException {
        if (dataSource != null)
            dataSource.getConnection().close();
    }
}
