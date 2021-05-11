package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.NewsDao;
import com.feelcode.tourism.entity.News;
import com.feelcode.tourism.entity.NewsRequestPageDTO;
import com.feelcode.tourism.service.NewsService;
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
 * @Date: Created in 22:17 2021/5/7
 * @Modified By:
 */
@Service(value = "newsService")
public class NewsServiceImpl implements NewsService {

    @Resource
    NewsDao newsDao;

    @Override
    public News save(News news) {
        return newsDao.save(news);
    }

    @Override
    public News findById(String id) {
        return newsDao.findById(id);
    }

    @Override
    public void delete(News news) {
        newsDao.delete(news);
    }

    @Override
    public List<News> findAll() {
        return newsDao.findAll();
    }

    @Override
    public Page<News> findAllByPage(NewsRequestPageDTO request) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
        return newsDao.findAll(pageable);
    }

    @Override
    public Long findAllByCount() {
        return newsDao.count();
    }
}
