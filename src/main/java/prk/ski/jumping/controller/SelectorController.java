package prk.ski.jumping.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import prk.ski.jumping.controller.analyzer.JumperAnalyzer;
import prk.ski.jumping.controller.parser.ParserService;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.TournamentJumperResultDao;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@WebServlet(name = "selector_controller", value = "/selector_controller")
public class SelectorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            //list with ids of tournaments selected from checkboxes
        List<String> tournamentIds = Arrays.asList(request.getParameterValues("tournament_id"));

            //list with every jumper from every tournament
        List<TournamentJumperResult> tjrList = new ArrayList<>();
        TournamentJumperResultDao tjrDao = new TournamentJumperResultDaoDefault();
            //loop over all selected tournaments
        for (String s : tournamentIds) {
            long tournamentId = Long.parseLong(s);

            //get list of jumpers from n-tournament
            List<TournamentJumperResult> list = null;
            try {
                list = tjrDao.getByTournamentId(tournamentId);
            } catch (DataBaseException e) {
                    e.printStackTrace();
                }

                //add every jumper from n-tournament to list with all jumpers from all selected tournaments
                for (TournamentJumperResult t : list) {
                    tjrList.add(t);
                }
            }
                //use Analyzer to get set of jumpers to display in the view
        JumperAnalyzer analyzer = new JumperAnalyzer();Set<String> analyzedJumpers = analyzer.getJumperNamesListForTournament(tjrList);


        request.setAttribute("tournamentIds", tournamentIds);
        request.setAttribute("analyzedJumpers", analyzedJumpers);
        request.getRequestDispatcher("jumper_selector.jsp").forward(request, response);




    }
}
