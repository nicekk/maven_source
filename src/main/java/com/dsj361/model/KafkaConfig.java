package com.dsj361.model;

import com.dsj361.common.model.BaseModel;

import java.util.Properties;

/**
 * kafka 配置
 *
 * @author wangkai
 * @date 2019/1/5 17:08
 */
public class KafkaConfig extends BaseModel {

    private String servers; // 服务器地址
    private Properties producerProps; // 生产者默认属性
    private Properties consumerProps; // 消费者默认属性

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }

    public Properties getProducerProps() {
        return producerProps;
    }

    public void setProducerProps(Properties producerProps) {
        this.producerProps = producerProps;
    }

    public Properties getConsumerProps() {
        return consumerProps;
    }

    public void setConsumerProps(Properties consumerProps) {
        this.consumerProps = consumerProps;
    }
}
