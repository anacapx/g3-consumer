package com.grupo3.consumer.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.grupo3.consumer.model.enums.OrderEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId", nullable = false)
    private Long orderId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "order_total", nullable = false)
    private Double value;

    @Column(name = "order_products", nullable = false)
    private String products;

    @Column(name = "order_date", nullable = false)
    private Timestamp date = new Timestamp(System.currentTimeMillis());

    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderEnum status;
}
