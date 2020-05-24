package com.feelcode.tourism.entity;

import lombok.Data;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 21:08 2020/5/24
 * @Modified By:
 */
@Data
public class CommentRequestPageDTO extends CommonRequestPageDTO{
    private String productId;
    private Integer productType;
}
