package com.lfigueiredo.senior.godev.service;

import com.lfigueiredo.senior.godev.model.OrderItem;
import com.lfigueiredo.senior.godev.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemsService {

    @Autowired
    private OrderItemRepository repoOrderItem;

    public List<OrderItem> listAll(UUID id) { return repoOrderItem.findByOrder(id);}

    public OrderItem Save(OrderItem orderItem){
        return repoOrderItem.save(orderItem);
    }

    public List<OrderItem> getOrderItemById(UUID id){
        return repoOrderItem.findById(id);
    }

    public void delete(UUID id) {
        repoOrderItem.deleteById(id);
    }



}
