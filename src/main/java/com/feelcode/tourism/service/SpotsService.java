package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Spots;
import com.feelcode.tourism.entity.SpotsRequestPageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:16 2020/5/7
 * @Modified By:
 */
public interface SpotsService {
    Spots save(Spots spots);

    Spots findById(String id);

    void delete(Spots spots);

    List<Spots> findAll();

    List<Spots> findRecommendList(String id);

    Page<Spots> findAllByPage(SpotsRequestPageDTO request);

    Long findAllByCount();

    Page<Spots> findAllByKeys(SpotsRequestPageDTO spotsRequestPageDTO, Pageable pageable);
}
