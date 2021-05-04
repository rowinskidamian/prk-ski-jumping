package prk.ski.jumping.testing.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "checkboxServlet", value = "/checkbox")
public class CheckboxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String [] options = {"one", "two", "three"};
        request.setAttribute("options", options);
        request.getRequestDispatcher("/checkbox.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] options = request.getParameterValues("options");
        System.out.println(Arrays.toString(options));

    }
}
