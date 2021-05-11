package com.feelcode.tourism.controller;

import com.alibaba.fastjson.JSONArray;
import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.RedisConstants;
import com.feelcode.tourism.base.utils.RedisUtil;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.Gallery;
import com.feelcode.tourism.entity.GalleryRequestPageDTO;
import com.feelcode.tourism.entity.GalleryResponsePageDTO;
import com.feelcode.tourism.entity.vo.Images;
import com.feelcode.tourism.service.GalleryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 21:59 2021/4/7
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/c/gallery")
@Slf4j
public class GalleryController extends BaseController {

    @Resource
    GalleryService galleryService;
    @Resource
    RedisUtil redisUtil;

    /**
     * @auther: 朱利尔
     * @Description: 相册保存&更新
     * @date: 22:21 2021/4/7
     * @param: [gallery]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/addGallery", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap addGallery(@RequestBody Gallery gallery){
        try {
            if(StringUtils.isEmpty(gallery.getUserId())){
                return getModelMap(StateParameter.FAULT, null, "参数校验失败，请登录userId is empty");
            }
            Object obj = redisUtil.get("user_session_"+ gallery.getUserId(), RedisConstants.datebase1);
            if(obj==null){
                return getModelMap(StateParameter.FAULT, null, "上传失败，请重新登录后上传");
            }
            if(StringUtils.isEmpty(gallery.getId())){
                gallery.setId(getUuid());
            }else{
                gallery.setUpdateDate(new Date());
            }
            galleryService.save(gallery);
            log.info("保存成功");
            return getModelMap(StateParameter.SUCCESS, null, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "保存失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 相册删除
     * @date: 22:22 2021/4/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/deleteGallery", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap deleteGallery(@RequestBody Gallery request){
        try {
            Gallery gallery = galleryService.findById(request.getId());
            if(gallery==null){
                return getModelMap(StateParameter.FAULT, request, "找不到该相册信息");
            }
            galleryService.delete(gallery);
            return getModelMap(StateParameter.SUCCESS, null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 相册列表
     * @date: 22:23 2021/4/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap list(@RequestBody GalleryRequestPageDTO request){
        GalleryResponsePageDTO resList = new GalleryResponsePageDTO();
        Long count = galleryService.findAllByCount();
        Sort sort = new Sort(Sort.Direction.DESC,"createDate");
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort);
        Page<Gallery> galleryPage = galleryService.findAllByKeys(request, pageable);
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        galleryPage.getContent().forEach((Gallery gallery)->{
            List<Images> imagesList = JSONArray.parseArray(gallery.getImages(),Images.class);
            gallery.setImageList(imagesList);
        });
        resList.setGalleryList(galleryPage.getContent());
        log.info("返回相册列表：{}", resList);
        return getModelMap(StateParameter.SUCCESS, resList, "获取相册列表成功");
    }

    /**
     * @auther: 朱利尔
     * @Description: 相册详情
     * @date: 22:23 2021/4/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/detail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap detail(@RequestBody Gallery request){
        Gallery gallery = galleryService.findById(request.getId());
        log.info("返回相册详情：{}", gallery);
        return getModelMap(StateParameter.SUCCESS, gallery, "获取相册详情成功");
    }

}
