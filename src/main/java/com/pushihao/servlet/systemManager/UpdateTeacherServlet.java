package com.pushihao.servlet.systemManager;

import com.pushihao.pojo.Teacher;
import com.pushihao.service.teacher.TeacherService;
import com.pushihao.service.teacher.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateTeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = (Teacher) req.getSession().getAttribute("teacher");

        String _name = req.getParameter("name");
        String _ageTemp = req.getParameter("age");
        String _sex = req.getParameter("sex");
        String _classTemp = req.getParameter("class");
        String _email = req.getParameter("email");
        String _password = req.getParameter("password");

        int _age = 0;
        int _class = 0;
        try {
            _age = Integer.parseInt(_ageTemp);
            _class = Integer.parseInt(_classTemp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("./../servletError.jsp");
            return;
        }

        teacher.set_name(_name);
        teacher.set_age(_age);
        teacher.set_sex(_sex);
        teacher.set_class(_class);
        teacher.set_email(_email);
        teacher.set_password(_password);

        TeacherService service = new TeacherServiceImpl();
        boolean flag = service.updateOneTeacher(teacher);

        if (flag) {
            resp.sendRedirect("./system-manager-show-servlet");
        } else {
            resp.sendRedirect("./../servletError.jsp");
        }
    }
}
