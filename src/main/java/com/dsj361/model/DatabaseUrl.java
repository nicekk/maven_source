package com.dsj361.model;

import com.dsj361.common.enums.DatabaseTypeEnum;
import com.dsj361.common.model.BaseModel;

/**
 * 数据库连接
 *
 * @author wangkai
 * @date 2018/11/12 15:55
 */
public class DatabaseUrl extends BaseModel {

    /**
     * 数据库别名
     */
    private String alias;

    /**
     * 数据库类型
     */
    private DatabaseTypeEnum type;

    /**
     * ip
     */
    private String host;

    /**
     * 端口号
     */
    private String port;

    /**
     * dsn名字
     */
    private String dsnName;

    /**
     * 数据库实例名
     */
    private String dbName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 驱动类
     */
    private String driverClass;

    /**
     * jdbc url
     */
    private String jdbcUrl;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public DatabaseTypeEnum getType() {
        return type;
    }

    public void setType(DatabaseTypeEnum type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDsnName() {
        return dsnName;
    }

    public void setDsnName(String dsnName) {
        this.dsnName = dsnName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }
}
