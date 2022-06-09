package com.grupo3.consumer.services;

import com.grupo3.consumer.model.Order;

public interface IOrderService {
    public boolean orderExists(Integer orderId);

    public boolean orderInProgress(Integer orderId);

    public Order updateStatusOrderSuccess(Integer orderId);
}
