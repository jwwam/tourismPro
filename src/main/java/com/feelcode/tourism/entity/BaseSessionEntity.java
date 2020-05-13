package com.feelcode.tourism.entity;

import lombok.Data;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:21 2020/5/9
 * @Modified By:
 */
@Data
public class BaseSessionEntity {

    private String userId;
    private String userName;
    private UserSessionEntity userInfo;

}
