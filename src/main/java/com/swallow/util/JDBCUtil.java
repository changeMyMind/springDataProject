package com.swallow.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类：
 * 1) 获取Connection
 * 2) 释放资源
 */
public class JDBCUtil {

    /**
     * 获取Connection
     * @return 所获得的JDBC的Connection
     */
    public static Connection getConnection() throws Exception {
        /*读取resources中的具体文件*/
        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        /*使用properties加载输入流*/
        Properties properties = new Properties();
        properties.load(inputStream);
        String url = (String)properties.get("jdbc.url");
        String user = (String)properties.get("jdbc.user");
        String password = (String)properties.get("jdbc.password");
        String driverClass = (String)properties.get("jdbc.driverClass");
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /**
     * 释放资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet, Statement statement,Connection connection){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
