package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:51 2021/5/7
 * @Modified By:
 */
@Transactional
public interface CarDao extends PagingAndSortingRepository<Car, Long>, JpaSpecificationExecutor<Car>, JpaRepository<Car,Long> {
    Car findById(String id);
}
