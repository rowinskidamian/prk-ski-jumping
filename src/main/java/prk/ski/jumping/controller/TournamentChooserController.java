package prk.ski.jumping.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.TournamentWorldCupDao;
import prk.ski.jumping.model.dao.impl.TournamentWorldCupDaoDefault;
import prk.ski.jumping.model.domain.TournamentWorldCup;


import java.io.IOException;
import java.util.List;

/**
 * @author RadosławParol
 */

@WebServlet(name = "TournamentChooserController", value = "/tournament_chooser")
public class TournamentChooserController extends HttpServlet {

    private final TournamentWorldCupDao twcDao = new TournamentWorldCupDaoDefault();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<TournamentWorldCup> tournaments = twcDao.getAll();
            request.setAttribute("tournaments", tournaments);

        } catch (DataBaseException ex) {
            String exMessage = ex.getMessage();
            request.setAttribute("message", exMessage);
            request.getRequestDispatcher("error_page.jsp")
                    .forward(request, response);
        }


        request.getRequestDispatcher("tournament_chooser.jsp").forward(request, response);
    }
}
