package dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrderPaymentDto extends BaseDto {
    private OrderDto order;
    private BigDecimal totalAmount;
    private BigDecimal cash;
    private BigDecimal lease;
}
