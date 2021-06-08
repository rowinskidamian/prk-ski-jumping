package prk.ski.jumping.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import prk.ski.jumping.controller.analyzer.CountryAnalyzer;
import prk.ski.jumping.controller.analyzer.JumperAnalyzer;
import prk.ski.jumping.controller.parser.ParserService;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.TournamentJumperResultDao;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;
import prk.ski.jumping.model.domain.HistorySearch;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author RadosławParol
 */

@WebServlet(name = "selector_controller", value = "/selector_controller")
public class SelectorController extends HttpServlet {

    private List<Long> tournamentIds;
    private final JumperAnalyzer jumperAnalyzer = new JumperAnalyzer();
    private final CountryAnalyzer countryAnalyzer = new CountryAnalyzer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            //selected button (jumper or country)
        String jumper_btn = request.getParameter("jumper_btn");
        String country_btn = request.getParameter("country_btn");

        if (request.getParameterValues("tournament_id") == null) {
            request.setAttribute("message", "Musisz wybrać co najmniej jeden konkurs!");
            request.getRequestDispatcher("error_page.jsp").forward(request, response);
        }

            //list with ids of tournaments selected from checkboxes
        String[] selectedTournaments = request.getParameterValues("tournament_id");


        tournamentIds = new ArrayList<>();

        for (String s : selectedTournaments) tournamentIds.add(Long.parseLong(s));


            //set new tournamentIds in session
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


        // show jumper selection view
        if (jumper_btn != null) {
            createJumperSelectionView(request, response, tjrList);
        }

        // show country selection view
        if (country_btn != null) {
            createCountrySelectionView(request, response, tjrList);
        }
    }

    private void createCountrySelectionView(HttpServletRequest request, HttpServletResponse response, List<TournamentJumperResult> tjrList) throws ServletException, IOException {

        //use Analyzer to get set of jumpers to display in the view
        Set<String> analyzedCountries = countryAnalyzer.getCountryListForTournaments(tjrList);
        List<String> sortedList = new ArrayList<>(analyzedCountries);
        Collections.sort(sortedList);


        request.setAttribute("view", "country");
        request.setAttribute("items", sortedList);
        request.getRequestDispatcher("selector.jsp").forward(request, response);
    }

    private void createJumperSelectionView(HttpServletRequest request, HttpServletResponse response, List<TournamentJumperResult> tjrList) throws ServletException, IOException {

        //use Analyzer to get set of jumpers to display in the view
        Set<String> analyzedJumpers = jumperAnalyzer.getJumperNamesListForTournament(tjrList);
        List<String> sortedList = new ArrayList<>(analyzedJumpers);
        Collections.sort(sortedList);

        request.setAttribute("view", "jumper");
        request.setAttribute("items", sortedList);
        request.getRequestDispatcher("selector.jsp").forward(request, response);
    }
}
