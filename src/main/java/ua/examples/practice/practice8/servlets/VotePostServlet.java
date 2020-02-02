package ua.examples.practice.practice8.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class VotePostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> sports = (List<String>) getServletContext().getAttribute("sport");
        int[] votes = new int[sports.size()];

        for(int i = 0; i < sports.size(); i++){
            if(req.getParameter("by").equals(sports.get(i))){
                votes[i]++;
                break;
            }
        }

        getServletContext().setAttribute("votes", votes);

        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/result_vote"));
    }
}

