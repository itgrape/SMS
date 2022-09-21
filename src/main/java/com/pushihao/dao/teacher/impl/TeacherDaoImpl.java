package com.pushihao.dao.teacher.impl;

import com.pushihao.dao.BaseDao;
import com.pushihao.dao.impl.BaseDaoImpl;
import com.pushihao.dao.teacher.TeacherDao;
import com.pushihao.pojo.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    private final BaseDao baseDao;

    public TeacherDaoImpl() {
        baseDao = new BaseDaoImpl();
    }

    @Override
    public Teacher selectOneTeacherById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM sms_teacher WHERE id=?";
        Object[] parameter = new Object[]{id};
        Teacher teacher = null;

        try{
            connection = baseDao.getConnection();
            resultSet = baseDao.doQuery(connection, preparedStatement, resultSet, sql, parameter);
            if (resultSet != null) {
                while(resultSet.next()){
                    teacher = new Teacher();
                    teacher.set_id(resultSet.getInt("id"));
                    teacher.set_email(resultSet.getString("email"));
                    teacher.set_age(resultSet.getInt("age"));
                    teacher.set_class(resultSet.getInt("class"));
                    teacher.set_name(resultSet.getString("name"));
                    teacher.set_password(resultSet.getString("password"));
                    teacher.set_sex(resultSet.getString("sex"));
                    teacher.set_role(resultSet.getInt("role"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baseDao.freeResource(connection, preparedStatement, resultSet);
        }

        return teacher;
    }

    @Override
    public Teacher selectOneTeacherByEmail(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM sms_teacher WHERE email=? AND id>1";
        Object[] parameter = new Object[]{email};
        Teacher teacher = null;

        try{
            connection = baseDao.getConnection();
            resultSet = baseDao.doQuery(connection, preparedStatement, resultSet, sql, parameter);
            if (resultSet != null) {
                while(resultSet.next()){
                    teacher = new Teacher();
                    teacher.set_id(resultSet.getInt("id"));
                    teacher.set_email(resultSet.getString("email"));
                    teacher.set_age(resultSet.getInt("age"));
                    teacher.set_class(resultSet.getInt("class"));
                    teacher.set_name(resultSet.getString("name"));
                    teacher.set_password(resultSet.getString("password"));
                    teacher.set_sex(resultSet.getString("sex"));
                    teacher.set_role(resultSet.getInt("role"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baseDao.freeResource(connection, preparedStatement, resultSet);
        }

        return teacher;
    }

    @Override
    public List<Teacher> selectTeachersByVagueName(String vagueName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM sms_teacher WHERE name LIKE ? AND id>1";
        Object[] parameter = new Object[]{'%' + vagueName + '%'};
        List<Teacher> teachers = null;

        try {
            connection = baseDao.getConnection();
            resultSet = baseDao.doQuery(connection, preparedStatement, resultSet, sql, parameter);

            if (resultSet != null) {
                teachers = new ArrayList<>();
                while (resultSet.next()) {
                    Teacher teacher = new Teacher();
                    teacher.set_id(resultSet.getInt("id"));
                    teacher.set_email(resultSet.getString("email"));
                    teacher.set_age(resultSet.getInt("age"));
                    teacher.set_class(resultSet.getInt("class"));
                    teacher.set_name(resultSet.getString("name"));
                    teacher.set_password(resultSet.getString("password"));
                    teacher.set_sex(resultSet.getString("sex"));
                    teacher.set_role(resultSet.getInt("role"));
                    teachers.add(teacher);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baseDao.freeResource(connection, preparedStatement, resultSet);
        }

        return teachers;
    }

    @Override
    public List<Teacher> selectTeachersByClass(int _class) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM sms_teacher WHERE class=? AND id>1";
        Object[] parameter = new Object[]{_class};
        List<Teacher> teachers = null;

        try {
            connection = baseDao.getConnection();
            resultSet = baseDao.doQuery(connection, preparedStatement, resultSet, sql, parameter);

            if (resultSet != null) {
                teachers = new ArrayList<>();
                while (resultSet.next()) {
                    Teacher teacher = new Teacher();
                    teacher.set_id(resultSet.getInt("id"));
                    teacher.set_email(resultSet.getString("email"));
                    teacher.set_age(resultSet.getInt("age"));
                    teacher.set_class(resultSet.getInt("class"));
                    teacher.set_name(resultSet.getString("name"));
                    teacher.set_password(resultSet.getString("password"));
                    teacher.set_sex(resultSet.getString("sex"));
                    teacher.set_role(resultSet.getInt("role"));
                    teachers.add(teacher);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baseDao.freeResource(connection, preparedStatement, resultSet);
        }

        return teachers;
    }

    @Override
    public List<Teacher> selectAllTeachers() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM sms_teacher WHERE id>1";
        List<Teacher> teachers = null;

        try {
            connection = baseDao.getConnection();
            resultSet = baseDao.doQuery(connection, preparedStatement, resultSet, sql, new Object[0]);

            if (resultSet != null) {
                teachers = new ArrayList<>();
                while (resultSet.next()) {
                    Teacher teacher = new Teacher();
                    teacher.set_id(resultSet.getInt("id"));
                    teacher.set_email(resultSet.getString("email"));
                    teacher.set_age(resultSet.getInt("age"));
                    teacher.set_class(resultSet.getInt("class"));
                    teacher.set_name(resultSet.getString("name"));
                    teacher.set_password(resultSet.getString("password"));
                    teacher.set_sex(resultSet.getString("sex"));
                    teacher.set_role(resultSet.getInt("role"));
                    teachers.add(teacher);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baseDao.freeResource(connection, preparedStatement, resultSet);
        }

        return teachers;
    }

    @Override
    public boolean updateOneTeacher(Teacher teacher) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE sms_teacher SET name=?,age=?,sex=?,class=?,role=?,email=?,password=? WHERE id=?";
        Object[] parameter = new Object[]{teacher.get_name(), teacher.get_age(), teacher.get_sex(), teacher.get_class()
        , teacher.get_role(), teacher.get_email(), teacher.get_password(), teacher.get_id()};
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
    public boolean addOneTeacher(Teacher teacher) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO sms_teacher(name, age, sex, class, role, email, password) values (?, ?, ?, ?, ?, ?, ?)";
        Object[] parameter = new Object[]{teacher.get_name(), teacher.get_age(), teacher.get_sex(), teacher.get_class()
        , teacher.get_role(), teacher.get_email(), teacher.get_password()};
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
    public boolean deleteOneTeacher(Teacher teacher) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM sms_teacher WHERE id=?";
        Object[] parameter = new Object[]{teacher.get_id()};
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
    public List<Teacher> selectTeachers(String _name, String _sex, String _class) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM sms_teacher WHERE id>1");
        List<Object> parameterList = new ArrayList<>();

        //拼装sql语句和参数
        if (_name != null && !_name.equals("")) {
            sql.append(" AND name LIKE ?");
            parameterList.add("%" + _name + "%");
        }
        if (_sex != null && !_sex.equals("")) {
            sql.append(" AND sex=?");
            parameterList.add(_sex);
        }
        if (_class != null && !_class.equals("")) {
            sql.append(" AND class=?");
            parameterList.add(_class);
        }
        Object[] parameter = parameterList.toArray();

        List<Teacher> teachers = null;
        System.out.println("sql:" + sql.toString());
        System.out.println("parameter:" + Arrays.toString(parameter));
        try {
            connection = baseDao.getConnection();
            resultSet = baseDao.doQuery(connection, preparedStatement, resultSet, sql.toString(), parameter);

            if (resultSet != null) {
                teachers = new ArrayList<>();
                while (resultSet.next()) {
                    Teacher teacher = new Teacher();
                    teacher.set_id(resultSet.getInt("id"));
                    teacher.set_name(resultSet.getString("name"));
                    teacher.set_age(resultSet.getInt("age"));
                    teacher.set_sex(resultSet.getString("sex"));
                    teacher.set_class(resultSet.getInt("class"));
                    teacher.set_role(1);
                    teacher.set_email(resultSet.getString("email"));
                    teacher.set_password(resultSet.getString("password"));
                    teachers.add(teacher);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baseDao.freeResource(connection, preparedStatement, resultSet);
        }
        return teachers;
    }
}
