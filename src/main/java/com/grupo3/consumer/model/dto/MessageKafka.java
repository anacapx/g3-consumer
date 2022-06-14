package com.grupo3.consumer.model.dto;

import java.sql.Timestamp;

import javax.validation.constraints.Email;

import com.grupo3.consumer.model.enums.OrderEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MessageKafka {
  private Long orderId;
  @Email(message = "O campo EMAIL deve ser preenchido corretamente.")
  private String userEmail;
  private String userName;
  private OrderEnum status;
  private Timestamp date = new Timestamp(System.currentTimeMillis());

  public MessageKafka(OrderDTO order) {
    this.orderId = order.getId();
    this.userEmail = order.getUser().getEmail();
    this.userName = order.getUser().getName();
    this.status = order.getStatus();
    this.date = order.getDate();
  }
}
