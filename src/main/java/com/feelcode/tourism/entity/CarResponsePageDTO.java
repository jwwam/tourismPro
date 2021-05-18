package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:24 2020/5/7
 * @Modified By:
 */
@Data
public class CarResponsePageDTO extends CommonResponsePageDTO{
    private List<Car> carList;
}
