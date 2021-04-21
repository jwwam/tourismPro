package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.base.utils.UUIDUtils;
import com.feelcode.tourism.entity.*;
import com.feelcode.tourism.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: BlogController
 * @Author: 朱利尔
 * @Description: TODO
 * @Date: Created in 23:15 2021/4/7
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/c/blog")
@Slf4j
public class BlogController extends BaseController {

    @Resource
    BlogService blogService;

    /**
     * 保存博客
     * @param blog
     * @param blog
     * @return
     */
    @RequestMapping(value="/post", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap saveBlog(@RequestBody Blog blog) {
        //session校验
        try {
            //if(StringUtils.isEmpty(blog.getId())){
                //新增博客文章
                log.info("新增博客文章");
//                User user = (User)userService.findByName(username);
                //blog.setUser(user);
                blog.setId(UUIDUtils.getUuid());
                blogService.saveBlog(blog);
//            }else{
//                //修改博客文章
//                logger.info("修改博客文章");
//                Blog orignalBlog = blogService.getBlogById(blog.getId());
//                orignalBlog.setTitle(blog.getTitle());
//                orignalBlog.setSummary(blog.getSummary());
//                orignalBlog.setContent(blog.getContent());
//                orignalBlog.setUpdateDate(new Date());
//                orignalBlog.setMdHtmlContent(blog.getMdHtmlContent());
//                blogService.saveBlog(orignalBlog);
//            }
        } catch (Exception e)  {
            log.error(e.getMessage());
            return getModelMap(StateParameter.FAULT, e.getMessage(),"发布失败");
        }
        String redirectUrl = "/blog-detail.html?id=" + blog.getId();
        return getModelMap(StateParameter.SUCCESS, redirectUrl,"发布成功");
    }

    /**
     * @auther: 朱利尔
     * @Description: 游记列表
     * @date: 22:23 2021/4/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap list(@RequestBody BlogRequestPageDTO request){
        //C端分页暂时均未实现
        BlogResponsePageDTO resList = new BlogResponsePageDTO();
        Long count = blogService.findAllByCount();
        Page<Blog> blogPage = null;
        if(!StringUtils.isEmpty(request.getTitle())){
            Sort sort = new Sort(Sort.Direction.DESC,"createDate");
            Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort);
            blogPage = blogService.findAllByKeys(request.getTitle(), pageable);
        }else{
            blogPage = blogService.findAllByPage(request);
        }
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        resList.setBlogList(blogPage.getContent());
        log.info("返回游记列表：{}", resList);
        return getModelMap(StateParameter.SUCCESS, resList, "获取游记列表成功");
    }

    /**
     * @auther: 朱利尔
     * @Description: 游记详情
     * @date: 22:23 2021/4/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/detail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap detail(@RequestBody Blog request){
        blogService.readingIncrease(request.getId());
        Blog blog = blogService.getBlogById(request.getId());
        log.info("返回游记详情：{}", blog);
        return getModelMap(StateParameter.SUCCESS, blog, "获取游记详情成功");
    }

}
