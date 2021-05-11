package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Food;
import com.feelcode.tourism.entity.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:33 2021/5/7
 * @Modified By:
 */
@Transactional
public interface FoodDao extends PagingAndSortingRepository<Food, Long>, JpaSpecificationExecutor<Food>, JpaRepository<Food,Long> {
    Food findById(String id);
}
