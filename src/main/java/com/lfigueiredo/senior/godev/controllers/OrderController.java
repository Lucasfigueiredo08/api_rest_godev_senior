package com.lfigueiredo.senior.godev.controllers;

import com.lfigueiredo.senior.godev.model.Order;
import com.lfigueiredo.senior.godev.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/api/order")
    public List<Order> listAll() { return orderService.listAll();}

    @GetMapping("/api/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable UUID id){
        try{
            Order order = orderService.get(id);
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/order/{id}")
    public Order add(@RequestBody Order order) {
        return orderService.save(order);}

    @PutMapping("/api/order/{id}")
    public ResponseEntity<Order> update(@RequestBody Order order, @PathVariable UUID id){
        try {
            Order existProduct = orderService.get(id);
            orderService.save(existProduct);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }

    @DeleteMapping("/api/order/{id}")
    public void deleteOrder(@PathVariable  UUID id){
        orderService.delete(id);
    }
}
