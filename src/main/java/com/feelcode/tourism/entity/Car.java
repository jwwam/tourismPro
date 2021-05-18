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
 * @Date: Created in 22:18 2020/5/7
 * @Modified By:
 */
@Entity
@Table(name = "cars_car")
@Data
public class Car extends BaseEntity{

    @Column(name = "car_name", length = 100)
    private String carName;

    @Column(name = "car_address", length = 100)
    private String carAddress;

    @Column(name = "car_phone")
    private String carPhone;

    @Column(name = "car_price")
    private String carPrice;

    @Column(name = "check_in_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date checkInTime;

    @Column(name = "check_out_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date checkOutTime;

    @Column(name = "bed_type")
    private String bedType;

    @Column(name = "star")
    private String star;

    @Column(columnDefinition="text", name = "car_description")
    private String carDescription;

    @Column(columnDefinition="text", name = "car_images")
    private String carImages;

    @Column(name = "offer_type")
    private String offerType;

}
