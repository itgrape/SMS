package com.pushihao.servlet.teacher;

import com.pushihao.service.student.StudentService;
import com.pushihao.service.student.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");

        try {
            int _id = Integer.parseInt(studentId);
            StudentService service = new StudentServiceImpl();
            boolean flag = service.deleteOneStudentById(_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getSession().removeAttribute("students");
        resp.sendRedirect("./teacher-show-student-servlet");
    }
}
