package com.pushihao.servlet.systemManager;

import com.pushihao.pojo.Teacher;
import com.pushihao.service.teacher.TeacherService;
import com.pushihao.service.teacher.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _name = req.getParameter("addName");
        String _ageTemp = req.getParameter("addAge");
        String _sex = req.getParameter("addSex");
        String _classTemp = req.getParameter("addClass");
        String _email = req.getParameter("addEmail");
        String _password = req.getParameter("addPassword");

        int _age = 0;
        int _class = 0;
        int _role = 1;

        try {
            _age = Integer.parseInt(_ageTemp);
            _class = Integer.parseInt(_classTemp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("./../servletError.jsp");
            return;
        }

        Teacher teacher = new Teacher();
        teacher.set_name(_name);
        teacher.set_age(_age);
        teacher.set_sex(_sex);
        teacher.set_class(_class);
        teacher.set_role(_role);
        teacher.set_email(_email);
        teacher.set_password(_password);
        TeacherService service = new TeacherServiceImpl();
        boolean flag = service.addOneTeacher(teacher);

        if (flag) {
            resp.sendRedirect("./system-manager-show-servlet");
        } else {
            resp.sendRedirect("./../servletError.jsp");
        }
    }
}
