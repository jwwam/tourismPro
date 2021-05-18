package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.CarDao;
import com.feelcode.tourism.entity.Car;
import com.feelcode.tourism.entity.CarRequestPageDTO;
import com.feelcode.tourism.service.CarService;
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
@Service(value = "carService")
public class CarServiceImpl implements CarService {

    @Resource
    CarDao carDao;

    @Override
    public Car save(Car car) {
        return carDao.save(car);
    }

    @Override
    public Car findById(String id) {
        return carDao.findById(id);
    }

    @Override
    public void delete(Car car) {
        carDao.delete(car);
    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Page<Car> findAllByPage(CarRequestPageDTO request) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
        return carDao.findAll(pageable);
    }

    @Override
    public Page<Car> findAllByKeys(CarRequestPageDTO request, Pageable pageable) {
        return carDao.findAll(Specifications.where(getWhereClause(request)),pageable);
    }

    @Override
    public Long findAllByCount() {
        return carDao.count();
    }

    public Specification<Car> getWhereClause(final CarRequestPageDTO keys) {
        return new Specification<Car>() {
            @Override
            public Predicate toPredicate(Root<Car> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if(StringUtils.isNotEmpty(keys.getCarName())){
                    predicate.getExpressions().add(
                            cb.like(r.<String>get("carName"), "%" + StringUtils.trim(keys.getCarName()) + "%")
                    );
                }
                if(StringUtils.isNotEmpty(keys.getCheckInTime())){
                    predicate.getExpressions().add(
                            cb.greaterThanOrEqualTo(r.get("checkInTime").as(String.class), keys.getCheckInTime())
                    );
                }
                if(StringUtils.isNotEmpty(keys.getCheckOutTime())){
                    predicate.getExpressions().add(
                            cb.lessThanOrEqualTo(r.get("checkOutTime").as(String.class), keys.getCheckOutTime())
                    );
                }
                if(StringUtils.isNotEmpty(keys.getCarAddress())){
                    predicate.getExpressions().add(
                            cb.like(r.<String>get("carAddress"),"%" + StringUtils.trim(keys.getCarAddress()) + "%")
                    );
                }
                if(StringUtils.isNotEmpty(keys.getStar())){
                    predicate.getExpressions().add(
                            cb.equal(r.<String>get("star"), StringUtils.trim(keys.getStar()))
                    );
                }
                if (StringUtils.isNotEmpty(keys.getCarPriceMin())) {
                    predicate.getExpressions().add(
                            cb.greaterThanOrEqualTo(r.get("carPrice").as(String.class), keys.getCarPriceMin()));
                }
                if (StringUtils.isNotEmpty(keys.getCarPriceMax())) {
                    predicate.getExpressions().add(
                            cb.lessThanOrEqualTo(r.get("carPrice").as(String.class), keys.getCarPriceMax()));
                }
                if(StringUtils.isNotEmpty(keys.getBedType())){
                    predicate.getExpressions().add(
                            cb.like(r.<String>get("bedType"),"%" + StringUtils.trim(keys.getBedType()) + "%")
                    );
                }
                if(StringUtils.isNotEmpty(keys.getOfferType())){
                    predicate.getExpressions().add(
                            cb.equal(r.<String>get("offerType"), StringUtils.trim(keys.getOfferType()))
                    );
                }
                return predicate;
            }
        };
    }

}
