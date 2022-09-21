package com.pushihao.service.teacher.impl;

import com.pushihao.dao.teacher.TeacherDao;
import com.pushihao.dao.teacher.impl.TeacherDaoImpl;
import com.pushihao.pojo.Teacher;
import com.pushihao.service.teacher.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private final TeacherDao teacherDao;

    public TeacherServiceImpl() {
        teacherDao = new TeacherDaoImpl();
    }

    @Override
    public Teacher teacherLogin(String email, String password) {
        Teacher teacher = teacherDao.selectOneTeacherByEmail(email);
        if (teacher != null) {
            if (teacher.get_password().equals(password)) {
                return teacher;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean teacherRegist(Teacher teacher) {
        if (teacher != null) {
            String email = teacher.get_email();
            if (teacherDao.selectOneTeacherByEmail(email) != null) {
                //邮箱已经被注册使用
                return false;
            }
            return teacherDao.addOneTeacher(teacher);
        } else {
            return false;
        }
    }

    @Override
    public List<Teacher> selectTeachers(String _name, String _sex, String _class) {
        return teacherDao.selectTeachers(_name, _sex, _class);
    }

    @Override
    public int getTotalDataNum(String _name, String _sex, String _class) {
        return teacherDao.selectTeachers(_name, _sex, _class).size();
    }

    @Override
    public boolean deleteOneTeacherById(int id) {
        Teacher teacher = teacherDao.selectOneTeacherById(id);
        if (teacher != null) {
            return teacherDao.deleteOneTeacher(teacher);
        } else {
            return false;
        }
    }

    @Override
    public Teacher selectOneTeacherById(int id) {
        return teacherDao.selectOneTeacherById(id);
    }

    @Override
    public boolean updateOneTeacher(Teacher teacher) {
        if (teacher != null) {
            return teacherDao.updateOneTeacher(teacher);
        } else {
            return false;
        }
    }

    @Override
    public boolean addOneTeacher(Teacher teacher) {
        if (teacher != null) {
            return teacherDao.addOneTeacher(teacher);
        } else {
            return false;
        }
    }
}
