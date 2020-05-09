package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

@Data
public class PlaneResponsePageDTO extends CommonResponsePageDTO{
    private List<Plane> planeList;
}
