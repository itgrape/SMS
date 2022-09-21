package com.pushihao.servlet.teacher;

import com.pushihao.pojo.Teacher;
import com.pushihao.service.teacher.TeacherService;
import com.pushihao.service.teacher.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeacherService service = new TeacherServiceImpl();

        Teacher teacher = new Teacher();
        String _name = req.getParameter("name");
        String _age = req.getParameter("age");
        String _sex = req.getParameter("sex");
        String _class = req.getParameter("class");
        int _role = 1;
        String _email = req.getParameter("email");
        String _password = req.getParameter("password");


        //过滤掉不合法信息
        if (isEmpty(_name) || isEmpty(_age) || isEmpty(_sex) || isEmpty(_class) || isEmpty(_email) || isEmpty(_password)) {
            req.getSession().setAttribute("errorMassage", "以上内容均为必填项，请认真填写");
            resp.sendRedirect("./../into/regist.jsp");
            return;
        }

        int real_age = Integer.parseInt(_age);
        int real_class = Integer.parseInt(_class);

        if (_name.length() > 10 || real_age < 1 || real_age > 60 || real_class < 1 || real_class > 8
        || _password.length() < 5 || _password.length() > 20) {
            req.getSession().setAttribute("errorMassage", "填写信息有误，如有特殊需求请联系管理员");
            resp.sendRedirect("./../into/regist.jsp");
            return;
        }

        teacher.set_name(_name);
        teacher.set_age(real_age);
        teacher.set_sex(_sex);
        teacher.set_class(real_class);
        teacher.set_role(_role);
        teacher.set_email(_email);
        teacher.set_password(_password);

        boolean result = service.teacherRegist(teacher);

        if (result) {
            req.getSession().setAttribute("errorMassage", "注册成功，请登录");
            resp.sendRedirect("./../into/login.jsp");
        } else {
            req.getSession().setAttribute("errorMassage", "注册失败，请检查是否有违法信息");
            resp.sendRedirect("./../into/regist.jsp");
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.equals("") || str.equals(" ");
    }
}
