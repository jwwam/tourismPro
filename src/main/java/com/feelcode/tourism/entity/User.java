package com.feelcode.tourism.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName: User
 * @Auther: 朱利尔
 * @Date: 2020/4/30 17:17
 * @Description:
 */
@Entity
@Table(name = "tourism_user")
@Data
public class User extends BaseEntity{

    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "user_name", length = 100)
    private String userName;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "age")
    private Long age;

    @Column(name = "create_date")
    private Date createDate;

}
