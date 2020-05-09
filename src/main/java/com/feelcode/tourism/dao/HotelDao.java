package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:51 2020/5/7
 * @Modified By:
 */
@Transactional
public interface HotelDao extends PagingAndSortingRepository<Hotel, Long>, JpaSpecificationExecutor<Hotel>, JpaRepository<Hotel,Long> {
    Hotel findById(String id);
}
