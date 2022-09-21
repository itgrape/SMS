package com.pushihao.dao;

import com.pushihao.pojo.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseDao {

    /**得到一个数据库连接对象，底层使用Druid连接池
     * @return 一个数据库连接对象
     * */
    public Connection getConnection() throws SQLException;

    /**进行数据库的查询操作
     * @param connection 数据库连接对象
     * @param preparedStatement 预编译执行者对象
     * @param resultSet 结果集
     * @param sql 要执行的sql语句
     * @param parameter sql语句的参数
     * @return 执行sql语句返回的结果集
     * */
    public ResultSet doQuery(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet, String sql, Object[] parameter) throws SQLException;

    /**进行数据库的增删改操作
     *@param connection 数据库连接对象
     *@param preparedStatement 预编译执行者对象
     *@param sql 要执行的sql语句
     *@param parameter sql语句的参数
     *@return 返回执行sql语句影响的数据库的行数
     * */
    public int doUpdate(Connection connection, PreparedStatement preparedStatement, String sql, Object[] parameter);

    /**释放资源
     * @param connection 数据库连接对象
     * @param preparedStatement 预编译执行者对象
     * @param resultSet 结果集
     * @return 如果都释放成功返回true，有一个失败则返回false
     * */
    public boolean freeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet);

}
