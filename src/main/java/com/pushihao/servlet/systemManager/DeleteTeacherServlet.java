package com.pushihao.servlet.systemManager;

import com.pushihao.service.teacher.TeacherService;
import com.pushihao.service.teacher.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherId = req.getParameter("teacherId");
        try {
            int _id = Integer.parseInt(teacherId);
            TeacherService service = new TeacherServiceImpl();
            boolean flag = service.deleteOneTeacherById(_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getSession().removeAttribute("teachers");
        resp.sendRedirect("./system-manager-show-servlet");
    }
}
