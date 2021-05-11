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
 * @Date: Created in 23:43 2021/4/7
 * @Modified By:
 */
@Entity
@Table(name = "tourism_flight")
@Data
public class Flight extends BaseEntity{
    @Column(name = "flight_name", length = 100)
    private String flightName;

    @Column(name = "flight_phone")
    private String flightPhone;

    @Column(name = "flight_start_address", length = 100)
    private String flightStartAddress;

    @Column(name = "flight_end_address", length = 100)
    private String flightEndAddress;

    @Column(name = "flight_start_time")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date flightStartTime;

    @Column(name = "flight_end_time")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date flightEndTime;

    @Column(columnDefinition="text", name = "flight_description")
    private String flightDescription;

    @Column(name = "flight_price", length = 100)
    private String flightPrice;

    @Column(columnDefinition="text", name = "flight_images")
    private String flightImages;
}
