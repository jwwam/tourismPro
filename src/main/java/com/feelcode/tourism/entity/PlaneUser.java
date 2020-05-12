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
public class PlaneUser{

    private String planeId;

    private String planeName;

    private String planePhone;

    private String planeStartAddress;

    private String planeEndAddress;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planeStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planeEndTime;

    private String planeDescription;

    private String planePrice;

    private String planeImages;

    private String userId;

    private String userName;

}
