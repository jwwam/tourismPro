package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.SpotsDao;
import com.feelcode.tourism.entity.Spots;
import com.feelcode.tourism.entity.SpotsRequestPageDTO;
import com.feelcode.tourism.service.SpotsService;
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
 * @Date: Created in 22:17 2020/5/7
 * @Modified By:
 */
@Service(value = "spotsService")
public class SpotsServiceImpl implements SpotsService {

    @Resource
    SpotsDao spotsDao;

    @Override
    public Spots save(Spots spots) {
        return spotsDao.save(spots);
    }

    @Override
    public Spots findById(String id) {
        return spotsDao.findById(id);
    }

    @Override
    public void delete(Spots spots) {
        spotsDao.delete(spots);
    }

    @Override
    public List<Spots> findAll() {
        return spotsDao.findAll();
    }

    @Override
    public Page<Spots> findAllByPage(SpotsRequestPageDTO request) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
        return spotsDao.findAll(pageable);
    }

    @Override
    public Page<Spots> findAllByKeys(String spotsName, Pageable pageable) {
        return spotsDao.findAll(Specifications.where(getWhereClause(spotsName)),pageable);
    }

    @Override
    public Long findAllByCount() {
        return spotsDao.count();
    }

    public Specification<Spots> getWhereClause(final String spotsName) {
        return new Specification<Spots>() {
            @Override
            public Predicate toPredicate(Root<Spots> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if(StringUtils.isNotEmpty(spotsName)){
                    predicate.getExpressions().add(
                            cb.like(r.<String>get("spotsName"), "%" + StringUtils.trim(spotsName) + "%")
                    );
                }
                /*if(StringUtils.isNotEmpty(sPrice)&&StringUtils.isNotEmpty(ePrice)){
                    predicate.getExpressions().add(
                            cb.between(r.<String>get("price"), sPrice, ePrice)
                    );
                }
                if(StringUtils.isNotEmpty(star)){
                    predicate.getExpressions().add(
                            cb.like(r.<String>get("star"),"%" + StringUtils.trim(star) + "%")
                    );
                }*/
                return predicate;
            }
        };

    }

}
