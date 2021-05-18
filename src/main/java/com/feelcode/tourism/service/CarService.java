package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Car;
import com.feelcode.tourism.entity.CarRequestPageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:16 2020/5/7
 * @Modified By:
 */
public interface CarService {
    Car save(Car car);

    Car findById(String id);

    void delete(Car car);

    List<Car> findAll();

    Page<Car> findAllByPage(CarRequestPageDTO request);

    Page<Car> findAllByKeys(CarRequestPageDTO request, Pageable pageable);

    Long findAllByCount();
}
