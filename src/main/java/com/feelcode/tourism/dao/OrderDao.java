package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:34 2020/5/7
 * @Modified By:
 */
public interface OrderDao extends PagingAndSortingRepository<Order, Long>, JpaSpecificationExecutor<Order>, JpaRepository<Order,Long> {
    Order findById(String id);
}
