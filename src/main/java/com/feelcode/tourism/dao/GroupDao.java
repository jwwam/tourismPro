package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:09 2020/5/16
 * @Modified By:
 */
public interface GroupDao extends PagingAndSortingRepository<Group, Long>, JpaSpecificationExecutor<Group>, JpaRepository<Group,Long> {
    Group findById(String id);
}
