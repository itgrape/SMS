package com.pushihao.servlet.teacher;

import com.pushihao.pojo.Student;
import com.pushihao.pojo.Teacher;
import com.pushihao.service.student.StudentService;
import com.pushihao.service.student.impl.StudentServiceImpl;
import com.pushihao.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _name = req.getParameter("addName");
        String _ageTemp = req.getParameter("addAge");
        String _sex = req.getParameter("addSex");
        String _scoreTemp = req.getParameter("addScore");
        String _phoneNumber = req.getParameter("addPhoneNumber");

        Teacher teacher = (Teacher) req.getSession().getAttribute(Constants.USER);
        int _class = teacher.get_class();
        int _age = 0;
        double _score = 0;
        int _role = 2;

        try {
            _age = Integer.parseInt(_ageTemp);
            _score = Double.parseDouble(_scoreTemp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("./../servletError.jsp");
            return;
        }

        Student student = new Student();
        student.set_name(_name);
        student.set_age(_age);
        student.set_sex(_sex);
        student.set_score(_score);
        student.set_class(_class);
        student.set_role(_role);
        student.set_phoneNumber(_phoneNumber);

        StudentService service = new StudentServiceImpl();
        boolean flag = service.addOneStudent(student);

        if (flag) {
            resp.sendRedirect("./teacher-show-student-servlet");
        } else {
            resp.sendRedirect("./../servletError.jsp");
        }
    }
}
