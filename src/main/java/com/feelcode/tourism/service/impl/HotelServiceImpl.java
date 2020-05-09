package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.HotelDao;
import com.feelcode.tourism.entity.Hotel;
import com.feelcode.tourism.entity.HotelRequestPageDTO;
import com.feelcode.tourism.service.HotelService;
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
@Service(value = "hotelService")
public class HotelServiceImpl implements HotelService {

    @Resource
    HotelDao hotelDao;

    @Override
    public Hotel save(Hotel hotel) {
        return hotelDao.save(hotel);
    }

    @Override
    public Hotel findById(String id) {
        return hotelDao.findById(id);
    }

    @Override
    public void delete(Hotel hotel) {
        hotelDao.delete(hotel);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelDao.findAll();
    }

    @Override
    public Page<Hotel> findAllByPage(HotelRequestPageDTO request) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
        return hotelDao.findAll(pageable);
    }

    @Override
    public Long findAllByCount() {
        return hotelDao.count();
    }
}
