package com.accenture.testkafka.adapter;

import com.accenture.testkafka.domain.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderRequestProducer {

    private static final Logger log = LoggerFactory.getLogger(OrderRequestProducer.class);
    @Value("${spring.kafka.producer.request.topic}")
    private String requestTopic;

    private final KafkaTemplate<String, Order> template;

    @Autowired
    public OrderRequestProducer(KafkaTemplate<String, Order> template) {
        this.template = template;
    }

    public void sendMessage(Order order){
            log.info("Realizando a serialização da mensagem....");
            template.send(requestTopic, order);
    }
}
