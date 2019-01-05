package com.dsj361.dao;

import com.dsj361.common.enums.DatabaseTypeEnum;
import com.dsj361.common.enums.ModeEnum;
import com.dsj361.model.DatabaseUrl;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangkai
 * @date 2018/11/12 16:22
 */
public class DatabaseUrlConfigDAO {

    private static final Logger log = Logger.getLogger(DatabaseUrlConfigDAO.class);

    /**
     * 根据别名获取配置
     *
     * @param dbAlias
     * @return
     */
    public DatabaseUrl getDatabaseUrlByAlias(ModeEnum mode, String dbAlias) {
        DbManager.init(mode);
        Connection connection = DbManager.getConnection();
        if (connection == null) {
            log.error("获取连接异常!");
            return null;
        }
        try {
            PreparedStatement ps = connection.prepareStatement("select * from database_url_config where alias = '" + dbAlias + "' and enabled=1");
            ResultSet rs = ps.executeQuery();
            DatabaseUrl databaseUrl = null;
            while (rs.next()) {
                databaseUrl = convertResultSet(rs);
            }
            DbManager.close(connection);
            return databaseUrl;
        } catch (Exception e) {
            log.error("查询数据库异常，", e);
            return null;
        }
    }

    /**
     * 根据一组别名查找
     *
     * @param mode
     * @param alias
     * @return
     */
    public List<DatabaseUrl> getDatabaseUrlsByAlias(ModeEnum mode, List<String> alias) {
        DbManager.init(mode);
        Connection connection = DbManager.getConnection();
        if (connection == null) {
            log.error("获取连接异常!");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("'");
        for (int i = 0; i < alias.size(); i++) {
            sb.append(alias.get(i));
            if (i < alias.size() - 1) {
                sb.append("','");
            }
        }
        sb.append("'");
        String aliasJoin = sb.toString();
        System.out.println(aliasJoin);
        try {
            PreparedStatement ps = connection.prepareStatement("select * from database_url_config where alias in (" + aliasJoin + ") and enabled=1");
            ResultSet rs = ps.executeQuery();
            List<DatabaseUrl> urls = new ArrayList<>();
            while (rs.next()) {
                DatabaseUrl databaseUrl = convertResultSet(rs);
                urls.add(databaseUrl);
            }
            DbManager.close(connection);
            return urls;
        } catch (Exception e) {
            log.error("查询数据库异常，", e);
            return null;
        }
    }

    /**
     * 根据一组别名查找
     *
     * @param mode
     * @return
     */
    public List<DatabaseUrl> getAllDatabaseUrls(ModeEnum mode) {
        DbManager.init(mode);
        Connection connection = DbManager.getConnection();
        if (connection == null) {
            log.error("获取连接异常!");
            return null;
        }
        try {
            PreparedStatement ps = connection.prepareStatement("select * from database_url_config where enabled=1");
            ResultSet rs = ps.executeQuery();
            List<DatabaseUrl> urls = new ArrayList<>();
            while (rs.next()) {
                DatabaseUrl databaseUrl = convertResultSet(rs);
                urls.add(databaseUrl);
            }
            DbManager.close(connection);
            return urls;
        } catch (Exception e) {
            log.error("查询数据库异常，", e);
            return null;
        }
    }

    /**
     * 根据一组别名查找
     *
     * @param mode
     * @return
     */
    public List<DatabaseUrl> getDatabaseUrlByType(ModeEnum mode, DatabaseTypeEnum type) {
        DbManager.init(mode);
        Connection connection = DbManager.getConnection();
        if (connection == null) {
            log.error("获取连接异常!");
            return null;
        }
        try {
            PreparedStatement ps = connection.prepareStatement("select * from database_url_config where type = '" + type.name().toLowerCase() + "' and enabled=1");
            ResultSet rs = ps.executeQuery();
            List<DatabaseUrl> urls = new ArrayList<>();
            while (rs.next()) {
                DatabaseUrl databaseUrl = convertResultSet(rs);
                urls.add(databaseUrl);
            }
            DbManager.close(connection);
            return urls;
        } catch (Exception e) {
            log.error("查询数据库异常，", e);
            return null;
        }
    }

    /**
     * 转换ResultSet
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private static DatabaseUrl convertResultSet(ResultSet rs) throws SQLException {
        DatabaseUrl databaseUrl = new DatabaseUrl();
        databaseUrl.setAlias(rs.getString(1));
        DatabaseTypeEnum type = DatabaseTypeEnum.valueOf(rs.getString(2).toUpperCase());
        databaseUrl.setType(type);
        databaseUrl.setHost(rs.getString(3));
        databaseUrl.setPort(rs.getString(4));
        databaseUrl.setDsnName(rs.getString(5));
        databaseUrl.setDbName(rs.getString(6));
        databaseUrl.setUserName(rs.getString(7));
        databaseUrl.setPassword(rs.getString(8));
        databaseUrl.setDriverClass(rs.getString(9));
        if (type == DatabaseTypeEnum.ORACLE) {
            databaseUrl.setJdbcUrl("jdbc:oracle:thin:@" + databaseUrl.getHost() + ":" + databaseUrl.getPort() + "/" + databaseUrl.getDbName());
        } else if (type == DatabaseTypeEnum.MYSQL) {
            databaseUrl.setJdbcUrl("jdbc:mysql://" + databaseUrl.getHost() + ":" + databaseUrl.getPort() + "/" + databaseUrl.getDbName() + "?useUnicode=true&characterEncoding=UTF-8");
        }
        return databaseUrl;
    }
}
