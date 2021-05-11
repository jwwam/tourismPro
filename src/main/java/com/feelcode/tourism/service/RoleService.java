package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Role;
import com.feelcode.tourism.entity.UserRole;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:16 2021/4/7
 * @Modified By:
 */
public interface RoleService {
    Role save(Role role);

    UserRole saveUserRole(UserRole userRole);

    Role findById(String id);

    Role findByName(String name);

    //暂时每个用户只能有一种角色
    UserRole findByUserId(String userId);

    void delete(Role role);

    List<Role> findAll();

//    Page<Role> findAllByPage(RoleRequestPageDTO request);

    Long findAllByCount();
}
