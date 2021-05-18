package com.feelcode.tourism.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 18:40 2020/5/24
 * @Modified By:
 */
@Entity
@Table(name = "cars_comment")
@Data
public class Comment extends BaseEntity{

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "comment_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentTime;

    @Column(name = "comment_parentId")
    private String commentParentId;

    @Column(name = "comment_num")
    private String commentNum;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_Name")
    private String userName;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_type")
    private Integer productType;

    @Max(value = 10)
    @Min(value = 1)
    //@Transient
    @Column(name = "score")
    private BigDecimal score;

}
