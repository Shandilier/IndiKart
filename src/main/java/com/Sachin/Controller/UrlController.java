package com.Sachin.Controller;

import com.Sachin.Exception.OrderReservationException;
import com.Sachin.Model.*;
import com.Sachin.Service.OrderFulfilmentService;
import com.Sachin.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restaurant/orders")
public class UrlController implements OrderFulfilmentService
{
    @Autowired
    public Warehouse warehouse;
    @Autowired
    public Reserve reserve;
    @Autowired
    public OrderService orderService;

    @Autowired
    public Data data;

    @Autowired
    public CanFulfill canFulfill;

    public UrlController(CanFulfill canFulfill, Data data, OrderService orderService, Reserve reserve, Warehouse warehouse)
    {
        this.data = data;
        this.canFulfill = canFulfill;
        this.orderService = orderService ;
        this.reserve = reserve;
        this.warehouse = warehouse;
    }

    @GetMapping("checkAvailability")
    public boolean canFulfilOrder(@RequestBody OrderRequest orderRequest) {
//        System.out.println("Helo");

        boolean result = orderService.checkIfCanBeFulfilled(orderRequest,warehouse);
        canFulfill.setResult(result);
        return result;
    }

    @GetMapping("reserve")
    public Reserve reserveOrder(@RequestBody OrderRequest orderRequest) throws OrderReservationException {

        boolean result = orderService.checkIfCanBeFulfilled(orderRequest,warehouse);
//        canFulfill.setResult(result);
        if(result==true)
        {
            data = orderService.getReservedDetails(orderRequest,warehouse);
        }
        else
        {
            data.setMessage("Insufficient quantities!");
            data.setReserve(false);
        }
        reserve.setCode("Success");
        reserve.setData(data);
        return reserve;
    }
}
