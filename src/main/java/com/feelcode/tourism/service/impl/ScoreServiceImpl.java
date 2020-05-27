package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.PlaneDao;
import com.feelcode.tourism.dao.ScoreDao;
import com.feelcode.tourism.entity.Score;
import com.feelcode.tourism.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 17:16 2020/5/25
 * @Modified By:
 */
@Service(value = "scoreService")
public class ScoreServiceImpl implements ScoreService {

    @Resource
    ScoreDao scoreDao;

    @Override
    public Score save(Score score) {
        return scoreDao.save(score);
    }

    @Override
    public Score findById(String id) {
        return scoreDao.findById(id);
    }

    @Override
    public void delete(Score score) {
        scoreDao.delete(score);
    }

    @Override
    public List<Score> findAll() {
        return scoreDao.findAll();
    }

    @Override
    public Score findByUserIdAndProductId(String userId, String productId) {
        return scoreDao.findByUserIdAndProductId(userId, productId);
    }

    @Override
    public Long findAllByCount() {
        return scoreDao.count();
    }
}
