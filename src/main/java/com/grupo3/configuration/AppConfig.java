package com.grupo3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.grupo3.consumer.services.classes.OrderServiceImpl;
import com.grupo3.consumer.services.interfaces.IOrderService;

@Configuration
public class AppConfig {

  @Bean
  @Primary
  public IOrderService orderServiceConfiguration() {
    return new OrderServiceImpl();
  }
}
