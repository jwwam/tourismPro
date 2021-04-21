package com.feelcode.tourism.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:19 2021/4/7
 * @Modified By:
 */
@Data
public class BlogRequestPageDTO extends CommonRequestPageDTO{

    @NotBlank(message = "请输入您想查询的游记名称")
    private String title;

}
