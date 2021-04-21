package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

@Data
public class FlightResponsePageDTO extends CommonResponsePageDTO{
    private List<Flight> flightList;
}
