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
@Entity
@Table(name = "tourism_plane")
@Data
public class Plane extends BaseEntity{
    @Column(name = "plane_name", length = 100)
    private String planeName;

    @Column(name = "plane_phone")
    private String planePhone;

    @Column(name = "plane_start_address", length = 100)
    private String planeStartAddress;

    @Column(name = "plane_end_address", length = 100)
    private String planeEndAddress;

    @Column(name = "plane_start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planeStartTime;

    @Column(name = "plane_end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planeEndTime;

    @Column(columnDefinition="text", name = "plane_description")
    private String planeDescription;

    @Column(name = "plane_price", length = 100)
    private String planePrice;

    @Column(columnDefinition="text", name = "plane_images")
    private String planeImages;
}
