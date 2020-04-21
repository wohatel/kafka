package com.github.wohatel.kafka.scribe;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class KafkaProducerStart {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.RETRIES_CONFIG, 10);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        Random random = new Random();
        while (true) {
            String key = "key-" + random.nextInt(1000);
            String value = "value+" + random.nextInt(1000);
            System.out.println(key + "    " + value);
            ProducerRecord<String, String> record = new ProducerRecord<>(ConfigStart.topic, key, value);
            producer.send(record,(m,e)->{
                System.out.println("topic:" + m.topic() + "  " + "partion:" + m.partition() + "  " + "offset:" + m.offset());
            });
            Thread.sleep(10000);
        }
    }
}
