package com.feelcode.tourism.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName: Role
 * @Author: zhangyingqi
 * @Description: 角色-权限
 * @Date: Created in 12:57 2021/4/18
 * @Modified By:
 */
@Entity
@Table(name = "cars_role_permission")
@Data
public class RolePermission extends BaseEntity{

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "permission_id")
    private String permissionId;

}
