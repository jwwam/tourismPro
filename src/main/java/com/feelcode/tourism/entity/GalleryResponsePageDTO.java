package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:24 2021/4/7
 * @Modified By:
 */
@Data
public class GalleryResponsePageDTO extends CommonResponsePageDTO{
    private List<Gallery> galleryList;
}
