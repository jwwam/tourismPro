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
@Table(name = "tourism_hotel")
@Data
public class Hotel extends BaseEntity{

    @Column(name = "hotel_name", length = 100)
    private String hotelName;

    @Column(name = "hotel_address", length = 100)
    private String hotelAddress;

    @Column(name = "hotel_phone")
    private String hotelPhone;

    @Column(name = "hotel_price")
    private String hotelPrice;

    @Column(name = "check_in_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkInTime;

    @Column(name = "check_out_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkOutTime;

    @Column(name = "bed_type")
    private String bedType;

    @Column(columnDefinition="text", name = "hotel_description")
    private String hotelDescription;

    @Column(columnDefinition="text", name = "hotel_images")
    private String hotelImages;

}
