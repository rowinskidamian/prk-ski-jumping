package prk.ski.jumping.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import prk.ski.jumping.controller.analyzer.CountryAnalyzer;
import prk.ski.jumping.controller.parser.ResultParser;
import prk.ski.jumping.controller.parser.TournamentParser;
import prk.ski.jumping.exception.ParsingException;
import prk.ski.jumping.model.domain.Country;
import prk.ski.jumping.model.domain.TournamentJumperResult;
import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "TournamentChooserController", value = "/tournament_chooser")
public class TournamentChooserController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



//        TournamentParser tournamentParser = new TournamentParser();
//        String url = "https://www.fis-ski.com/DB/general/statistics.html?sectorcode=JP";
//
//        List<TournamentWorldCup> tournaments = tournamentParser.getTournamentList(url);
//        request.setAttribute("tournaments", tournaments);
//
//
        request.getRequestDispatcher("tournament_chooser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
