package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Hotel;
import com.feelcode.tourism.entity.HotelRequestPageDTO;
import org.springframework.data.domain.Page;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:16 2020/5/7
 * @Modified By:
 */
public interface HotelService {
    Hotel save(Hotel hotel);

    Hotel findById(String id);

    void delete(Hotel hotel);

    List<Hotel> findAll();

    Page<Hotel> findAllByPage(HotelRequestPageDTO request);

    Long findAllByCount();
}
