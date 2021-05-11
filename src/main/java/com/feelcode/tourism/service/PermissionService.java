package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Permission;
import com.feelcode.tourism.entity.RolePermission;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:16 2021/4/7
 * @Modified By:
 */
public interface PermissionService {
    Permission save(Permission permission);

    Permission findById(String id);

    List<RolePermission> findByRoleId(String roleId);

    void delete(Permission permission);

    List<Permission> findAll();

//    Page<Permission> findAllByPage(PermissionRequestPageDTO request);

    Long findAllByCount();
}
