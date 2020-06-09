package servlet;

import action.Calculator;
import entity.User;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/calc", name = "CalcServlet")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("currentUser") != null) {
            getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, resp);
        } else {
            resp.getWriter().println("User not found");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String num1 = req.getParameter("num1");
        String operation = req.getParameter("operation");
        String num2 = req.getParameter("num2");
        if (num1.isEmpty() || num2.isEmpty() || operation.isEmpty()) {
            req.setAttribute("answer", "Your values are empty");
            req.getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, resp);
        }
        double answer = Calculator.calculator(Double.parseDouble(num1), Double.parseDouble(num2), operation);


        List<String> history = (List) req.getSession().getAttribute("history");
        String opString = num1 + " " + Calculator.getSymbol(operation) + " " + num2 + " " + " = " + answer;
        history.add(opString);
        List<String> ahistory = (List) req.getServletContext().getAttribute("ahistory");

        ahistory.add(opString);
        ahistory.sort(String::compareTo);
        req.setAttribute("answer", answer);
        getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, resp);

    }
}
