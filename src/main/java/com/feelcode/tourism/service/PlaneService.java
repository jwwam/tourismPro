package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Plane;
import com.feelcode.tourism.entity.PlaneRequestPageDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:16 2020/5/7
 * @Modified By:
 */
public interface PlaneService {
    Plane save(Plane plane);

    Plane findById(String id);

    void delete(Plane plane);

    List<Plane> findAll();

    Page<Plane> findAllByPage(PlaneRequestPageDTO request);

    Long findAllByCount();
}
