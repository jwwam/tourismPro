package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Order;
import com.feelcode.tourism.entity.OrderRequestPageDTO;
import org.springframework.data.domain.Page;

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

    void delete(Order order);

    List<Order> findAll();

    Page<Order> findAllByPage(OrderRequestPageDTO request);

    Order findByUserIdAndProductId(String userId, String productId);

    Page<Order> findAllByUserIdAndPage(OrderRequestPageDTO request);

    Long findAllByCount();

}
