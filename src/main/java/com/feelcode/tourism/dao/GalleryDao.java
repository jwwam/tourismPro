package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:51 2021/4/7
 * @Modified By:
 */
@Transactional
public interface GalleryDao extends PagingAndSortingRepository<Gallery, Long>, JpaSpecificationExecutor<Gallery>, JpaRepository<Gallery,Long> {
    Gallery findById(String id);
}
