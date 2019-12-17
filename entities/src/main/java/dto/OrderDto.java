package dto;

import enums.OrderStatusEnum;
import lombok.EqualsAndHashCode;

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
    private OrderStatusEnum orderStatus;
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

    @Column(name = "order_status")
    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
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
