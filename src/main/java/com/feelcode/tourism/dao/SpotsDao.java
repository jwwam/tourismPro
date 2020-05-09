package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Spots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:32 2020/5/7
 * @Modified By:
 */
@Transactional
public interface SpotsDao extends PagingAndSortingRepository<Spots, Long>, JpaSpecificationExecutor<Spots>, JpaRepository<Spots,Long> {
    Spots findById(String id);
}
