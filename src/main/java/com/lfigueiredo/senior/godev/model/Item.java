package com.lfigueiredo.senior.godev.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Item {

    private UUID id;
    private String description;
    private Double value;
    private char type;

    public Item(String description, Double value, char type) {
        this.description = description;
        this.value = value;
        this.type = type;
    }
}
