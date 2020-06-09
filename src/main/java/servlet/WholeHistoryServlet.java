package servlet;

import entity.Operations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@WebServlet(urlPatterns = "/ahistory")
public class WholeHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> ahistory = (List<String>) req.getServletContext().getAttribute("ahistory");
        java.util.Collections.sort(ahistory);

        req.getServletContext().setAttribute("ahistory", ahistory);
        getServletContext().getRequestDispatcher("/pages/ahistory.jsp").forward(req, resp);
    }
}
