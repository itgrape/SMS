package com.pushihao.servlet.systemManager;

import com.pushihao.pojo.Student;
import com.pushihao.pojo.Teacher;
import com.pushihao.service.student.StudentService;
import com.pushihao.service.student.impl.StudentServiceImpl;
import com.pushihao.service.teacher.TeacherService;
import com.pushihao.service.teacher.impl.TeacherServiceImpl;
import com.pushihao.util.Constants;
import com.pushihao.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SystemManagerShowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _name = req.getParameter("name");
        String _class = req.getParameter("class");
        String _role = req.getParameter("role");

        TeacherService teacherService = new TeacherServiceImpl();
        List<Teacher> teachers = teacherService.selectTeachers(_name, null, _class);

        //如果teachers为空，就将其设置为null，否则jsp页面会报错
        if (teachers.isEmpty()) teachers = null;
        req.getSession().setAttribute("teachers", teachers);
        PageSupport pageSupport = new PageSupport();
        pageSupport.setTotalDataNum(teacherService.getTotalDataNum(_name, null, _class));
        pageSupport.setCurrentPageNum((int) req.getSession().getAttribute(Constants.CURRENT_PAGE));

        req.getSession().setAttribute("startIndex", pageSupport.getIndex()[0]);
        req.getSession().setAttribute("endIndex", pageSupport.getIndex()[1]);
        req.getSession().setAttribute("pageSupport", pageSupport);

        resp.sendRedirect("./../jsp/adminMenu.jsp");
    }
}
