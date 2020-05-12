package com.feelcode.tourism.entity;

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
    private Date dealingTime;

    @Column(name = "order_status")
    private String orderStatus;
}
