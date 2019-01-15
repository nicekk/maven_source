package com.dsj361.client.kafka;

import com.dsj361.common.enums.ModeEnum;
import com.dsj361.config.Constants;
import com.dsj361.config.KafkaConfiguration;
import com.dsj361.model.KafkaConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * kafka 客户端
 *
 * @author wangkai
 * @date 2019/1/5 14:16
 */
public class KafkaClient<K, V> {

    private static final Logger log = Logger.getLogger(KafkaClient.class);

    private Map<String, KafkaConsumer<K, V>> topicConsumerMap = new HashMap<>();

    private Map<String, KafkaProducer<K, V>> topicProducerMap = new HashMap<>();

    /**
     * 获取消费者
     *
     * @param topicName
     * @return
     */
    public synchronized KafkaConsumer<K, V> getConsumer(ModeEnum mode, String topicName, String keyDeserializer, String valueDeserializer) {
        KafkaConsumer<K, V> consumer = topicConsumerMap.get(topicName);
        if (consumer == null) {
            Properties prop = new Properties();
            KafkaConfig kafkaConfig = KafkaConfiguration.getConfig(mode);
            log.error("开始初始化消费者客户端：topicName = " + topicName + ",kafkaConfig = " + kafkaConfig);
            prop.putAll(kafkaConfig.getConsumerProps());
            prop.put(Constants.KAFKA_BOOTSTRAP_SERVERS, kafkaConfig.getServers());
            prop.put(Constants.KEY_DESERIALIZER, keyDeserializer);
            prop.put(Constants.VALUE_DESERIALIZER, valueDeserializer);
            consumer = new KafkaConsumer<>(prop);
            topicConsumerMap.put(topicName, consumer);
        }
        return consumer;
    }

    /**
     * 获取消费者，如果没有指定序列化类，则使用默认的String类型的
     *
     * @param modeEnum
     * @param topicName
     * @return
     */
    public synchronized KafkaConsumer<K, V> getConsumer(ModeEnum modeEnum, String topicName) {
        return getConsumer(modeEnum, topicName,
                "org.apache.kafka.common.serialization.StringDeserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
    }

    /**
     * 获得生产者
     *
     * @param modeEnum
     * @param topicName
     * @param keySerializer
     * @param valueSerializer
     * @return
     */
    public synchronized KafkaProducer<K, V> getProducer(ModeEnum modeEnum, String topicName, String keySerializer, String valueSerializer) {
        KafkaProducer<K, V> producer = topicProducerMap.get(topicName);
        if (producer == null) {
            Properties prop = new Properties();
            KafkaConfig kafkaConfig = KafkaConfiguration.getConfig(modeEnum);
            log.error("开始初始化生产者客户端：topicName = " + topicName + ",kafkaConfig = " + kafkaConfig);
            // 放入默认的配置
            prop.putAll(kafkaConfig.getProducerProps());
            prop.put(Constants.KAFKA_BOOTSTRAP_SERVERS, kafkaConfig.getServers());
            prop.put(Constants.KEY_SERIALIZER, keySerializer);
            prop.put(Constants.VALUE_SERIALIZER, valueSerializer);
            producer = new KafkaProducer<>(prop);
            topicProducerMap.put(topicName, producer);
        }
        return producer;
    }

    /**
     * 获得生产者
     *
     * @param modeEnum
     * @param topicName
     * @return
     */
    public synchronized KafkaProducer<K, V> getProducer(ModeEnum modeEnum, String topicName) {
        return getProducer(modeEnum, topicName,
                "org.apache.kafka.common.serialization.StringSerializer",
                "org.apache.kafka.common.serialization.StringSerializer");
    }


}
