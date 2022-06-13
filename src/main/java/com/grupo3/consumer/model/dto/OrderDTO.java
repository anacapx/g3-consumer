package com.grupo3.consumer.model.dto;

import java.sql.Timestamp;

import com.grupo3.consumer.model.Order;
import com.grupo3.consumer.model.User;
import com.grupo3.consumer.model.enums.OrderEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderDTO {
  private Long id;
  private User user;
  private Double value;
  private String products;
  private Timestamp date;
  private OrderEnum status;

  public OrderDTO(Order order, User user) {
    this.id = order.getOrderId();
    this.user = user;
    this.value = order.getValue();
    this.products = order.getProducts();
    this.date = order.getDate();
    this.status = order.getStatus();
  }

}
