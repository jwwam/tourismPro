package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {

    /**
     * 保存Blog
     * @param blog
     * @return
     */
    Blog saveBlog(Blog blog);

    /**
     * 删除Blog
     * @param id
     * @return
     */
    void removeBlog(String id);

    /**
     * 更新Blog
     * @param blog
     * @return
     */
    Blog updateBlog(Blog blog);

    /**
     * 根据id获取Blog
     * @param id
     * @return
     */
    Blog getBlogById(String id);

    /**
     * 根据用户名进行分页模糊查询（最新）
     * @param user
     * @return
     */
    Page<Blog> listBlogsByTitleLike(User user, String title, Pageable pageable);

    /**
     * 根据用户名进行分页模糊查询（最热）
     * @param user
     * @return
     */
    Page<Blog> listBlogsByTitleLikeAndSort(User suser, String title, Pageable pageable);

    /**
     * 阅读量递增
     * @param id
     */
    void readingIncrease(String id);


    /**
     * 博客列表，分页
     * @param pageable
     * @return
     */
    Page<Blog> listBlogs(Pageable pageable);

    List<Blog> findAll();

    //List<Blog> findRecommendList(String id);

    Page<Blog> findAllByPage(BlogRequestPageDTO request);

    Page<Blog> findAllByKeys(String blogName, Pageable pageable);

    Long findAllByCount();

}
