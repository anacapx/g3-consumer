package com.grupo3.consumer.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

  @Bean
  @Primary
  public IOrderService orderServiceConfiguration() {
    return new OrderServiceImpl();
  }
}
