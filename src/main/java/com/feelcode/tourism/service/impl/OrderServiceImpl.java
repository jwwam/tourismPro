package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.OrderDao;
import com.feelcode.tourism.entity.Order;
import com.feelcode.tourism.entity.OrderRequestPageDTO;
import com.feelcode.tourism.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:17 2020/5/7
 * @Modified By:
 */
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;

    @Override
    public Order save(Order order) {
        return orderDao.save(order);
    }

    @Override
    public Order findById(String id) {
        return orderDao.findById(id);
    }

    @Override
    public void delete(Order order) {
        orderDao.delete(order);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public Page<Order> findAllByPage(OrderRequestPageDTO request) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
        return orderDao.findAll(pageable);
    }

    @Override
    public Long findAllByCount() {
        return orderDao.count();
    }
}
