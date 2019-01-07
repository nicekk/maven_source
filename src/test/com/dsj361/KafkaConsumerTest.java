package com.dsj361;

import com.dsj361.common.enums.ModeEnum;
import com.dsj361.client.kafka.KafkaClient;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author wangkai
 * @date 2019/1/5 15:04
 */
public class KafkaConsumerTest {

    @Test
    public void testConsume() {
        String topicName = "orcl_test1";

        KafkaClient<String, String> client = new KafkaClient<>();

        KafkaConsumer<String, String> consumer = client.getConsumer(ModeEnum.DEV, topicName);
        consumer.subscribe(Arrays.asList(topicName));
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            ConsumerRecords<String, String> records = consumer.poll(100);
            System.out.println(records.isEmpty());
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record);
                System.out.println(record.key());
                System.out.println(record.value());
            }
        }
    }
}
