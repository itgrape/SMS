package com.pushihao.servlet.systemManager;

import com.pushihao.pojo.SystemManager;
import com.pushihao.service.systemManager.SystemManagerService;
import com.pushihao.service.systemManager.impl.SystemManagerServiceImpl;
import com.pushihao.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SystemManagerLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email;
        String password;
        SystemManagerService service = new SystemManagerServiceImpl();
        email = req.getParameter("email");
        password = req.getParameter("password");
        SystemManager manager = service.systemManagerLogin(email, password);
        if (manager == null) {
            //登录失败
            System.out.println("登陆失败");
            req.getSession().setAttribute("errorMassage", "邮箱或密码错误，请重试");
            resp.sendRedirect("./../index.jsp");
        } else {
            //登陆成功
            System.out.println("登录成功");
            if (req.getSession().getAttribute(Constants.USER) != null) {
                req.getSession().removeAttribute(Constants.USER);
            }
            req.getSession().setAttribute(Constants.CURRENT_PAGE, 1);
            req.getSession().setAttribute(Constants.MANAGER, manager);
            resp.sendRedirect("./system-manager-show-servlet");
        }
    }
}
