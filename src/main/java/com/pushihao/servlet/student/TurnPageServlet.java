package com.pushihao.servlet.student;

import com.pushihao.util.Constants;
import com.pushihao.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TurnPageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("do");
        int currentPage = (int) req.getSession().getAttribute(Constants.CURRENT_PAGE);
        PageSupport pageSupport = (PageSupport) req.getSession().getAttribute("pageSupport");
        if (method.equals("up")) {
            currentPage--;
            if (currentPage < 1) currentPage = 1;
        }
        if (method.equals("down")) {
            currentPage++;
            if (currentPage > pageSupport.getTotalPageNum()) currentPage = pageSupport.getTotalPageNum();
        }
        if (method.equals("jump")) {
            try {
                int tempCurrentPage = Integer.parseInt(req.getParameter("pageNum"));
                if (tempCurrentPage >= 1 && tempCurrentPage <= pageSupport.getTotalPageNum()) {
                    currentPage = tempCurrentPage;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        req.getSession().setAttribute(Constants.CURRENT_PAGE, currentPage);

        pageSupport.setCurrentPageNum(currentPage);
        req.getSession().setAttribute("startIndex", pageSupport.getIndex()[0]);
        req.getSession().setAttribute("endIndex", pageSupport.getIndex()[1]);

        if (req.getSession().getAttribute(Constants.USER) != null) {
            resp.sendRedirect("./../jsp/menu.jsp");
            return;
        }
        if (req.getSession().getAttribute(Constants.MANAGER) != null) {
            resp.sendRedirect("./../jsp/adminMenu.jsp");
        }
    }
}
