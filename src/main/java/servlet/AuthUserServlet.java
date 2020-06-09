package servlet;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AuthUserServlet", urlPatterns = "/auth")
public class AuthUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getParameter("login");
        String password = (String) req.getParameter("password");
        if (password.isEmpty() || login.isEmpty()) {
            req.setAttribute("message", "Your values is empty");
            getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
        }
        List<User> users = (List<User>) getServletContext().getAttribute("users");
        if (users.isEmpty()) {
            req.setAttribute("message", "User not found.");
            getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
        }
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                req.getSession().setAttribute("currentUser", user);
                getServletContext().getRequestDispatcher("/").forward(req, resp);
            }
        }

        req.setAttribute("message", "User not found!");
        getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);


    }
}
