package com.accenture.testkafka.config;

import com.accenture.testkafka.domain.order.OrderDTO;
import com.accenture.testkafka.domain.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {

    @Mapping(target = "status", constant = "AGUARDANDO_ENVIO")
    Order mapOrderDTOToEntity(OrderDTO orderDTO);
}
