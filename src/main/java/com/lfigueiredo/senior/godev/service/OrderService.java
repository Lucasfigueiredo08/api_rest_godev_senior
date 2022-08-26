package com.lfigueiredo.senior.godev.service;

import com.lfigueiredo.senior.godev.model.Order;
import com.lfigueiredo.senior.godev.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    OrderRepository repoOrder;

    public List<Order> listAll() { return repoOrder.findAll();}

    public Order save(Order order) { return repoOrder.save(order);}

    public Order get(UUID id) { return repoOrder.findById(id).get();}

    public void delete(UUID id) { repoOrder.deleteById(id);}

}
