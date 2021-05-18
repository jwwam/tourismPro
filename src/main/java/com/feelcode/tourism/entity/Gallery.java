package com.feelcode.tourism.entity;

import com.feelcode.tourism.entity.vo.Images;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:43 2021/4/7
 * @Modified By:
 */
@Entity
@Table(name = "cars_gallery")
@Data
public class Gallery extends BaseEntity{
    @Column(name = "user_id", length = 100)
    private String userId;

    @Column(name = "user_name", length = 100)
    private String userName;

    @Column(name = "img_type")
    private String imgType;

    @Column(name = "img_num")
    private String imgNum;

    @Column(name = "images")
    private String images;

    @Transient
    private List<Images> imageList;

}
