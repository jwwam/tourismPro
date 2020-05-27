package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Score;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 17:14 2020/5/25
 * @Modified By:
 */
public interface ScoreService {
    Score save(Score score);

    Score findById(String id);

    void delete(Score score);

    List<Score> findAll();

    Score findByUserIdAndProductId(String userId, String productId);

    Long findAllByCount();
}
