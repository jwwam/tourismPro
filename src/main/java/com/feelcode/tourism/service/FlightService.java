package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Flight;
import com.feelcode.tourism.entity.FlightRequestPageDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:16 2020/5/7
 * @Modified By:
 */
public interface FlightService {
    Flight save(Flight flight);

    Flight findById(String id);

    void delete(Flight flight);

    List<Flight> findAll();

    Page<Flight> findAllByPage(FlightRequestPageDTO request);

    Long findAllByCount();
}
