package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:51 2020/5/7
 * @Modified By:
 */
@Transactional
public interface CommentDao extends PagingAndSortingRepository<Comment, Long>, JpaSpecificationExecutor<Comment>, JpaRepository<Comment,Long> {

    Comment findById(String id);

    List<Comment>  findByUserIdAndProductId(String userId, String productId);

    List<Comment>  findByProductId(String productId);

}
