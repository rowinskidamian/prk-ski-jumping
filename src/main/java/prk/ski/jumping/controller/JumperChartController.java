package prk.ski.jumping.controller;

import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import prk.ski.jumping.model.domain.Jumper;
import prk.ski.jumping.model.domain.chart.JumperChart;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "JumperChartController", value = "/jumper_chart")
public class JumperChartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Jumper> jumperSessionList = (List<Jumper>) request.getSession().getAttribute("jumperChartList");

        List<JumperChart> jumperChartList = jumperSessionList.stream()
                .map(jumper -> new JumperChart(jumper.getAthleteName(), jumper.getTotalPoints()))
                .collect(Collectors.toList());

        Gson gson = new Gson();
        String jumperChartJSON = gson.toJson(jumperChartList);

        request.setAttribute("jumperJson", jumperChartJSON);

        request.getRequestDispatcher("jumper_chart.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
