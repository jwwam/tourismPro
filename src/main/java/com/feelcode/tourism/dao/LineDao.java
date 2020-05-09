package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:33 2020/5/7
 * @Modified By:
 */
@Transactional
public interface LineDao extends PagingAndSortingRepository<Line, Long>, JpaSpecificationExecutor<Line>, JpaRepository<Line,Long> {
    Line findById(String id);
}
