package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Food;
import com.feelcode.tourism.entity.FoodRequestPageDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:16 2021/5/7
 * @Modified By:
 */
public interface FoodService {
    Food save(Food food);

    Food findById(String id);

    void delete(Food food);

    List<Food> findAll();

    Page<Food> findAllByPage(FoodRequestPageDTO request);

    Long findAllByCount();
}
