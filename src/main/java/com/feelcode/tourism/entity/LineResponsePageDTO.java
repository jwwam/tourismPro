package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

@Data
public class LineResponsePageDTO extends CommonResponsePageDTO{
    private List<Line> lineList;
}
