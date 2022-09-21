package com.pushihao.servlet.student;

import com.pushihao.pojo.Student;
import com.pushihao.service.student.StudentService;
import com.pushihao.service.student.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        StudentService service = new StudentServiceImpl();
        Student student = null;
        try {
            int _id = Integer.parseInt(studentId);
            student = service.selectOneStudentById(_id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (student != null) {
            req.getSession().setAttribute("student", student);
            resp.sendRedirect("./../jsp/modifyStudent.jsp");
        } else {
            resp.sendRedirect("./../servletError.jsp");
        }
    }
}
