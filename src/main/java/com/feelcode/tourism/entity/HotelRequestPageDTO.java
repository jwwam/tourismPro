package com.feelcode.tourism.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:19 2020/5/7
 * @Modified By:
 */
@Data
public class HotelRequestPageDTO extends CommonRequestPageDTO{
    private String hotelName;
    private String hotelAddress;
    private String hotelPrice;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String checkInTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String checkOutTime;
    private String bedType;
    private String hotelPerson;

}
