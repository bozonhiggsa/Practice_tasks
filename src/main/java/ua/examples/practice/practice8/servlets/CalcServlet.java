package ua.examples.practice.practice8.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int number1 = Integer.parseInt(req.getParameter("x"));
        int number2 = Integer.parseInt(req.getParameter("y"));
        String operation = req.getParameter("op");

        int result = 0;

        if(operation.equals("plus")){
            result = number1 + number2;
        }
        else if(operation.equals("minus")){
            result = number1 - number2;
        }

        req.setAttribute("res", String.valueOf(result));

        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/CalcResult.jsp");
        dispatcher.forward(req, resp);
    }
}
