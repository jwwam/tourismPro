package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.CommentDao;
import com.feelcode.tourism.dao.GroupDao;
import com.feelcode.tourism.entity.Comment;
import com.feelcode.tourism.entity.CommentRequestPageDTO;
import com.feelcode.tourism.entity.Spots;
import com.feelcode.tourism.entity.SpotsRequestPageDTO;
import com.feelcode.tourism.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
 * @Date: Created in 18:45 2020/5/24
 * @Modified By:
 */
@Service(value = "commonService")
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentDao commentDao;

    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public Comment findById(String id) {
        return commentDao.findById(id);
    }

    @Override
    public void delete(Comment comment) {
        commentDao.delete(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    @Override
    public Long findAllByCount() {
        return commentDao.count();
    }

    @Override
    public List<Comment> findByUserIdAndProductId(String userId, String productId) {
        return commentDao.findByUserIdAndProductId(userId,productId);
    }

    @Override
    public List<Comment> findByProductId(String productId) {
        return commentDao.findByProductId(productId);
    }

    @Override
    public Page<Comment> findAllByKeys(CommentRequestPageDTO commentRequestPageDTO, Pageable pageable) {
        return commentDao.findAll(Specifications.where(getWhereClause(commentRequestPageDTO)),pageable);
    }

    public Specification<Comment> getWhereClause(final CommentRequestPageDTO param) {
        return new Specification<Comment>() {
            @Override
            public Predicate toPredicate(Root<Comment> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if (StringUtils.isNotEmpty(param.getProductId())) {
                    predicate.getExpressions().add(
                            cb.equal(r.<String>get("productId"), StringUtils.trim(param.getProductId()))
                    );
                }
                if (StringUtils.isNotEmpty(param.getUserId())) {
                    predicate.getExpressions().add(
                            cb.equal(r.<String>get("userId"), StringUtils.trim(param.getUserId()))
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
