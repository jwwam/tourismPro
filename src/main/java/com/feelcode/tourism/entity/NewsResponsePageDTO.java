package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

@Data
public class NewsResponsePageDTO extends CommonResponsePageDTO{
    private List<News> newsList;
}
