package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 15:19 2020/5/16
 * @Modified By:
 */
public interface ScoreDao extends PagingAndSortingRepository<Score, Long>, JpaSpecificationExecutor<Score>, JpaRepository<Score,Long> {

    Score findById(String id);

    List<Score> findByProductId(String id);

    @Query(value = "select * from tourism_score group by product_id",nativeQuery = true)
    List<Score> findAllGroupByProductId();

    Score findByUserIdAndProductId(String userId, String productId);

}
