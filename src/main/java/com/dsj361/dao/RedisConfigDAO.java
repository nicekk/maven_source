package com.dsj361.dao;

import com.dsj361.common.enums.ModeEnum;
import com.dsj361.common.lang.ObjectUtils;
import com.dsj361.config.Constants;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import org.apache.log4j.Logger;

/**
 * @author wangkai
 * @date 2019/1/5 12:20
 */
public class RedisConfigDAO {

    private static final Logger log = Logger.getLogger(RedisConfigDAO.class);

    public String getServers(ModeEnum mode) {
        DbManager.init(mode);
        Record record = Db.use(Constants.DB_ALIAS_CONFIG).findFirst("select servers from redis_config where enabled = 1");
        return ObjectUtils.toString(record.get("SERVERS"));
    }
}
