package com.feelcode.tourism.entity;

import lombok.Data;

/**
 * @ClassName: ChangePasswordEntity
 * @Author: zhangyingqi
 * @Description: 修改密码
 * @Date: Created in 21:33 2021/2/23
 * @Modified By:
 */
@Data
public class ChangePasswordEntity {
    private String userId;
    private String userName;
    private String oldpassword;
    private String newpassword;
}
