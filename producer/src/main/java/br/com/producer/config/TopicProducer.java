package br.com.producer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TopicProducer {

    @Value("${events.topic.name}")
    private String topic;

    private final KafkaTemplate<String, String> template;

    public TopicProducer(final KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void send(final String message) { this.template.send(topic, message); }

}
