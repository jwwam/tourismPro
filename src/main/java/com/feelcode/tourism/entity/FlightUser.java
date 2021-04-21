package com.feelcode.tourism.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:43 2020/5/7
 * @Modified By:
 */
@Data
public class FlightUser {

    private String flightId;

    private String flightName;

    private String flightPhone;

    private String flightStartAddress;

    private String flightEndAddress;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date flightStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date flightEndTime;

    private String flightDescription;

    private String flightPrice;

    private String flightImages;

    private String userId;

    private String userName;

}
