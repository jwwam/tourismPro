package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.News;
import com.feelcode.tourism.entity.NewsRequestPageDTO;
import com.feelcode.tourism.entity.NewsResponsePageDTO;
import com.feelcode.tourism.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:36 2021/5/7
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/c/news")
@Slf4j
public class NewsController extends BaseController {

    @Resource
    NewsService newsService;

    /**
     * @auther: 朱利尔
     * @Description: 资讯保存&更新
     * @date: 22:21 2021/5/7
     * @param: [news]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/addNews", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap addNews(@RequestBody News news){
        try {
            if(StringUtils.isEmpty(news.getId())){
                news.setId(getUuid());
            }else{
                news.setUpdateDate(new Date());
            }
            news.setNewsUser("system");
            newsService.save(news);
            log.info("保存成功");
            return getModelMap(StateParameter.SUCCESS, null, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "保存失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 资讯删除
     * @date: 22:22 2021/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/deleteNews", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap deleteNews(@RequestBody News request){
        try {
            News news = newsService.findById(request.getId());
            if(news==null){
                return getModelMap(StateParameter.FAULT, request, "找不到该资讯信息");
            }
            newsService.delete(news);
            return getModelMap(StateParameter.SUCCESS, null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 资讯列表
     * @date: 22:23 2021/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap list(@RequestBody NewsRequestPageDTO request){
        NewsResponsePageDTO resList = new NewsResponsePageDTO();
        Long count = newsService.findAllByCount();
        Page<News> newsPage = newsService.findAllByPage(request);
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        resList.setNewsList(newsPage.getContent());
        log.info("返回资讯列表：{}", resList);
        return getModelMap(StateParameter.SUCCESS, resList, "获取资讯列表成功");
    }

    /**
     * @auther: 朱利尔
     * @Description: 资讯详情
     * @date: 22:23 2021/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/detail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap detail(@RequestBody News request){
        News news = newsService.findById(request.getId());
        log.info("返回资讯详情：{}", news);
        return getModelMap(StateParameter.SUCCESS, news, "获取资讯详情成功");
    }

}
