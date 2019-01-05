package com.dsj361.config;

import com.dsj361.common.enums.ModeEnum;
import com.dsj361.dao.DAOFactory;

/**
 * zk 配置查询
 *
 * @author wangkai
 * @date 2019/1/5 12:28
 */
public class ZookeeperConfiguration {

    public static String getServers(ModeEnum mode) {
        return DAOFactory.getZookeeperConfigDAO().getServers(mode);
    }
}
