package com.feelcode.tourism.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tourism_score")
@Data
public class Score extends BaseEntity{

    @Column(name= "grade")
    private  String grade;

    @Column(name="user_id")
    private String userId;

    @Column(name="product_id")
    private String productId;

    @Column(name="product_type")
    private Integer productType;

}