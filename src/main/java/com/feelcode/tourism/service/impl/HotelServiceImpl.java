package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.HotelDao;
import com.feelcode.tourism.entity.Hotel;
import com.feelcode.tourism.entity.HotelRequestPageDTO;
import com.feelcode.tourism.entity.Spots;
import com.feelcode.tourism.service.HotelService;
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
import java.util.Date;
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
    public Page<Hotel> findAllByKeys(HotelRequestPageDTO request,Pageable pageable) {
        return hotelDao.findAll(Specifications.where(getWhereClause(request)),pageable);
    }

    @Override
    public Long findAllByCount() {
        return hotelDao.count();
    }

    public Specification<Hotel> getWhereClause(final HotelRequestPageDTO keys) {
        return new Specification<Hotel>() {
            @Override
            public Predicate toPredicate(Root<Hotel> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if(StringUtils.isNotEmpty(keys.getHotelName())){
                    predicate.getExpressions().add(
                            cb.like(r.<String>get("hotelName"), "%" + StringUtils.trim(keys.getHotelName()) + "%")
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
                if(StringUtils.isNotEmpty(keys.getHotelAddress())){
                    predicate.getExpressions().add(
                            cb.like(r.<String>get("hotelAddress"),"%" + StringUtils.trim(keys.getHotelAddress()) + "%")
                    );
                }
                if(StringUtils.isNotEmpty(keys.getStar())){
                    predicate.getExpressions().add(
                            cb.equal(r.<String>get("star"), StringUtils.trim(keys.getStar()))
                    );
                }
                if (StringUtils.isNotEmpty(keys.getHotelPriceMin())) {
                    predicate.getExpressions().add(
                            cb.greaterThanOrEqualTo(r.get("hotelPrice").as(String.class), keys.getHotelPriceMin()));
                }
                if (StringUtils.isNotEmpty(keys.getHotelPriceMax())) {
                    predicate.getExpressions().add(
                            cb.lessThanOrEqualTo(r.get("hotelPrice").as(String.class), keys.getHotelPriceMax()));
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
