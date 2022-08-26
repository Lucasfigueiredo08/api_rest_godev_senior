package com.lfigueiredo.senior.godev.controllers;

import com.lfigueiredo.senior.godev.model.Item;
import com.lfigueiredo.senior.godev.model.Order;
import com.lfigueiredo.senior.godev.model.OrderItem;
import com.lfigueiredo.senior.godev.service.ItemService;
import com.lfigueiredo.senior.godev.service.OrderItemsService;
import com.lfigueiredo.senior.godev.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemsService orderItemService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/api/orders/{id}/items")
    public List<OrderItem> getAllOrderItem(@PathVariable UUID id){
        return orderItemService.listAll(id);
    }

    @GetMapping("/{orderId}/items/{orderItemId}")
    public OrderItem getOrderItemById(@PathVariable UUID orderItemId){
        return (OrderItem) orderItemService.getOrderItemById(orderItemId);
    }

    @PostMapping("/api/orders/{id}/items")
    public OrderItem save(@PathVariable("orderId")UUID orderId, @RequestBody OrderItem orderItems){
        List<OrderItem> itemsList = orderItemService.getOrderItemById(orderId);
        Order order = orderService.get(orderId);
        Item item = itemService.get(orderItems.getItemId());



        Double percentualDiscount = order.getPercentualDiscount();
        Double Value = item.getValue() * orderItems.getQuantity();

        orderItems.setOrder(orderId);
        orderItems.setTotalValue(Value);

        itemsList.add(orderItems);

        order.setTotalValue(calculateTotalValue(itemsList, percentualDiscount));

        orderService.save(order);

        return orderItemService.(orderItems);
    }




}
