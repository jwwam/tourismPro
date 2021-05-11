package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.FoodDao;
import com.feelcode.tourism.entity.Food;
import com.feelcode.tourism.entity.FoodRequestPageDTO;
import com.feelcode.tourism.service.FoodService;
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
@Service(value = "foodService")
public class FoodServiceImpl implements FoodService {

    @Resource
    FoodDao foodDao;

    @Override
    public Food save(Food food) {
        return foodDao.save(food);
    }

    @Override
    public Food findById(String id) {
        return foodDao.findById(id);
    }

    @Override
    public void delete(Food food) {
        foodDao.delete(food);
    }

    @Override
    public List<Food> findAll() {
        return foodDao.findAll();
    }

    @Override
    public Page<Food> findAllByPage(FoodRequestPageDTO request) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
        return foodDao.findAll(pageable);
    }

    @Override
    public Long findAllByCount() {
        return foodDao.count();
    }
}
