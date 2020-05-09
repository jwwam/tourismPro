package com.feelcode.tourism.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:43 2020/5/7
 * @Modified By:
 */
@Entity
@Table(name = "tourism_spots")
@Data
public class Spots extends BaseEntity{
    @Column(name = "spots_name", length = 100)
    private String spotsName;

    @Column(name = "spots_address", length = 100)
    private String spotsAddress;

    @Column(name = "spots_phone")
    private String spotsPhone;

    @Column(name = "spots_price")
    private String spotsPrice;

    @Column(name = "spots_open_time")
    private String spotsOpenTime;

    @Column(name = "spots_description")
    private String spotsDescription;

    @Column(columnDefinition="text", name = "spots_images")
    private String spotsImages;
}
