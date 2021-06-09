package prk.ski.jumping;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import prk.ski.jumping.controller.utils.DbUtilities;

import java.sql.SQLException;

/**
 * @author DamianRowinski
 */

@WebListener
public class AppContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        try {
            DbUtilities.connectToDatabase();
            System.out.println("DB Connection initialized.");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        try {
            DbUtilities.close();
            System.out.println("DB Connection closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
