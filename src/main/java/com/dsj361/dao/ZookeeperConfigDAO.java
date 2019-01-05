package com.dsj361.dao;

import com.dsj361.common.enums.ModeEnum;
import com.dsj361.common.lang.ObjectUtils;
import com.dsj361.config.Constants;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

/**
 * @author wangkai
 * @date 2019/1/5 12:29
 */
public class ZookeeperConfigDAO {

    /**
     * 获取到redis连接
     *
     * @param mode
     * @return
     */
    public String getServers(ModeEnum mode) {
        DbManager.init(mode);
        Record record = Db.use(Constants.DB_ALIAS_CONFIG).findFirst("select servers from zookeeper_config where enabled = 1");
        return ObjectUtils.toString(record.get("SERVERS"));
    }
}
