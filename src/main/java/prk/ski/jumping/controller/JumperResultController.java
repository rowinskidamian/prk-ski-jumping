package prk.ski.jumping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import prk.ski.jumping.controller.analyzer.JumperAnalyzer;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.TournamentJumperResultDao;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;
import prk.ski.jumping.model.domain.Jumper;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "JumperResultController", value = "/jumper_result")
public class JumperResultController extends HttpServlet {

    private TournamentJumperResultDao tjrDao = new TournamentJumperResultDaoDefault();
    private JumperAnalyzer jumperAnalyzer = new JumperAnalyzer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> countryAthleteList = (List<String>) request.getAttribute("countryAthleteList");
        List<Long> tournamentIdList = (List<Long>) request.getAttribute("tournamentIdList");
        List<TournamentJumperResult> tjrList = getTJRfromTournamentId(tournamentIdList, request, response);

        List<Jumper> jumperList = jumperAnalyzer.getJumperAnalysisFor(tjrList, countryAthleteList);

//        test Jumper List
//        Jumper j1 = new Jumper();
//        j1.setBronzeMedals(2);
//        j1.setGoldMedals(3);
//        j1.setAthleteName("Damian Rowiński");
//        j1.setTotalPoints(100101);
//        j1.setOrigin("Polska");
//        j1.setIdHistory(1);
//
//        Jumper j2 = new Jumper();
//        j2.setBronzeMedals(111);
//        j2.setGoldMedals(22);
//        j2.setSilverMedals(99);
//        j2.setAthleteName("Jan Nowak");
//        j2.setTotalPoints(2323);
//        j2.setOrigin("Grecja");
//        j2.setIdHistory(2);
//        List<Jumper> jumperList = List.of(j1, j2);

        request.setAttribute("jumperList", jumperList);

        request.getRequestDispatcher("jumper_result.jsp")
                .forward(request, response);
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
