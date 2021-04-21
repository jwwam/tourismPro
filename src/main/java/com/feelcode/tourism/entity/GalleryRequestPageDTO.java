package com.feelcode.tourism.entity;

import lombok.Data;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:19 2020/5/7
 * @Modified By:
 */
@Data
public class GalleryRequestPageDTO extends CommonRequestPageDTO{
    private String title;
    /**
     * 图片类型
     */
    private String imgType;

}
