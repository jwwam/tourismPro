package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

@Data
public class FoodResponsePageDTO extends CommonResponsePageDTO{
    private List<Food> foodList;
}
