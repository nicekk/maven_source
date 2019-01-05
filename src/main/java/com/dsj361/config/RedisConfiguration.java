package com.dsj361.config;

import com.dsj361.common.enums.ModeEnum;
import com.dsj361.dao.DAOFactory;

/**
 * redis配置
 *
 * @author wangkai
 * @date 2019/1/5 12:19
 */
public class RedisConfiguration {

    /**
     * 获取redis服务器地址
     *
     * @return
     */
    public static String getServers(ModeEnum mode) {
        return DAOFactory.getRedisConfigDAO().getServers(mode);
    }
}
