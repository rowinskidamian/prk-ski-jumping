package prk.ski.jumping.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import prk.ski.jumping.controller.analyzer.JumperAnalyzer;
import prk.ski.jumping.controller.parser.ParserService;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.TournamentJumperResultDao;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;
import prk.ski.jumping.model.domain.HistorySearch;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.io.IOException;
import java.util.*;

@WebServlet(name = "selector_controller", value = "/selector_controller")
public class SelectorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //list with ids of tournaments selected from checkboxes
        List<String> selectedTournaments = Arrays.asList(request.getParameterValues("tournament_id"));
        List<Long> tournamentIds = new ArrayList<>();
        for (String s : selectedTournaments) tournamentIds.add(Long.parseLong(s));

        request.getSession().setAttribute("tournamentIdList", tournamentIds);

        //list with every jumper from every tournament
        List<TournamentJumperResult> tjrList = new ArrayList<>();
        TournamentJumperResultDao tjrDao = new TournamentJumperResultDaoDefault();
        //loop over all selected tournaments
        for (Long id : tournamentIds) {

            //get list of jumpers from n-tournament
            List<TournamentJumperResult> list = null;
            try {
                list = tjrDao.getByTournamentId(id);
            } catch (DataBaseException e) {
                e.printStackTrace();
            }

            //add every jumper from n-tournament to list with all jumpers from all selected tournaments
            for (TournamentJumperResult tjr : list) {
                tjrList.add(tjr);
            }
        }
        //use Analyzer to get set of jumpers to display in the view
        JumperAnalyzer analyzer = new JumperAnalyzer();
        Set<String> analyzedJumpers = analyzer.getJumperNamesListForTournament(tjrList);


        request.setAttribute("analyzedJumpers", analyzedJumpers);
        request.getRequestDispatcher("selector.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
