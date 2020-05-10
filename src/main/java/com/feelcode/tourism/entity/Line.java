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
@Table(name = "tourism_line")
@Data
public class Line extends BaseEntity{
    @Column(name = "line_name", length = 100)
    private String lineName;

    @Column(name = "line_address", length = 100)
    private String lineAddress;

    @Column(name = "line_phone")
    private String linePhone;

    @Column(name = "line_price")
    private String linePrice;

    @Column(columnDefinition="text", name = "line_description")
    private String lineDescription;

    @Column(columnDefinition="text", name = "line_images")
    private String lineImages;
}
