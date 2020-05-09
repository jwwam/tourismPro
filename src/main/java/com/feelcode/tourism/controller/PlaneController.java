package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.PlaneRequestPageDTO;
import com.feelcode.tourism.entity.PlaneResponsePageDTO;
import com.feelcode.tourism.entity.Plane;
import com.feelcode.tourism.service.PlaneService;
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
 * @Date: Created in 23:36 2020/5/7
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/s/plane")
@Slf4j
public class PlaneController extends BaseController {

    @Resource
    PlaneService planeService;

    /**
     * @auther: 朱利尔
     * @Description: 航班保存&更新
     * @date: 22:21 2020/5/7
     * @param: [plane]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/addPlane", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap addPlane(@RequestBody Plane plane){
        try {
            if(StringUtils.isEmpty(plane.getId())){
                plane.setId(getUuid());
            }else{
                plane.setUpdateDate(new Date());
            }
            planeService.save(plane);
            log.info("保存成功");
            return getModelMap(StateParameter.SUCCESS, null, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "保存失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 航班删除
     * @date: 22:22 2020/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/deletePlane", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap deletePlane(@RequestBody Plane request){
        try {
            Plane plane = planeService.findById(request.getId());
            if(plane==null){
                return getModelMap(StateParameter.FAULT, request, "找不到该航班信息");
            }
            planeService.delete(plane);
            return getModelMap(StateParameter.SUCCESS, null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 航班列表
     * @date: 22:23 2020/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap list(@RequestBody PlaneRequestPageDTO request){
        PlaneResponsePageDTO resList = new PlaneResponsePageDTO();
        Long count = planeService.findAllByCount();
        Page<Plane> planePage = planeService.findAllByPage(request);
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        resList.setPlaneList(planePage.getContent());
        log.info("返回航班列表：{}", resList);
        return getModelMap(StateParameter.SUCCESS, resList, "获取航班列表成功");
    }

}
