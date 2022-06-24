package com.revature.Service;

import com.revature.Entity.Orders;
import com.revature.Exception.OrderNotFoundException;
import com.revature.Repository.IOrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private final IOrdersRepo ordersRepo;

    @Autowired
    public OrdersService(IOrdersRepo ordersRepo){
        this.ordersRepo = ordersRepo;
    }

    public Orders addOrder(Orders order){
        return ordersRepo.save(order);
    }

    public List<Orders> findAllOrders(){ return ordersRepo.findAll(); }

    public Orders updateOrder(Orders order){
        Orders exist = findByOrderId(order.getOrderID());
        if(exist != null){
            return ordersRepo.save(order);
        }
        return null;
    }

    public Orders findByOrderId(Long orderID){
        return ordersRepo.findByorderID(orderID).orElseThrow(() -> new OrderNotFoundException("Order " + orderID + " not do not exists"));
    }

    public void deleteOrder(Long orderID){
        Orders exist = findByOrderId(orderID);
        if(exist != null){
            ordersRepo.deleteByorderID(orderID);
        }
    }
}
