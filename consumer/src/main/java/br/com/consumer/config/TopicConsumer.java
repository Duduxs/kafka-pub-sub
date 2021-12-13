package br.com.consumer.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TopicConsumer {

    @Value("${events.topic.name}")
    private String topic;

    @KafkaListener(topics = "${events.topic.name}", groupId = "consumer-x")
    public void read(final ConsumerRecord<String, String> payload) {
        System.out.println(topic);
        System.out.println("---------------");
        System.out.println(payload.value());
        System.out.println("---------------");
    }
}
