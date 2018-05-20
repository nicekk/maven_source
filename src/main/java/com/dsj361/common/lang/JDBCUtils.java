package com.dsj361.common.lang;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author wangkai
 * <p>
 * Create on 2018/3/13 22:57
 */
public class JDBCUtils {

    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    public static Connection getConnection()  {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void returnConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
