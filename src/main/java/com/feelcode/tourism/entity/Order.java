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
 * @Date: Created in 23:44 2020/5/7
 * @Modified By:
 */
@Entity
@Table(name = "tourism_order")
@Data
public class Order extends BaseEntity{
    @Column(name = "order_no", length = 100)
    private String orderNo;

    @Column(name = "product_type")
    private Integer productType;

    @Column(name = "product_id", length = 100)
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "dealing_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dealingTime;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(columnDefinition="text", name = "preview_images")
    private String previewImage;

    @Column(name = "order_amount")
    private String orderAmount;

}
