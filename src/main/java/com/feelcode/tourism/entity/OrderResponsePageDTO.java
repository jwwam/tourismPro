package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponsePageDTO extends CommonResponsePageDTO{
    private List<Order> orderList;
}
