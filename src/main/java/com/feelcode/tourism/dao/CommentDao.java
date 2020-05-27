package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
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

    @Query(value = "select \n" +
            "c.id,\n" +
            "c.comment_content,\n" +
            "c.comment_time,\n" +
            "c.user_Name,\n" +
            "c.user_id,\n" +
            "c.product_id,\n" +
            "c.create_date,\n" +
            "c.update_date,\n" +
            "c.user_name,\n" +
            "c.comment_num,\n" +
            "c.comment_parent_id,\n" +
            "c.product_type,\n" +
            "s.grade as score \n" +
            "from tourism_comment c \n" +
            "left join tourism_score s \n" +
            "on c.user_id=s.user_id and c.product_id=s.product_id \n" +
            "where c.product_id=?",nativeQuery = true)
    List<Comment>  findByProductId(String productId);

}
