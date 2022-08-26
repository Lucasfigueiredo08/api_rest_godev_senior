package com.lfigueiredo.senior.godev.repository;

import com.lfigueiredo.senior.godev.model.Order;
import com.lfigueiredo.senior.godev.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {

    List<OrderItem> findByOrder(UUID order);
}
