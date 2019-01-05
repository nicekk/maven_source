package com.dsj361.config;

/**
 * @author wangkai
 * @date 2019/1/5 14:28
 */
public interface Constants {

    // kafka相关配置
    String KAFKA_BOOTSTRAP_SERVERS = "bootstrap.servers"; //kafka 服务器地址
    String KEY_SERIALIZER = "key.serializer"; // key序列化的类
    String VALUE_SERIALIZER = "value.serializer";     // value序列化的类
    String KEY_DESERIALIZER = "key.deserializer";     // key的反序列化类
    String VALUE_DESERIALIZER = "value.deserializer"; // value的反序列化类

    // JFINAL 常量
    String DB_ALIAS_CONFIG = "bd_config";
}
