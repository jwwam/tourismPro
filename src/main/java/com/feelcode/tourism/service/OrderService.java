package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Order;
import com.feelcode.tourism.entity.OrderRequestPageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:16 2020/5/7
 * @Modified By:
 */
public interface OrderService {
    Order save(Order order);

    Order findById(String id);

    Order findByOrderNo(String orderNo);

    void delete(Order order);

    List<Order> findAll();

    Page<Order> findAllByPage(OrderRequestPageDTO request);

    Page<Order> findAllByKeys(OrderRequestPageDTO request, Pageable pageable);

    Order findByUserIdAndProductId(String userId, String productId);

    Page<Order> findAllByUserIdAndPage(OrderRequestPageDTO request);

    Long findAllByCount();

}
