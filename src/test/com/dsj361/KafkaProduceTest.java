package com.dsj361;

import com.dsj361.common.enums.ModeEnum;
import com.dsj361.client.kafka.KafkaClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * @author wangkai
 * @date 2019/1/5 17:45
 */
public class KafkaProduceTest {

    @Test
    public void testProduce() throws ExecutionException, InterruptedException {
        String topicName = "orcl_test1";
        String id = "1234567";
        String content = "test kafka connection1";
        KafkaClient<String, String> client = new KafkaClient<>();
        KafkaProducer<String, String> producer = client.getProducer(ModeEnum.DEV, topicName);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topicName, id, content);
        for (int i = 0; i < 100; i++) {
            producer.send(producerRecord).get();
        }
    }

}
