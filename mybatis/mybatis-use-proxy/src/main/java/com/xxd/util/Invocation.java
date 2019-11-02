package com.xxd.util;

import com.xxd.dao.SqlSession;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Invocation implements InvocationHandler {
    Connection connection;
    PreparedStatement preparedStatement;
    private SqlSession obj; // 被监控的对象

    public Invocation(SqlSession obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value;
        // 初次JDBC次要业务
        init();
        Field ps = obj.getClass().getDeclaredField("ps");
        ps.setAccessible(true);
        ps.set(obj,preparedStatement);

        // 主要业务
        value = method.invoke(obj, args);

        // 次要业务
        close();
        return value;
    }

    private void init() throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 建立连接通道
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irving", "root", "123456");
        // 建立PreparedStament
        preparedStatement = connection.prepareStatement("");

    }

    private void close() throws SQLException {
        // 销毁连接通道
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
