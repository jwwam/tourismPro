package com.feelcode.tourism.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: User
 * @Auther: 朱利尔
 * @Date: 2021/4/30 17:17
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cars_user")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer","handler"})
public class User extends BaseEntity implements Serializable {

    @Column(name = "user_name", length = 100)
    private String userName;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "age")
    private Long age;

    //头像
    @Column(name = "avatar")
    private String avatar;

    //1-启用，0-禁用
    @Column(name = "status")
    private String status;

    @Transient
    private String isAdmin;

    @Transient
    private List<Permission> permissionList;

}
