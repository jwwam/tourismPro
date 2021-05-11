package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Comment;
import com.feelcode.tourism.entity.CommentRequestPageDTO;
import com.feelcode.tourism.entity.Spots;
import com.feelcode.tourism.entity.SpotsRequestPageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 18:44 2020/5/24
 * @Modified By:
 */
public interface CommentService {
    Comment save(Comment comment);

    Comment findById(String id);

    void delete(Comment comment);

    List<Comment> findAll();

    Long findAllByCount();

    List<Comment> findByUserIdAndProductId(String userId, String productId);

    List<Comment> findByProductId(String productId);

    Page<Comment> findAllByKeys(CommentRequestPageDTO commentRequestPageDTO, Pageable pageable);

}
