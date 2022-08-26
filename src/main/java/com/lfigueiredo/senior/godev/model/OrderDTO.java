package com.lfigueiredo.senior.godev.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class OrderDTO {


    public OrderDTO() {
    }

    private UUID id;
    private Integer number;
    private Date date;
    private Double percentualDiscount;
    private Double totalValue;
    private List<OrderItem> items;

}
