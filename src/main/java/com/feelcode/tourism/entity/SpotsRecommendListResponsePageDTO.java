package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 15:31 2020/5/16
 * @Modified By:
 */
@Data
public class SpotsRecommendListResponsePageDTO extends CommonResponsePageDTO{

    private List<Spots> spotsList;
    private Spots spots;

}
