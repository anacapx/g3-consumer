package com.grupo3.consumer.services.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.grupo3.consumer.model.Order;
import com.grupo3.consumer.model.enums.OrderEnum;
import com.grupo3.consumer.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {
  @Mock
  private OrderRepository repository;

  @InjectMocks
  private OrderServiceImpl service;

  @Test
  void itShouldUpdateOrderWithValidId() throws RuntimeException {
    // Given
    Order order = new Order(10L, 5L, 10.2, "List of Products", new Timestamp(System.currentTimeMillis()),
        OrderEnum.PENDING);
    Optional<Order> optionalOrder = Optional.of(order);

    // When
    when(repository.findById(10L)).thenReturn(optionalOrder);
    when(repository.save(order)).thenReturn(order);
    service.updateStatusOrderSuccess(10L);

    // Then
    ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);

    verify(repository).save(orderArgumentCaptor.capture());

    Order capturedUser = orderArgumentCaptor.getValue();
    capturedUser.setStatus(OrderEnum.CREATED);
    assertEquals(order, capturedUser);
  }

  @Test
  void itShouldNotUpdateOrderWithInvalidId() throws RuntimeException {

    // When
    when(repository.findById(10L)).thenThrow(RuntimeException.class);

    // Then
    assertThrows(RuntimeException.class, () -> service.updateStatusOrderSuccess(10L));

    verify(repository, never()).deleteById(10L);
  }

  @Test
  void itShouldReturnTrueWithValidId() {
    // Given
    Order order = new Order(10L, 5L, 10.2, "List of Products", new Timestamp(System.currentTimeMillis()),
        OrderEnum.PENDING);
    Optional<Order> optionalOrder = Optional.of(order);

    // When
    when(repository.findById(10L)).thenReturn(optionalOrder);
    boolean response = service.orderExists(10L);

    // Then
    assertNotNull(response);
    assertEquals(true, response);
  }

  @Test
  void itShouldReturnFalseWithInvalidId() {
  boolean response = service.orderExists(10L);
  // Then
  assertEquals(false, response);
  }

  @Test
  void itShouldReturnFalseWithOrderCreated() {
    // Given
    Order order = new Order(10L, 5L, 10.2, "List of Products", new Timestamp(System.currentTimeMillis()),
        OrderEnum.CREATED);
    Optional<Order> optionalOrder = Optional.of(order);

    // When
    when(repository.findById(10L)).thenReturn(optionalOrder);
    boolean response = service.orderInProgress(10L);

    // Then
    assertNotNull(response);
    assertEquals(false, response);
  }

  @Test
  void itShouldReturnTrueWithOrderPending() {
    // Given
    Order order = new Order(10L, 5L, 10.2, "List of Products", new Timestamp(System.currentTimeMillis()),
        OrderEnum.PENDING);
    Optional<Order> optionalOrder = Optional.of(order);

    // When
    when(repository.findById(10L)).thenReturn(optionalOrder);
    boolean response = service.orderInProgress(10L);

    // Then
    assertNotNull(response);
    assertEquals(true, response);
  }
}
