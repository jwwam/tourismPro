package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.CommentDao;
import com.feelcode.tourism.dao.GroupDao;
import com.feelcode.tourism.entity.Comment;
import com.feelcode.tourism.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

}
