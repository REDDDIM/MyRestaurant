package services.converter.impl;

import dto.OrderDto;
import entities.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import services.converter.BaseConverter;

@Component
@Qualifier("orderConverter")
public class OrderConverter extends GenericConverter<OrderDto, Order> implements BaseConverter<OrderDto, Order> {
}
