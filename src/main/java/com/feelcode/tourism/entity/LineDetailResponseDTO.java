package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 17:03 2020/5/17
 * @Modified By:
 */
@Data
public class LineDetailResponseDTO {
    private Line line;
    private List<Group> groupList;
}
