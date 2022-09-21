package com.pushihao.dao.systemManager.impl;

import com.pushihao.dao.BaseDao;
import com.pushihao.dao.impl.BaseDaoImpl;
import com.pushihao.dao.systemManager.SystemManagerDao;
import com.pushihao.pojo.SystemManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SystemManagerDaoImpl implements SystemManagerDao {
    private final BaseDao baseDao;

    public SystemManagerDaoImpl() {
        baseDao = new BaseDaoImpl();
    }

    @Override
    public SystemManager getSystemManager() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT id,role,email,password FROM sms_teacher WHERE id=1";

        SystemManager manager = null;
        try {
            connection = baseDao.getConnection();
            resultSet = baseDao.doQuery(connection, preparedStatement, resultSet, sql, new Object[0]);
            if (resultSet != null) {
                manager = new SystemManager();
                while (resultSet.next()) {
                    manager.set_id(resultSet.getInt("id"));
                    manager.set_role(resultSet.getInt("role"));
                    manager.setEmail(resultSet.getString("email"));
                    manager.setPassword(resultSet.getString("password"));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            baseDao.freeResource(connection, preparedStatement, resultSet);
        }

        return manager;
    }
}
