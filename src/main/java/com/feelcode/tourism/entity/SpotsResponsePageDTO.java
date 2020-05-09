package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

@Data
public class SpotsResponsePageDTO extends CommonResponsePageDTO{
    private List<Spots> spotsList;
}
