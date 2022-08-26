package com.lfigueiredo.senior.godev.controllers;

import com.lfigueiredo.senior.godev.model.Item;
import com.lfigueiredo.senior.godev.service.ItemService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/api/items")
    public List<Item> listAll() {return itemService.listAll();}

    @GetMapping("/api/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable UUID id){
        try{
            Item item = itemService.get(id);
            return new ResponseEntity<Item>(item, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/items")
    public Item addItem(@RequestBody Item item) { return itemService.save(item);}

    @PutMapping("/api/item/{id}")
    public ResponseEntity<Item> updateItem (@RequestBody Item item, @PathVariable UUID id){
        try{
              Item existItem = itemService.get(id);
              itemService.save(existItem);
              return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public void deleteItem(@PathVariable UUID id) { itemService.delete(id);}




}
