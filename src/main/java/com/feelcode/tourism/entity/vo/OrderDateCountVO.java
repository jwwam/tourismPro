package com.feelcode.tourism.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 14:27 2020/6/8
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDateCountVO {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dealDate;
    private Long dealNum;
}
