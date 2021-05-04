package prk.ski.jumping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import prk.ski.jumping.controller.analyzer.JumperAnalyzer;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.HistorySearchDao;
import prk.ski.jumping.model.dao.TournamentJumperResultDao;
import prk.ski.jumping.model.dao.impl.HistorySearchDaoDefault;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;
import prk.ski.jumping.model.domain.HistorySearch;
import prk.ski.jumping.model.domain.Jumper;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "JumperResultController", value = "/jumper_result")
public class JumperResultController extends HttpServlet {

    private TournamentJumperResultDao tjrDao = new TournamentJumperResultDaoDefault();
    private HistorySearchDao hsDao = new HistorySearchDaoDefault();
    private JumperAnalyzer jumperAnalyzer = new JumperAnalyzer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hsParam = request.getParameter("historySearch");
        HistorySearch historySearch;
        List<String> countryAthleteList;
        List<Long> tournamentIdList;

        if (hsParam != null) {
           historySearch = getHistorySearch(request, response, hsParam);
            countryAthleteList = historySearch.getAthleteCountryList();
            tournamentIdList = historySearch.getTournamentIdList();

        } else {
            countryAthleteList = (List<String>) request.getAttribute("countryAthleteList");
            tournamentIdList = (List<Long>) request.getAttribute("tournamentIdList");
            historySearch = generateHistorySearch(countryAthleteList, tournamentIdList);
        }

        List<TournamentJumperResult> tjrList = getTJRfromTournamentId(tournamentIdList, request, response);
        List<Jumper> jumperList = jumperAnalyzer.getJumperAnalysisFor(tjrList, countryAthleteList);

        request.getSession()
                .setAttribute("historySearch", historySearch);
        request.setAttribute("jumperList", jumperList);

        request.getRequestDispatcher("jumper_result.jsp")
                .forward(request, response);
    }

    private HistorySearch getHistorySearch(HttpServletRequest request, HttpServletResponse response, String hsParam)
            throws ServletException, IOException {
        HistorySearch historySearch = new HistorySearch();

        try {
            Optional<HistorySearch> optionalHistorySearch = hsDao.getById(Long.parseLong(hsParam));
            historySearch = optionalHistorySearch
                    .orElseThrow(() -> new DataBaseException("Nie znaleziono wyszukiwania o podanym id."));

        } catch (DataBaseException ex) {
            String exMessage = ex.getMessage();
            request.setAttribute("message", exMessage);
            request.getRequestDispatcher("error_page.jsp")
                    .forward(request, response);
        }

        return historySearch;
    }

    private HistorySearch generateHistorySearch(List<String> countryAthleteList, List<Long> tournamentIdList) {
        HistorySearch historySearch = new HistorySearch();
        historySearch.setSearchType("Skoczek");
        historySearch.setAthleteCountryList(countryAthleteList);
        historySearch.setTournamentIdList(tournamentIdList);
        historySearch.setSearchDate(LocalDate.now());
        historySearch.setTournamentAmount(tournamentIdList.size());
        return historySearch;
    }

    private List<TournamentJumperResult> getTJRfromTournamentId(List<Long> tournamentIdList, HttpServletRequest request,
                                                                HttpServletResponse response) throws ServletException,
            IOException {
        List<TournamentJumperResult> outcome = new ArrayList<>();

        try {
            for (Long tournamentId : tournamentIdList) {
                List<TournamentJumperResult> tjrListCurrentTournament = tjrDao.getByTournamentId(tournamentId);
                outcome.addAll(tjrListCurrentTournament);
            }

        } catch (DataBaseException ex) {
            String exMessage = ex.getMessage();
            request.setAttribute("message", exMessage);
            request.getRequestDispatcher("error_page.jsp")
                    .forward(request, response);
        }
        return outcome;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
