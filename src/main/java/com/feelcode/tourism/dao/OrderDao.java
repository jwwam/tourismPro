package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Order;
import com.feelcode.tourism.entity.vo.OrderDateCountVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Map;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:34 2020/5/7
 * @Modified By:
 */
public interface OrderDao extends PagingAndSortingRepository<Order, Long>, JpaSpecificationExecutor<Order>, JpaRepository<Order,Long> {

    Order findById(String id);

    Page<Order> findByUserId(String userId, Pageable pageable);

    Order findByUserIdAndProductId(String userId, String productId);

    List<Order> findByOrderStatus(String orderStatus);

    Long countByOrOrderStatus(Integer orderStatus);

    @Query(value = "select new com.feelcode.tourism.entity.vo.OrderDateCountVO(o.dealingTime, count(o.dealingTime))" +
            " from Order o group by DATE_FORMAT(o.dealingTime,'%Y-%m-%d')")
    List<OrderDateCountVO> getDateOrder();

    @Query(value = "select new com.feelcode.tourism.entity.vo.OrderDateCountVO(o.dealingTime, count(o.dealingTime))" +
            " from Order o where o.productType='1' group by DATE_FORMAT(o.dealingTime,'%Y-%m-%d')")
    List<OrderDateCountVO> getHotelDateOrder();

    @Query(value = "select new com.feelcode.tourism.entity.vo.OrderDateCountVO(o.dealingTime, count(o.dealingTime))" +
            " from Order o where o.productType='2' group by DATE_FORMAT(o.dealingTime,'%Y-%m-%d')")
    List<OrderDateCountVO> getPlaneDateOrder();

}
