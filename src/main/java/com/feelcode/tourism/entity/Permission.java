package com.feelcode.tourism.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName: Role
 * @Author: zhangyingqi
 * @Description: 权限
 * @Date: Created in 12:57 2021/4/18
 * @Modified By:
 */
@Entity
@Table(name = "cars_permission")
@Data
public class Permission extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "resources")
    private String resources;

    @Column(name = "menu")
    private String menu;

}
