package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.PlaneDao;
import com.feelcode.tourism.entity.Plane;
import com.feelcode.tourism.entity.PlaneRequestPageDTO;
import com.feelcode.tourism.service.PlaneService;
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
@Service(value = "planeService")
public class PlaneServiceImpl implements PlaneService {

    @Resource
    PlaneDao planeDao;

    @Override
    public Plane save(Plane plane) {
        return planeDao.save(plane);
    }

    @Override
    public Plane findById(String id) {
        return planeDao.findById(id);
    }

    @Override
    public void delete(Plane plane) {
        planeDao.delete(plane);
    }

    @Override
    public List<Plane> findAll() {
        return planeDao.findAll();
    }

    @Override
    public Page<Plane> findAllByPage(PlaneRequestPageDTO request) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
        return planeDao.findAll(pageable);
    }

    @Override
    public Long findAllByCount() {
        return planeDao.count();
    }
}
