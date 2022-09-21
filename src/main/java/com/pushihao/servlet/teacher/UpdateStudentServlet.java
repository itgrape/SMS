package com.pushihao.servlet.teacher;

import com.pushihao.pojo.Student;
import com.pushihao.service.student.StudentService;
import com.pushihao.service.student.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = (Student) req.getSession().getAttribute("student");

        String _name = req.getParameter("name");
        String _ageTemp = req.getParameter("age");
        String _sex = req.getParameter("sex");
        String _scoreTemp = req.getParameter("score");
        String _classTemp = req.getParameter("class");
        String _phoneNumber = req.getParameter("phoneNumber");

        int _age = 0;
        double _score = 0;
        int _class = 0;
        try {
            _age = Integer.parseInt(_ageTemp);
            _score = Double.parseDouble(_scoreTemp);
            _class = Integer.parseInt(_classTemp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("./../servletError.jsp");
            return;
        }

        student.set_name(_name);
        student.set_age(_age);
        student.set_sex(_sex);
        student.set_score(_score);
        student.set_class(_class);
        student.set_phoneNumber(_phoneNumber);

        StudentService service = new StudentServiceImpl();
        boolean flag = service.updateOneStudent(student);

        if (flag) {
            resp.sendRedirect("./teacher-show-student-servlet");
        } else {
            resp.sendRedirect("./../servletError.jsp");
        }
    }
}
