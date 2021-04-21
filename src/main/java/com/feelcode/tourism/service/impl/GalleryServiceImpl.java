package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.GalleryDao;
import com.feelcode.tourism.entity.Gallery;
import com.feelcode.tourism.entity.GalleryRequestPageDTO;
import com.feelcode.tourism.service.GalleryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:17 2021/4/7
 * @Modified By:
 */
@Service(value = "galleryService")
public class GalleryServiceImpl implements GalleryService {

    @Resource
    GalleryDao galleryDao;

    @Override
    public Gallery save(Gallery gallery) {
        return galleryDao.save(gallery);
    }

    @Override
    public Gallery findById(String id) {
        return galleryDao.findById(id);
    }

    @Override
    public void delete(Gallery gallery) {
        galleryDao.delete(gallery);
    }

    @Override
    public List<Gallery> findAll() {
        return galleryDao.findAll();
    }

    @Override
    public Page<Gallery> findAllByPage(GalleryRequestPageDTO request) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
        return galleryDao.findAll(pageable);
    }

    @Override
    public Page<Gallery> findAllByKeys(GalleryRequestPageDTO request,Pageable pageable) {
        return galleryDao.findAll(Specifications.where(getWhereClause(request)),pageable);
    }

    @Override
    public Long findAllByCount() {
        return galleryDao.count();
    }

    public Specification<Gallery> getWhereClause(final GalleryRequestPageDTO keys) {
        return new Specification<Gallery>() {
            @Override
            public Predicate toPredicate(Root<Gallery> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if(StringUtils.isNotEmpty(keys.getTitle())){
                    predicate.getExpressions().add(
                            cb.like(r.<String>get("title"), "%" + StringUtils.trim(keys.getTitle()) + "%")
                    );
                }
                if(StringUtils.isNotEmpty(keys.getImgType())){
                    predicate.getExpressions().add(
                            cb.like(r.<String>get("imgType"),"%" + StringUtils.trim(keys.getImgType()) + "%")
                    );
                }
                return predicate;
            }
        };
    }

}
