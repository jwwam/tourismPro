package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.entity.Comment;
import com.feelcode.tourism.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 18:45 2020/5/24
 * @Modified By:
 */
@Service(value = "commonService")
public class CommentServiceImpl implements CommentService {

    @Override
    public Comment save(Comment comment) {
        return null;
    }

    @Override
    public Comment findById(String id) {
        return null;
    }

    @Override
    public void delete(Comment comment) {

    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

}
