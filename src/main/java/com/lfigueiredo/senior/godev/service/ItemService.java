package com.lfigueiredo.senior.godev.service;

import com.lfigueiredo.senior.godev.model.Item;
import com.lfigueiredo.senior.godev.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


public class ItemService {

    @Autowired
    private ItemRepository repoItem;

    public List<Item> listAll() { return repoItem.findAll();}

    public Item save(Item item) { return repoItem.save(item); }

    public Item get(UUID id) { return repoItem.findById(id).get();}

    public void delete(UUID id) {
        repoItem.deleteById(id);}
}
