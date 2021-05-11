package com.feelcode.tourism.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:43 2021/5/7
 * @Modified By:
 */
@Entity
@Table(name = "tourism_food")
@Data
public class Food extends BaseEntity{
    @Column(name = "food_name", length = 100)
    private String foodName;

    @Column(name = "food_address", length = 100)
    private String foodAddress;

    @Column(name = "food_phone")
    private String foodPhone;

    @Column(name = "food_price")
    private String foodPrice;

    @Column(name = "food_type")
    private String foodType;

    @Column(columnDefinition="text", name = "food_description")
    private String foodDescription;

    @Column(columnDefinition="text", name = "food_images")
    private String foodImages;

}
