package com.dsj361.common.utils;

import oracle.sql.TIMESTAMP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author wangkai
 * Create on 2018/3/27 16:02
 */
public class OracleUtils {

    public static final Logger log = LoggerFactory.getLogger(OracleUtils.class);

    public static Date toDate(TIMESTAMP timestamp) {
        try {
            return new Date(timestamp.timestampValue().getTime());
        } catch (Exception e) {
            log.error("转换日期格式异常,timestamp=" + timestamp, e);
            return null;
        }
    }
}
