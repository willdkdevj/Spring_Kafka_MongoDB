package com.accenture.testkafka.adapter;

import com.accenture.testkafka.domain.order.Order;
import com.accenture.testkafka.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger log = LoggerFactory.getLogger(OrderConsumer.class);
    private final OrderService service;

    public OrderConsumer(@Autowired OrderService service){
        this.service = service;
    }
//    @KafkaListener(topics = "${spring.kafka.producer.request.topic}", groupId = "${spring.kafka.consumer.group-id}")
    @KafkaListener(topics = "order-saved", groupId = "orders", containerFactory = "orderKafkaListenerContainerFactory")
    public void consumeOrder(Order order){
        log.info("Iniciando a leitura de mensagens no tópico....");
        service.updateStatusOrder(order.getId());
    }
}
