package com.grupo3.consumer.services.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupo3.consumer.model.Order;
import com.grupo3.consumer.model.enums.OrderEnum;
import com.grupo3.consumer.repository.OrderRepository;
import com.grupo3.consumer.services.interfaces.IOrderService;

@Component
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderRepository repository;

	@Override
	public boolean orderExists(Long orderId) {
		Order order = repository.findById(orderId).orElse(null);
		if (order == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean orderInProgress(Long orderId) {
		Order order = repository.findById(orderId).orElse(null);
		if (order.getStatus() != OrderEnum.PENDING) {
			return false;
		}
		return true;
	}

	@Override
	public Order updateStatusOrderSuccess(Long orderId) {
		Order order = repository.findById(orderId).orElse(null);

		if (!this.orderExists(orderId) || !this.orderInProgress(orderId)) {
			throw new RuntimeException("Pedido indisponivel.");
		}

		order.setStatus(OrderEnum.CREATED);

		return repository.save(order);
	}

}
