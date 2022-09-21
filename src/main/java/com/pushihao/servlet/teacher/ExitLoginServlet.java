package com.pushihao.servlet.teacher;

import com.pushihao.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExitLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute(Constants.MANAGER) != null) {
            req.getSession().removeAttribute(Constants.MANAGER);
            req.getSession().removeAttribute("teachers");
            resp.sendRedirect("./../index.jsp");
            return;
        }

        if (req.getSession().getAttribute(Constants.USER) != null) {
            req.getSession().removeAttribute(Constants.USER);
            req.getSession().removeAttribute("students");
            resp.sendRedirect("./../into/login.jsp");
        }
    }
}
