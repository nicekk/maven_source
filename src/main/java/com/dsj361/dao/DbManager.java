package com.dsj361.dao;

import com.dsj361.common.enums.ModeEnum;
import com.dsj361.common.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author wangkai
 * @date 2018/11/12 16:03
 */
public class DbManager {

    private static final Logger log = Logger.getLogger(DbManager.class);

    private static ModeEnum mode;

    public static void init(ModeEnum mode) {
        DbManager.mode = mode;
    }

    /**
     * 获取一个连接
     *
     * @return
     */
    public static Connection getConnection() {
        if (mode == null) {
            log.error("mode为null，请调用init()方法设置!");
            return null;
        }
        Properties prop = new Properties();
        String configFileName = "db_" + mode.name().toLowerCase() + ".config";
        InputStream is = DbManager.class.getClassLoader().getResourceAsStream(configFileName);
        try {
            prop.load(is);
        } catch (IOException e) {
            log.error("加载配置异常！", e);
            return null;
        }
        String userName = prop.getProperty("username");
        String password = prop.getProperty("password");
        String url = prop.getProperty("url");
        String driverName = prop.getProperty("driverName");

        Connection connection;
        try {
            // 加载驱动
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            log.error("获取连接异常!", e);
            return null;
        }
        return connection;
    }

    /**
     * 关闭连接
     *
     * @param connection
     */
    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            log.error("关闭连接异常", e);
        }
    }
}
