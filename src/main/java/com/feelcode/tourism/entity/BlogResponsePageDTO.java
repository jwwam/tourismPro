package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

@Data
public class BlogResponsePageDTO extends CommonResponsePageDTO{
    private List<Blog> blogList;
}
