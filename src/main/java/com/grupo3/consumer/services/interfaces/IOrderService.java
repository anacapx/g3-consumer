package com.grupo3.consumer.services.interfaces;

import com.grupo3.consumer.model.Order;

public interface IOrderService {
    public boolean orderExists(Long orderId);

    public boolean orderInProgress(Long orderId);

    public Order updateStatusOrderSuccess(Long orderId);
}
