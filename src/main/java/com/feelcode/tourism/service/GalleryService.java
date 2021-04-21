package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Gallery;
import com.feelcode.tourism.entity.GalleryRequestPageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:16 2021/4/7
 * @Modified By:
 */
public interface GalleryService {
    Gallery save(Gallery gallery);

    Gallery findById(String id);

    void delete(Gallery gallery);

    List<Gallery> findAll();

    Page<Gallery> findAllByPage(GalleryRequestPageDTO request);

    Page<Gallery> findAllByKeys(GalleryRequestPageDTO request, Pageable pageable);

    Long findAllByCount();
}
