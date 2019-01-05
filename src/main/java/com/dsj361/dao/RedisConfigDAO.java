package com.dsj361.dao;

import com.dsj361.common.enums.ModeEnum;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author wangkai
 * @date 2019/1/5 12:20
 */
public class RedisConfigDAO {

    private static final Logger log = Logger.getLogger(RedisConfigDAO.class);

    /**
     * 获取到redis连接
     *
     * @param mode
     * @return
     */
    public String getServers(ModeEnum mode) {
        DbManager.init(mode);
        Connection connection = DbManager.getConnection();
        if (connection == null) {
            log.error("获取连接异常!");
            return null;
        }
        try {
            PreparedStatement ps = connection.prepareStatement("select servers from redis_config where enabled=1");
            ResultSet rs = ps.executeQuery();
            String servers = "";
            while (rs.next()) {
                servers = rs.getString(1);
            }
            DbManager.close(connection);
            return servers;
        } catch (Exception e) {
            log.error("查询数据库异常，", e);
            return null;
        }
    }
}
