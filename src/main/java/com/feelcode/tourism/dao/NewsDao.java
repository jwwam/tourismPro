package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:33 2021/5/7
 * @Modified By:
 */
@Transactional
public interface NewsDao extends PagingAndSortingRepository<News, Long>, JpaSpecificationExecutor<News>, JpaRepository<News,Long> {
    News findById(String id);
}
