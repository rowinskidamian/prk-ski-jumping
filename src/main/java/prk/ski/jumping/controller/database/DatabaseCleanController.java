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

@WebServlet(name = "DatabaseCleanController", value = "/database_clean")
public class DatabaseCleanController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DBOperationsDao dbOperations = new DBOperationsDaoDefault();
            dbOperations.cleanDatabase();
        } catch (DataBaseException ex) {
            String exMessage = ex.getMessage();
            request.setAttribute("message", exMessage);
            request.getRequestDispatcher("error_page.jsp")
                    .forward(request, response);
        }
        response.sendRedirect("/database_admin");
    }
}
