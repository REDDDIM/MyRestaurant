package services.impl;

import dao.repository.OrderRepository;
import dto.OrderDto;
import entities.Order;
import entities.User;
import enums.OrderStatusEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import services.OrderService;
import services.converter.BaseConverter;
import services.converter.impl.OrderConverter;
import services.exceptions.OrderException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceImplTest {

    @InjectMocks
    OrderService orderService = new OrderServiceImpl();

    @Mock
    OrderConverter converter;

    @Mock
    OrderRepository orderRepository;

    List<Order> expectedOrders;
    List<OrderDto> expectedOrdersDto;
    Order expectedOrder;

    @Before
    public void setUp() {
        expectedOrder = new Order();
        expectedOrder.setAddress("expected_address");
        expectedOrder.setOrderDate(new Date());
        expectedOrder.setOrderStatus(OrderStatusEnum.NEW);
        expectedOrder.setPhoneNumber("1234567890");
        expectedOrders = new ArrayList<>();
        Order firstExpectedOrder = new Order();
        firstExpectedOrder.setAddress("first_expected_address");
        firstExpectedOrder.setOrderDate(new Date());
        firstExpectedOrder.setOrderStatus(OrderStatusEnum.NEW);
        firstExpectedOrder.setPhoneNumber("1234567890");
        Order secondExpectedOrder = new Order();
        secondExpectedOrder.setAddress("second_expected_address");
        secondExpectedOrder.setOrderDate(new Date());
        secondExpectedOrder.setOrderStatus(OrderStatusEnum.NEW);
        secondExpectedOrder.setPhoneNumber("1234567890");
        expectedOrders.add(firstExpectedOrder);
        expectedOrders.add(secondExpectedOrder);
        expectedOrdersDto = new ArrayList<>();
        expectedOrders.forEach(o -> expectedOrdersDto.add(converter.convertToDto(o)));
    }

    @Test(expected = OrderException.class)
    public void returnEmptyCollection() throws OrderException {
        when(orderRepository.findAll()).thenReturn(new ArrayList<>());
        orderService.getAll();
    }

    @Test
    public void returnExpectedOrders() throws OrderException {
        when(orderRepository.getByUserId(anyLong())).thenReturn(expectedOrders);
        assertEquals(orderService.getOrdersForUser(new Long(1)), expectedOrdersDto);
        when(orderRepository.getCourierOrders(anyLong())).thenReturn(expectedOrders);
        assertEquals(orderService.getOrdersForUser(new Long(1)), expectedOrdersDto);
    }

    @Test(expected = OrderException.class)
    public void returnEmptyCollectionForCourier() throws OrderException {
        when(orderRepository.getCourierOrders(anyLong())).thenReturn(new ArrayList<>());
        orderService.getCourierOrders(new Long(1));
    }

}