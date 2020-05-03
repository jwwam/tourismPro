package com.feelcode.tourism.entity;


import lombok.Data;

@Data
public class CommonResponsePageDTO {
    private Long recordsTotal;// 总记录数
    private Integer recordsFiltered;// 过滤后的总记录数
}
