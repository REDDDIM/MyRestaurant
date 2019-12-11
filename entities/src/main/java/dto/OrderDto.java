package dto;

import entities.OrderItem;
import entities.OrderStatus;
import entities.OrderType;
import entities.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;


//@AllArgsConstructor
//@Getter
//@Setter
@EqualsAndHashCode
public class OrderDto extends BaseDto {
    private UserDto user;
    private OrderTypeDto orderType;
    private Date orderDate;
    private String address;
    private String phoneNumber;
    private OrderStatusDto orderStatus;
    private List<OrderItemDto> orderItems;
    private UserDto courier;

    public OrderDto() {
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public OrderTypeDto getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderTypeDto orderType) {
        this.orderType = orderType;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public OrderStatusDto getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusDto orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

    public UserDto getCourier() {
        return courier;
    }

    public void setCourier(UserDto courier) {
        this.courier = courier;
    }
}
