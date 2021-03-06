package com.dsj361.config;

import com.dsj361.common.enums.ModeEnum;
import com.dsj361.dao.DAOFactory;
import com.dsj361.model.KafkaConfig;

/**
 * @author wangkai
 * @date 2019/1/5 12:30
 */
public class KafkaConfiguration {

    /**
     * 获取redis服务器地址
     *
     * @return
     */
    public static KafkaConfig getConfig(ModeEnum mode) {
        return DAOFactory.getKafkaConfigDAO().getServers(mode);
    }

}
