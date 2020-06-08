package filter;

import entity.User;
import servlet.AuthUserServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", servletNames = "AuthUserServlet")
public class Filter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User currentUser = (User) req.getAttribute("currentUser");
        if (currentUser == null) {
            chain.doFilter(req, res);
        } else {
            req.setAttribute("message", "No.");
            getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, res);
        }

    }
}
