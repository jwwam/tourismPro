package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:33 2021/4/7
 * @Modified By:
 */
@Transactional
public interface PermissionDao extends PagingAndSortingRepository<Permission, Long>, JpaSpecificationExecutor<Permission>, JpaRepository<Permission,Long> {
    Permission findById(String id);
}
