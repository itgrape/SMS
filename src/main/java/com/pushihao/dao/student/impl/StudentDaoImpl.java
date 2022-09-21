package com.pushihao.dao.student.impl;

import com.pushihao.dao.BaseDao;
import com.pushihao.dao.impl.BaseDaoImpl;
import com.pushihao.dao.student.StudentDao;
import com.pushihao.pojo.Student;
import com.pushihao.pojo.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private final BaseDao baseDao;

    public StudentDaoImpl() {
        baseDao = new BaseDaoImpl();
    }

    @Override
    public List<Student> selectStudent(String vagueName, String _class, String sex, String score, String startIndex, String num) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM sms_student WHERE id>0");
        List<Object> parameterList = new ArrayList<>();

        //拼装sql语句和参数
        if (vagueName != null && !vagueName.equals("")) {
            sql.append(" AND name LIKE ?");
            parameterList.add("%" + vagueName + "%");
        }
        if (_class != null && !_class.equals("")) {
            sql.append(" AND class=?");
            parameterList.add(_class);
        }
        if (sex != null && !sex.equals("")) {
            sql.append(" AND sex=?");
            parameterList.add(sex);
        }
        if (score != null && !score.equals("")) {
            if (score.equals("failed")) {
                sql.append(" AND score<60");
            } else if (score.equals("passed")) {
                sql.append(" AND score>=60");
            }
        }
        if (startIndex != null && !startIndex.equals("") && num != null && !num.equals("")) {
            sql.append(" LIMIT ?,?");
            parameterList.add(Integer.parseInt(startIndex));
            parameterList.add(Integer.parseInt(num));
        }

        Object[] parameter = parameterList.toArray();
        List<Student> students = null;
        System.out.println("sql:" + sql.toString());
        System.out.println("parameter:" + Arrays.toString(parameter));
        try {
            connection = baseDao.getConnection();
            resultSet = baseDao.doQuery(connection, preparedStatement, resultSet, sql.toString(), parameter);

            if (resultSet != null) {
                students = new ArrayList<>();
                while (resultSet.next()) {
                    Student student = new Student();
                    student.set_id(resultSet.getInt("id"));
                    student.set_name(resultSet.getString("name"));
                    student.set_age(resultSet.getInt("age"));
                    student.set_sex(resultSet.getString("sex"));
                    student.set_score(resultSet.getDouble("score"));
                    student.set_class(resultSet.getInt("class"));
                    student.set_role(resultSet.getInt("role"));
                    student.set_phoneNumber(resultSet.getString("phoneNumber"));
                    students.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baseDao.freeResource(connection, preparedStatement, resultSet);
        }
        return students;
    }

    @Override
    public Student selectOneStudentById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM sms_student WHERE id=?";
        Object[] parameter = new Object[]{id};
        Student student = null;

        try{
            connection = baseDao.getConnection();
            resultSet = baseDao.doQuery(connection, preparedStatement, resultSet, sql, parameter);
            if (resultSet != null) {
                while(resultSet.next()){
                    student = new Student();
                    student.set_id(resultSet.getInt("id"));
                    student.set_name(resultSet.getString("name"));
                    student.set_age(resultSet.getInt("age"));
                    student.set_sex(resultSet.getString("sex"));
                    student.set_score(resultSet.getDouble("score"));
                    student.set_class(resultSet.getInt("class"));
                    student.set_role(resultSet.getInt("role"));
                    student.set_phoneNumber(resultSet.getString("phoneNumber"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baseDao.freeResource(connection, preparedStatement, resultSet);
        }

        return student;
    }

    @Override
    public boolean deleteOneStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM sms_student WHERE id=?";
        Object[] parameter = new Object[]{student.get_id()};
        int rows = 0;

        try {
            connection = baseDao.getConnection();
            rows = baseDao.doUpdate(connection, preparedStatement, sql, parameter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baseDao.freeResource(connection, preparedStatement, null);
        }
        return rows == 1;
    }

    @Override
    public boolean updateOneStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE sms_student SET name=?,age=?,sex=?,score=?,class=?,role=?,phoneNumber=? WHERE id=?";
        Object[] parameter = new Object[]{student.get_name(), student.get_age(), student.get_sex(), student.get_score()
                , student.get_class(), student.get_role(), student.get_phoneNumber(), student.get_id()};
        int rows = 0;

        try {
            connection = baseDao.getConnection();
            rows = baseDao.doUpdate(connection, preparedStatement, sql, parameter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baseDao.freeResource(connection, preparedStatement, null);
        }

        return rows == 1;
    }

    @Override
    public boolean addOneStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO sms_student (NAME, age, sex, score, class, role, phoneNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Object[] parameter = new Object[]{student.get_name(), student.get_age(), student.get_sex(), student.get_score()
                , student.get_class(), student.get_role(), student.get_phoneNumber()};
        int rows = 0;

        try {
            connection = baseDao.getConnection();
            rows = baseDao.doUpdate(connection, preparedStatement, sql, parameter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baseDao.freeResource(connection, preparedStatement, null);
        }

        return rows == 1;
    }
}
