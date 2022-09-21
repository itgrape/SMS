package com.pushihao.servlet.student;

import com.pushihao.pojo.Student;
import com.pushihao.pojo.Teacher;
import com.pushihao.service.student.StudentService;
import com.pushihao.service.student.impl.StudentServiceImpl;
import com.pushihao.util.Constants;
import com.pushihao.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TeacherShowStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _name = req.getParameter("name");
        String _sex = req.getParameter("sex");
        String _score = req.getParameter("score");
        Teacher teacher = (Teacher) req.getSession().getAttribute(Constants.USER);
        String _class = new String(String.valueOf(teacher.get_class()));

        StudentService service = new StudentServiceImpl();
        List<Student> students = service.selectStudent(_name, _class, _sex, _score, null, null);
        if (students.isEmpty()) students = null;
        req.getSession().setAttribute("students", students);


        PageSupport pageSupport = new PageSupport();
        pageSupport.setTotalDataNum(service.getTotalDataNum(_name, _class, _sex, _score));
        req.getSession().setAttribute("pageSupport", pageSupport);

        pageSupport.setCurrentPageNum((int) req.getSession().getAttribute(Constants.CURRENT_PAGE));
        req.getSession().setAttribute("startIndex", pageSupport.getIndex()[0]);
        req.getSession().setAttribute("endIndex", pageSupport.getIndex()[1]);
        resp.sendRedirect("./../jsp/menu.jsp");
    }
}
