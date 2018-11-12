package com.dsj361.common.enums;

/**
 * @author wangkai
 * @date 2018/11/12 18:14
 */
public enum DatabaseTypeEnum implements EnumBase {

    ORACLE,

    MYSQL,

    HIVE,

    REDIS,

    HBASE,

    ;

    @Override
    public String message() {
        return null;
    }

    @Override
    public Number value() {
        return null;
    }
}
