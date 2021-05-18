package com.feelcode.tourism.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:43 2021/5/7
 * @Modified By:
 */
@Entity
@Table(name = "cars_news")
@Data
public class News extends BaseEntity{
    @Column(name = "news_title", length = 100)
    private String newsTitle;

    @Column(name = "news_content")
    @Lob
    private String newsContent;

    @Column(name = "news_user")
    private String newsUser;

    @Column(columnDefinition="text", name = "news_images")
    private String newsImages;

}
