package com.Sachin.Service;

import com.Sachin.Exception.OrderReservationException;
import com.Sachin.Model.OrderRequest;
import com.Sachin.Model.Reserve;

public interface OrderFulfilmentService {
    boolean canFulfilOrder(OrderRequest orderRequest);
    Reserve reserveOrder(OrderRequest orderRequest) throws OrderReservationException;
}
