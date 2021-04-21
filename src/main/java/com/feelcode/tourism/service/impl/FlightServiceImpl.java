package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.FlightDao;
import com.feelcode.tourism.entity.Flight;
import com.feelcode.tourism.entity.FlightRequestPageDTO;
import com.feelcode.tourism.service.FlightService;
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
@Service(value = "flightService")
public class FlightServiceImpl implements FlightService {

    @Resource
    FlightDao flighteDao;

    @Override
    public Flight save(Flight flight) {
        return flighteDao.save(flight);
    }

    @Override
    public Flight findById(String id) {
        return flighteDao.findById(id);
    }

    @Override
    public void delete(Flight flight) {
        flighteDao.delete(flight);
    }

    @Override
    public List<Flight> findAll() {
        return flighteDao.findAll();
    }

    @Override
    public Page<Flight> findAllByPage(FlightRequestPageDTO request) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
        return flighteDao.findAll(pageable);
    }

    @Override
    public Long findAllByCount() {
        return flighteDao.count();
    }
}
