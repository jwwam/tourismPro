package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.*;
import com.feelcode.tourism.service.GroupService;
import com.feelcode.tourism.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:36 2021/5/7
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/c/food")
@Slf4j
public class FoodController extends BaseController {

    @Resource
    FoodService foodService;

    /**
     * @auther: 朱利尔
     * @Description: 美食保存&更新
     * @date: 22:21 2021/5/7
     * @param: [food]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/addFood", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap addFood(@RequestBody Food food){
        try {
            if(StringUtils.isEmpty(food.getId())){
                food.setId(getUuid());
            }else{
                food.setUpdateDate(new Date());
            }
            foodService.save(food);
            log.info("保存成功");
            return getModelMap(StateParameter.SUCCESS, null, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "保存失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 美食删除
     * @date: 22:22 2021/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/deleteFood", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap deleteFood(@RequestBody Food request){
        try {
            Food food = foodService.findById(request.getId());
            if(food==null){
                return getModelMap(StateParameter.FAULT, request, "找不到该美食信息");
            }
            foodService.delete(food);
            return getModelMap(StateParameter.SUCCESS, null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 美食列表
     * @date: 22:23 2021/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap list(@RequestBody FoodRequestPageDTO request){
        FoodResponsePageDTO resList = new FoodResponsePageDTO();
        Long count = foodService.findAllByCount();
        Page<Food> foodPage = foodService.findAllByPage(request);
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        resList.setFoodList(foodPage.getContent());
        log.info("返回美食列表：{}", resList);
        return getModelMap(StateParameter.SUCCESS, resList, "获取美食列表成功");
    }

    /**
     * @auther: 朱利尔
     * @Description: 美食详情
     * @date: 22:23 2021/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/detail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap detail(@RequestBody Food request){
        Food food = foodService.findById(request.getId());
        log.info("返回美食详情：{}", food);
        return getModelMap(StateParameter.SUCCESS, food, "获取美食详情成功");
    }

}
