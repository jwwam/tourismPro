package com.feelcode.tourism.entity;


import lombok.Data;

@Data
public class CommonRequestPageDTO extends BaseSessionEntity{
    private Integer start = 0;
    private Integer length = 10;
}
