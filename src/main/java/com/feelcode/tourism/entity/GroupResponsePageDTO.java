package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:03 2020/5/16
 * @Modified By:
 */
@Data
public class GroupResponsePageDTO extends CommonResponsePageDTO{
    private List<Group> groupList;
}
