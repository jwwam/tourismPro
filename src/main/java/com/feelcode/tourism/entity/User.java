package com.feelcode.tourism.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: User
 * @Auther: 朱利尔
 * @Date: 2020/4/30 17:17
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tourism_user")
@Data
public class User extends BaseEntity implements Serializable {

    @Column(name = "user_name", length = 100)
    private String userName;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "age")
    private Long age;

    @Transient
    private String isAdmin;

}
