package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.LineDao;
import com.feelcode.tourism.entity.Line;
import com.feelcode.tourism.entity.LineRequestPageDTO;
import com.feelcode.tourism.service.LineService;
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
 * @Date: Created in 22:17 2020/5/7
 * @Modified By:
 */
@Service(value = "lineService")
public class LineServiceImpl implements LineService {

    @Resource
    LineDao lineDao;

    @Override
    public Line save(Line line) {
        return lineDao.save(line);
    }

    @Override
    public Line findById(String id) {
        return lineDao.findById(id);
    }

    @Override
    public void delete(Line line) {
        lineDao.delete(line);
    }

    @Override
    public List<Line> findAll() {
        return lineDao.findAll();
    }

    @Override
    public Page<Line> findAllByPage(LineRequestPageDTO request) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
        return lineDao.findAll(pageable);
    }

    @Override
    public Long findAllByCount() {
        return lineDao.count();
    }
}
