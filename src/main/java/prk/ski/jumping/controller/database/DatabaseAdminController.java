package prk.ski.jumping.controller.database;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.DBOperationsDao;
import prk.ski.jumping.model.dao.impl.DBOperationsDaoDefault;

import java.io.IOException;

/**
 * @author RadosławParol
 */

@WebServlet(name = "DatabaseAdminController", value = "/database_admin")
public class DatabaseAdminController extends HttpServlet {

    private final DBOperationsDao dbOperations = new DBOperationsDaoDefault();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int twc = dbOperations.getTotalTournamentNumber();
            int tjr = dbOperations.getTotalJumperResultsNumber();

            request.setAttribute("twc", twc);
            request.setAttribute("tjr", tjr);
        } catch (DataBaseException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("database_admin.jsp").forward(request, response);
    }
}
