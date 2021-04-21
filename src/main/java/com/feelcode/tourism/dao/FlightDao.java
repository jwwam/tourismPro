package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:34 2020/5/7
 * @Modified By:
 */
@Transactional
public interface FlightDao extends PagingAndSortingRepository<Flight, Long>, JpaSpecificationExecutor<Flight>, JpaRepository<Flight,Long> {
    Flight findById(String id);
}
