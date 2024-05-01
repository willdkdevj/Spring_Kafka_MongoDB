package com.accenture.testkafka.service;

import com.accenture.testkafka.adapter.OrderRequestProducer;
import com.accenture.testkafka.domain.order.Order;
import com.accenture.testkafka.persistence.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository repository;
    private final OrderRequestProducer requestProducer;

    @Autowired
    public OrderService(OrderRepository repository, OrderRequestProducer requestProducer) {
        this.repository = repository;
        this.requestProducer = requestProducer;
    }

    public Order createOrder(Order order){
        log.info("Iniciando o registro do pedido...");
        Order saved = repository.save(order);

        log.info("Encaminhando mensagem para tópico... {}", order.toString());
        requestProducer.sendMessage(saved);

        log.info("Pedido salvo e mensagem encaminhada...");
        return saved;
    }

    public Order getOrder(String id){
        log.info("Validando o pedido...");
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found!"));
    }

    public List<Order> consultOrderByStatus(String status){
        log.info("Localizando pedidos por status...");
        return repository.findByStatus(status);
    }

    public List<Order> consultAllOrder(){
        log.info("Listando todas os pedidos...");
        return repository.findAll();
    }
}
