package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.News;
import com.feelcode.tourism.entity.NewsRequestPageDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:16 2021/5/7
 * @Modified By:
 */
public interface NewsService {
    News save(News news);

    News findById(String id);

    void delete(News news);

    List<News> findAll();

    Page<News> findAllByPage(NewsRequestPageDTO request);

    Long findAllByCount();
}
