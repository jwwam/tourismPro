package com.feelcode.tourism.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:19 2020/5/7
 * @Modified By:
 */
@Data
public class SpotsRequestPageDTO extends CommonRequestPageDTO{

    @NotBlank(message = "请输入您想查询的景点名称")
    private String spotsName;

}
