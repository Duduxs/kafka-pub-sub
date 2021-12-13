package br.com.producer;

import br.com.producer.config.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sendMessage")
public class TopicController {

    @Autowired
    private TopicProducer producer;

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody final DTOMessage message) {
        producer.send(message.value);
        return ResponseEntity.noContent().build();
    }
}

class DTOMessage {

    public String value;
}
