package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:33 2021/4/7
 * @Modified By:
 */
@Transactional
public interface RolePermissionDao extends PagingAndSortingRepository<RolePermission, Long>, JpaSpecificationExecutor<RolePermission>, JpaRepository<RolePermission,Long> {
    RolePermission findById(String id);
    List<RolePermission> findByRoleId(String roleId);
}
