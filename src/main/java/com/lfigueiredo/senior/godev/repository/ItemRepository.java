package com.lfigueiredo.senior.godev.repository;

import com.lfigueiredo.senior.godev.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> { //Item, Long

}
