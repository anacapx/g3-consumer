package com.grupo3.consumer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupo3.consumer.dao.OrderDAO;
import com.grupo3.consumer.model.Order;
import com.grupo3.consumer.model.enums.OrderEnum;

@Component
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderDAO dao;

	@Override
	public boolean orderExists(Long orderId) {
		return dao.findById(orderId).isPresent();
	}

	@Override
	public boolean orderInProgress(Long orderId) {
		Order order = dao.findById(orderId).orElse(null);
		if (order.getStatus() != OrderEnum.PENDING) {
			return false;
		}
		return true;
	}

	@Override
	public Order updateStatusOrderSuccess(Long orderId) {
		Order order = dao.findById(orderId).orElse(null);

		if (!this.orderExists(orderId) || !this.orderInProgress(orderId)) {
			throw new RuntimeException("Pedido indisponivel.");
		}

		order.setStatus(OrderEnum.CREATED);

		return dao.save(order);
	}

}
