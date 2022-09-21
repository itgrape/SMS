package com.pushihao.servlet.systemManager;

import com.pushihao.pojo.Teacher;
import com.pushihao.service.teacher.TeacherService;
import com.pushihao.service.teacher.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindTeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherId = req.getParameter("teacherId");
        TeacherService service = new TeacherServiceImpl();
        Teacher teacher = null;
        try {
            int _id = Integer.parseInt(teacherId);
            teacher = service.selectOneTeacherById(_id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (teacher != null) {
            req.getSession().setAttribute("teacher", teacher);
            resp.sendRedirect("./../jsp/modifyTeacher.jsp");
        } else {
            resp.sendRedirect("./../servletError.jsp");
        }
    }
}
