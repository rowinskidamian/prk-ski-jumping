package prk.ski.jumping.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "JumperResultControllerg", value = "/jumper_result")
public class JumperResultController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("fromInput", request.getParameter("pole"));
        request.getRequestDispatcher("jumper_result.jsp").forward(request, response);
    }
}
