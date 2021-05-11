package com.feelcode.tourism.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName: Role
 * @Author: zhangyingqi
 * @Description: 角色
 * @Date: Created in 12:57 2021/4/18
 * @Modified By:
 */
@Entity
@Table(name = "tourism_role")
@Data
public class Role extends BaseEntity{

    @Column(name = "name")
    private String name;

}
