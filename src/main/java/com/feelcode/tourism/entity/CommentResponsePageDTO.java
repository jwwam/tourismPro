package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 21:08 2020/5/24
 * @Modified By:
 */
@Data
public class CommentResponsePageDTO extends CommonResponsePageDTO{
    private List<Comment> commentList;
}
