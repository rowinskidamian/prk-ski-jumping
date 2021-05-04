package prk.ski.jumping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.HistorySearchDao;
import prk.ski.jumping.model.dao.impl.HistorySearchDaoDefault;
import prk.ski.jumping.model.domain.HistorySearch;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HistorySearchController", value = "/history_search")
public class HistorySearchController extends HttpServlet {

    private HistorySearchDao hsDao = new HistorySearchDaoDefault();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<HistorySearch> hsAll = hsDao.getAll();
            request.setAttribute("historyList", hsAll);

        } catch (DataBaseException ex) {
            String exMessage = ex.getMessage();
            request.setAttribute("message", exMessage);
            request.getRequestDispatcher("error_page.jsp")
                    .forward(request, response);
        }

        request.getRequestDispatcher("history_search.jsp")
        .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HistorySearch historySearch = (HistorySearch) request.getSession()
                .getAttribute("historySearch");

        String hsName = (String) request.getParameter("historySearchName");
        historySearch.setSearchName(hsName);

        try {
            hsDao.create(historySearch);
        } catch (DataBaseException ex) {
            String exMessage = ex.getMessage();
            request.setAttribute("message", exMessage);
            request.getRequestDispatcher("error_page.jsp")
                    .forward(request, response);
        }

        response.sendRedirect("/history_search");
    }

}
