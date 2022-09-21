package com.pushihao.servlet.teacher;

import com.pushihao.pojo.Teacher;
import com.pushihao.service.teacher.TeacherService;
import com.pushihao.service.teacher.impl.TeacherServiceImpl;
import com.pushihao.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email;
        String password;
        TeacherService service = new TeacherServiceImpl();
        email = req.getParameter("email");
        password = req.getParameter("password");
        Teacher teacher = service.teacherLogin(email, password);
        if (teacher == null) {
            //登录失败
            System.out.println("登陆失败");
            req.getSession().setAttribute("errorMassage", "邮箱或密码错误，请重试");
            resp.sendRedirect("./../into/login.jsp");
        } else {
            //登陆成功
            System.out.println("登录成功");
            if (req.getSession().getAttribute(Constants.MANAGER) != null) {
                req.getSession().removeAttribute(Constants.MANAGER);
            }
            req.getSession().setAttribute(Constants.USER, teacher);
            req.getSession().setAttribute(Constants.CURRENT_PAGE, 1);
            resp.sendRedirect("./teacher-show-student-servlet");
        }
    }
}
