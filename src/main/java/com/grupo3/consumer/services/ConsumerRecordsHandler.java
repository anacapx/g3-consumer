package com.grupo3.consumer.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.grupo3.consumer.model.dto.MessageKafka;
import com.grupo3.consumer.model.dto.OrderDTO;

@Service
public class ConsumerRecordsHandler {

  @Autowired
  private IOrderService orderService;

  public static MessageKafka convertStringJson(String jsonString) {
    System.out.println("Entrou no convert");
    OrderDTO o = new Gson().fromJson(jsonString, OrderDTO.class);
    System.out.println("passou do convert");
    System.out.println(o.getId());
    return new MessageKafka(o);
  }

  public void process(ConsumerRecords<String, String> records) {
    for (ConsumerRecord<String, String> rec : records) {
      System.out.println("------------------------------------------");
      System.out.println("Partition: " + rec.partition());
      System.out.println("offset: " + rec.offset());
      System.out.println("key/value");
      System.out.println("key: " + rec.key());
      System.out.println("value: " + rec.value());

      if (rec.key() != null) {
        try {

          Integer orderId = Integer.parseInt(rec.key());

          MessageKafka message = convertStringJson(rec.value());

          String msgId = ServiceSES.sendMessage(message.getUserName(), "Pedido " + rec.key() + " realizado.",
              message.getUserEmail());

          if (msgId != null) {
            orderService.updateStatusOrderSuccess(orderId);
          } else {
            throw new RuntimeException("Não foi possível concluir o pedido - " + rec.key());
          }
        } catch (NumberFormatException ex) {
          throw new RuntimeException("Order Id inválido.");
        } catch (Exception e) {
          throw new RuntimeException(e.getMessage());
        }
      }
      System.out.println("Mensagem processada.");
      System.out.println("------------------------------------------");

    }
  }
}
