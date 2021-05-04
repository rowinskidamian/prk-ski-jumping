package prk.ski.jumping.testing.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@WebServlet(name = "jumperResultTest", value = "/jumperResultTest")
public class JumperResultTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> countryAthleteList = List.of("GEIGER Karl", "KOBAYASHI Ryoyu", "JOHANSSON Robert");
        List<Long> tournamentIdList = List.of(2L, 3L, 4L, 5L);
        request.setAttribute("countryAthleteList", countryAthleteList);
        request.setAttribute("tournamentIdList", tournamentIdList);

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

        request.getRequestDispatcher("/jumper_result")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
