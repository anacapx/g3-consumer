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
  @Email(message="O campo EMAIL deve ser preenchido corretamente.")
  private String userEmail;
  private String userName;
  private OrderEnum status;
  private Timestamp date = new Timestamp(System.currentTimeMillis());
}
