package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.base.utils.CFUtils;
import com.feelcode.tourism.dao.ScoreDao;
import com.feelcode.tourism.dao.SpotsDao;
import com.feelcode.tourism.entity.Score;
import com.feelcode.tourism.entity.Spots;
import com.feelcode.tourism.entity.SpotsRequestPageDTO;
import com.feelcode.tourism.service.SpotsService;
import lombok.extern.slf4j.Slf4j;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:17 2020/5/7
 * @Modified By:
 */
@Service(value = "spotsService")
@Slf4j
public class SpotsServiceImpl implements SpotsService {

    @Resource
    SpotsDao spotsDao;
    @Resource
    ScoreDao scoreDao;
    private static final double pearsonCorrelation = 0.95;

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
    public List<Spots> findRecommendList(String id) {
        List<Score> productScoreList = scoreDao.findByProductId(id);
        double[] ownProductScoreList = new double[productScoreList.size()];
        for (int i = 0; i < productScoreList.size(); i++) {
            ownProductScoreList[i] = Double.parseDouble(productScoreList.get(i).getGrade());
        }
        List<Score> productCountInScoreList = scoreDao.findAllGroupByProductId();
        HashMap<String,double[]> ss = new HashMap<String,double[]>();
        for (int i = 0; i < productCountInScoreList.size(); i++) {
            List<Score> bb = scoreDao.findByProductId(productCountInScoreList.get(i).getProductId());
            double[] otherProductScoreList = new double[bb.size()];
            for (int j = 0; j < bb.size(); j++) {
                otherProductScoreList[j] = Double.parseDouble(bb.get(j).getGrade());
            }
            ss.put(productCountInScoreList.get(i).getProductId(),otherProductScoreList);
        }
        List<Spots> resSpotsList = new ArrayList<>();
        ss.forEach((String k, double[] v)->{
            double n = CFUtils.cosineSimilarity(ownProductScoreList,v);
            log.info("id：{},线性相似度：{}",k,n);
            if(n > pearsonCorrelation) {
                resSpotsList.add(spotsDao.findById(k));
            }
        });
        return resSpotsList;
    }

    @Override
    public Page<Spots> findAllByPage(SpotsRequestPageDTO request) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
        return spotsDao.findAll(pageable);
    }

    @Override
    public Page<Spots> findAllByKeys(SpotsRequestPageDTO param, Pageable pageable) {
        return spotsDao.findAll(Specifications.where(getWhereClause(param)),pageable);
    }

    @Override
    public Long findAllByCount() {
        return spotsDao.count();
    }

    public Specification<Spots> getWhereClause(final SpotsRequestPageDTO param) {
        return new Specification<Spots>() {
            @Override
            public Predicate toPredicate(Root<Spots> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if (StringUtils.isNotEmpty(param.getSpotsName())) {
                    predicate.getExpressions().add(
                            cb.like(r.<String>get("spotsName"), "%" + StringUtils.trim(param.getSpotsName()) + "%")
                    );
                }
                if (StringUtils.isNotEmpty(param.getId())) {
                    predicate.getExpressions().add(
                            cb.equal(r.<String>get("id"), StringUtils.trim(param.getId()))
                    );
                }
//                if(StringUtils.isNotEmpty(star)){
//                    predicate.getExpressions().add(
//                            cb.like(r.<String>get("star"),"%" + StringUtils.trim(star) + "%")
//                    );
//                }
                return predicate;
            }
        };
    }

}
