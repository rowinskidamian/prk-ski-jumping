package prk.ski.jumping.controller.database;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import prk.ski.jumping.controller.parser.ParserService;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.TournamentWorldCupDao;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;
import prk.ski.jumping.model.dao.impl.TournamentWorldCupDaoDefault;
import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.io.IOException;
import java.util.List;

/**
 * @author DamianRowinski
 *
 * servlet address:/database_load_small, accepts param /database_load_small?maxTournaments=number
 */

@WebServlet(name = "DatabaseLoadSmallController", value = "/database_load_small")
public class DatabaseLoadSmallController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "https://www.fis-ski.com/DB/general/statistics.html?sectorcode=JP";
        String maxTournamentAmount = request.getParameter("tournamentAmount");
        int maxTournaments = 5;
        try{
            maxTournaments = Integer.parseInt(maxTournamentAmount);
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }

        TournamentWorldCupDao twcDao = new TournamentWorldCupDaoDefault();

        ParserService parserService = new ParserService();
        parserService.setTournamentWorldCupDao(twcDao);
        try {
            parserService.addSmallTournamentListByURL(url, maxTournaments);
            parserService.setTournamentJumperResultDao(new TournamentJumperResultDaoDefault());
            List<TournamentWorldCup> twcList = twcDao.getAll();

            for (TournamentWorldCup t : twcList) {
                long twcId = t.getId();
                String twcLink = t.getLink();

                parserService.addResultListByTournamentURL(twcLink, twcId);
            }

        } catch (DataBaseException ex) {
            String exMessage = ex.getMessage();
            request.setAttribute("message", exMessage);
            request.getRequestDispatcher("error_page.jsp")
                    .forward(request, response);
        }

        response.sendRedirect("./database_admin");

    }
}
