package com.pushihao.service.student.impl;

import com.pushihao.dao.student.StudentDao;
import com.pushihao.dao.student.impl.StudentDaoImpl;
import com.pushihao.pojo.Student;
import com.pushihao.service.student.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDao dao;

    public StudentServiceImpl() {
        dao = new StudentDaoImpl();
    }
    @Override
    public int getTotalDataNum(String vagueName, String _class, String sex, String score) {
        if (sex != null) if (sex.equals("all")) sex = "";
        if (score != null) if (score.equals("all")) score = "";
        return dao.selectStudent(vagueName, _class, sex, score, null, null).size();
    }

    @Override
    public List<Student> selectStudent(String vagueName, String _class, String sex, String score, String startIndex, String num) {
        if (sex != null) if (sex.equals("all")) sex = "";
        if (score != null) if (score.equals("all")) score = "";
        return dao.selectStudent(vagueName, _class, sex, score, startIndex, num);
    }

    @Override
    public boolean deleteOneStudentById(int studentId) {
        Student delStudent = dao.selectOneStudentById(studentId);

        if (delStudent != null) {
            return dao.deleteOneStudent(delStudent);
        } else {
            return false;
        }
    }

    @Override
    public Student selectOneStudentById(int studentId) {
        return dao.selectOneStudentById(studentId);
    }

    @Override
    public boolean updateOneStudent(Student student) {
        if (student != null) {
            return dao.updateOneStudent(student);
        } else {
            return false;
        }
    }

    @Override
    public boolean addOneStudent(Student student) {
        if (student != null) {
            return dao.addOneStudent(student);
        } else {
            return false;
        }
    }
}
