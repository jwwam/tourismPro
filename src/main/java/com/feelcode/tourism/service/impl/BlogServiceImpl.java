package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.BlogDao;
import com.feelcode.tourism.entity.*;
import com.feelcode.tourism.service.BlogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @ClassName: BlogServiceImpl
 * @Auther: 朱利尔
 * @Date: 2021/4/7 01:29
 * @Description:
 */
@Service(value = "blogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao;

    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {
        return blogDao.save(blog);
    }

    @Transactional
    @Override
    public void removeBlog(String id) {
        blogDao.delete(blogDao.findById(id));
    }

    @Transactional
    @Override
    public Blog updateBlog(Blog blog) {
        return blogDao.save(blog);
    }

    @Override
    public Blog getBlogById(String id) {
        return blogDao.findById(id);
    }

    @Override
    public Page<Blog> listBlogsByTitleLike(User user, String title, Pageable pageable) {
        // 模糊查询
        title = "%" + title + "%";
        Page<Blog> blogs = blogDao.findByUserAndTitleLikeOrderByCreateDateDesc(user, title, pageable);
        return blogs;
    }

    @Override
    public Page<Blog> listBlogsByTitleLikeAndSort(User user, String title, Pageable pageable) {
        // 模糊查询
        title = "%" + title + "%";
        Page<Blog> blogs = blogDao.findByUserAndTitleLike(user, title, pageable);
        return blogs;
    }

    @Override
    public void readingIncrease(String id) {
        Blog blog = blogDao.findById(id);
        blog.setReading(blog.getReading()+1);
        blogDao.save(blog);
    }

    @Override
    public Page<Blog> listBlogs(Pageable pageable) {
        return blogDao.findAll(pageable);
    }

    @Override
    public List<Blog> findAll() {
        return blogDao.findAll();
    }

    @Override
    public Page<Blog> findAllByPage(BlogRequestPageDTO request) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
        return blogDao.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByKeys(String title, Pageable pageable) {
        return blogDao.findAll(Specifications.where(getWhereClause(title)),pageable);
    }

    @Override
    public Long findAllByCount() {
        return blogDao.count();
    }

    public Specification<Blog> getWhereClause(final String title) {
        return new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if(StringUtils.isNotEmpty(title)){
                    predicate.getExpressions().add(
                            cb.like(r.<String>get("title"), "%" + StringUtils.trim(title) + "%")
                    );
                }
                /*if(StringUtils.isNotEmpty(sPrice)&&StringUtils.isNotEmpty(ePrice)){
                    predicate.getExpressions().add(
                            cb.between(r.<String>get("price"), sPrice, ePrice)
                    );
                }
                if(StringUtils.isNotEmpty(star)){
                    predicate.getExpressions().add(
                            cb.like(r.<String>get("star"),"%" + StringUtils.trim(star) + "%")
                    );
                }*/
                return predicate;
            }
        };

    }

}