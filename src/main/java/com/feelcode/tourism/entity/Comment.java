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
 * @Date: Created in 18:40 2020/5/24
 * @Modified By:
 */
@Entity
@Table(name = "tourism_comment")
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

}
