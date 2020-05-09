package com.feelcode.tourism.entity;


import lombok.Data;

@Data
public class CommonRequestPageDTO {
    private Integer start = 0;
    private Integer length = 10;
}
