package com.feelcode.tourism.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName: Role
 * @Author: zhangyingqi
 * @Description: 用户-角色
 * @Date: Created in 12:57 2021/4/18
 * @Modified By:
 */
@Entity
@Table(name = "cars_user_role")
@Data
public class UserRole extends BaseEntity{

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private String roleId;

}
