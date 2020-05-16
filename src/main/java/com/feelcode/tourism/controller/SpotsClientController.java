package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.Spots;
import com.feelcode.tourism.entity.SpotsRecommendListResponsePageDTO;
import com.feelcode.tourism.entity.SpotsRequestPageDTO;
import com.feelcode.tourism.entity.SpotsResponsePageDTO;
import com.feelcode.tourism.service.SpotsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:38 2020/5/7
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/c/spots")
@Slf4j
public class SpotsClientController extends BaseController {

    @Resource
    SpotsService spotsService;

    /**
     * @auther: 朱利尔
     * @Description: 景点保存&更新
     * @date: 22:21 2020/5/7
     * @param: [spots]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/addSpots", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap addSpots(@RequestBody Spots spots){
        try {
            if(StringUtils.isEmpty(spots.getId())){
                spots.setId(getUuid());
            }else{
                spots.setUpdateDate(new Date());
            }
            spotsService.save(spots);
            log.info("保存成功");
            return getModelMap(StateParameter.SUCCESS, null, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "保存失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 景点删除
     * @date: 22:22 2020/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/deleteSpots", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap deleteSpots(@RequestBody Spots request){
        try {
            Spots spots = spotsService.findById(request.getId());
            if(spots==null){
                return getModelMap(StateParameter.FAULT, request, "找不到该景点信息");
            }
            spotsService.delete(spots);
            return getModelMap(StateParameter.SUCCESS, null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 景点列表
     * @date: 22:23 2020/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap list(@RequestBody SpotsRequestPageDTO request){
        //C端分页暂时均未实现
        SpotsResponsePageDTO resList = new SpotsResponsePageDTO();
        Long count = spotsService.findAllByCount();
        Page<Spots> spotsPage = null;
        if(!StringUtils.isEmpty(request.getSpotsName())){
            Sort sort = new Sort(Sort.Direction.DESC,"createDate");
            Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort);
            spotsPage = spotsService.findAllByKeys(request.getSpotsName(), pageable);
        }else{
            spotsPage = spotsService.findAllByPage(request);
        }
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        resList.setSpotsList(spotsPage.getContent());
        log.info("返回景点列表：{}", resList);
        return getModelMap(StateParameter.SUCCESS, resList, "获取景点列表成功");
    }

    /**
     * @auther: 朱利尔
     * @Description: 景点推荐列表
     * @date: 22:23 2020/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/recommendList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap recommendList(@RequestBody SpotsRequestPageDTO request){
        //C端分页暂时均未实现
        SpotsRecommendListResponsePageDTO resList = new SpotsRecommendListResponsePageDTO();
        Long count = spotsService.findAllByCount();
        Sort sort = new Sort(Sort.Direction.DESC,"createDate");
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort);
        Page<Spots> spotsPage = spotsService.findAllByKeys(request.getSpotsName(), pageable);
        if(spotsPage.getContent().size()!=0){
            resList.setRecordsTotal(count);
            resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
            resList.setSpots(spotsPage.getContent().get(0));
            List<Spots> spotsList = spotsService.findRecommendList(resList.getSpots().getId());
            resList.setSpotsList(spotsList);
            log.info("返回景点列表：{}", resList);
            return getModelMap(StateParameter.SUCCESS, resList, "获取景点列表成功");
        }
        return getModelMap(StateParameter.FAULT, resList, "未找到您要查询的景点，请输入其他景点再次尝试。");
    }


    /**
     * @auther: 朱利尔
     * @Description: 景点详情
     * @date: 22:23 2020/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/detail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap detail(@RequestBody Spots request){
        Spots spots = spotsService.findById(request.getId());
        log.info("返回景点详情：{}", spots);
        return getModelMap(StateParameter.SUCCESS, spots, "获取景点详情成功");
    }


}
