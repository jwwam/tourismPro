package com.feelcode.tourism.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:19 2021/5/7
 * @Modified By:
 */
@Data
public class CarRequestPageDTO extends CommonRequestPageDTO{
    private String carName;
    private String carAddress;
    private String carPriceMin;
    private String carPriceMax;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String checkInTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String checkOutTime;
    private String bedType;
    private String carPerson;
    private String star;
    /**
     * 优惠类型
     */
    private String offerType;

}
