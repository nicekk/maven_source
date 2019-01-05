package com.dsj361.dao;

import com.dsj361.common.enums.ModeEnum;
import com.dsj361.common.lang.ObjectUtils;
import com.dsj361.config.Constants;
import com.dsj361.model.KafkaConfig;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;

/**
 * @author wangkai
 * @date 2019/1/5 12:30
 */
public class KafkaConfigDAO {

    public static KafkaConfig getServers(ModeEnum mode) {
        DbManager.init(mode);

        KafkaConfig kafkaConfig = new KafkaConfig();
        String sql1 = "select servers from kafka_config where enabled=1";
        Record url = Db.use(Constants.DB_ALIAS_CONFIG).findFirst(sql1);
        String servers = ObjectUtils.toString(url.get("SERVERS"));
        kafkaConfig.setServers(servers);

        String sql2 = "select name,value from kafka_consumer_config where enabled = 1";
        List<Record> consumerRecords = Db.use(Constants.DB_ALIAS_CONFIG).find(sql2);
        Properties consumerProps = new Properties();
        for (Record record : consumerRecords) {
            consumerProps.put(ObjectUtils.toString(record.get("NAME")), ObjectUtils.toString(record.get("VALUE")));
        }
        kafkaConfig.setConsumerProps(consumerProps);


        String sql3 = "select name,value from kafka_producer_config where enabled = 1";
        List<Record> producerRecords = Db.use(Constants.DB_ALIAS_CONFIG).find(sql3);
        Properties producerProps = new Properties();
        for (Record record : producerRecords) {
            producerProps.put(ObjectUtils.toString(record.get("NAME")), ObjectUtils.toString(record.get("VALUE")));
        }
        kafkaConfig.setProducerProps(producerProps);
        return kafkaConfig;
    }
}
