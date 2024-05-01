package com.accenture.testkafka.controller;

import com.accenture.testkafka.config.OrderMapper;
import com.accenture.testkafka.domain.order.Order;
import com.accenture.testkafka.domain.order.OrderDTO;
import com.accenture.testkafka.service.OrderService;
import jakarta.validation.Valid;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final OrderService service;
    private final OrderMapper mapper = Mappers.getMapper(OrderMapper.class);


    public OrderController(@Autowired OrderService service){
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody @Valid OrderDTO orderDTO){
        log.info("Recebendo a transação...");
        Order order = mapper.mapOrderDTOToEntity(orderDTO);
        return ResponseEntity.ok(service.createOrder(order));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable String id){
        log.info("Consultando a transação conforme ID...");
        return ResponseEntity.ok(service.getOrder(id));
    }

    @GetMapping("list/{status}")
    public ResponseEntity<List<Order>> listOrderByStatus(@PathVariable String status){
        log.info("Listando transações por status...");
        return ResponseEntity.ok(service.consultOrderByStatus(status.toUpperCase()));
    }

    @GetMapping("line")
    public ResponseEntity<List<Order>> listAllOrder(){
        log.info("Listando transações por status...");
        return ResponseEntity.ok(service.consultAllOrder());
    }
}
