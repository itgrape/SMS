package com.pushihao.dao.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.pushihao.dao.BaseDao;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDaoImpl implements BaseDao {

    private static DataSource dataSource;

    static {
        //加载 Druid 配置文件
        InputStream inputStream = BaseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties druid = new Properties();

        try {
            druid.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //通过Druid连接池工厂类获取数据库连接池对象
        try {
            dataSource = DruidDataSourceFactory.createDataSource(druid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }

    @Override
    public ResultSet doQuery(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet, String sql, Object[] parameter){
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(sql);
                for (int i = 0; i < parameter.length; i++) {
                    preparedStatement.setObject(i + 1, parameter[i]);
                }
                resultSet = preparedStatement.executeQuery();
                return resultSet;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            //传入的connection为空
            throw new RuntimeException("Connection No Pointer Exception");
        }
    }

    @Override
    public int doUpdate(Connection connection, PreparedStatement preparedStatement, String sql, Object[] parameter) {
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(sql);
                for (int i = 0; i < parameter.length; i++) {
                    preparedStatement.setObject(i + 1, parameter[i]);
                }
                int rows = preparedStatement.executeUpdate();
                connection.commit();
                return rows;
            } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
                return 0;
            }
        } else {
            //传入的connection为空
            throw new RuntimeException("Connection No Pointer Exception");
        }
    }

    @Override
    public boolean freeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        boolean flag = true;
        if (connection != null) {
            try{
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
                flag = false;
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }
}
