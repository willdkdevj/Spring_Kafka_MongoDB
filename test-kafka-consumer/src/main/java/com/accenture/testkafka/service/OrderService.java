package com.accenture.testkafka.service;

import com.accenture.testkafka.domain.order.Order;
import com.accenture.testkafka.config.exception.OrderNotFoundException;
import com.accenture.testkafka.persistence.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository){
        this.repository = repository;
    }

    public void updateStatusOrder(String id){
        log.info("Localizando ID de Pedido...{}", id);
        Order order = repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found!"));

        log.info("Encontrada mensagem no tópico...{}", order.toString());
        log.info("Iniciando atualização de status...");
        order.setStatus("ENVIADO_TRANSPORTADORA");

        log.info("Alterado status do Pedido...{}", order.toString());
        repository.save(order);
    }
}
