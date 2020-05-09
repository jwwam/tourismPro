package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.Line;
import com.feelcode.tourism.entity.LineRequestPageDTO;
import com.feelcode.tourism.entity.LineResponsePageDTO;
import com.feelcode.tourism.service.LineService;
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
@RequestMapping(value="/c/line")
@Slf4j
public class LineClientController extends BaseController {

    @Resource
    LineService lineService;

    /**
     * @auther: 朱利尔
     * @Description: 旅线保存&更新
     * @date: 22:21 2020/5/7
     * @param: [line]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/addLine", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap addLine(@RequestBody Line line){
        try {
            if(StringUtils.isEmpty(line.getId())){
                line.setId(getUuid());
            }else{
                line.setUpdateDate(new Date());
            }
            lineService.save(line);
            log.info("保存成功");
            return getModelMap(StateParameter.SUCCESS, null, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "保存失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 旅线删除
     * @date: 22:22 2020/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/deleteLine", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap deleteLine(@RequestBody Line request){
        try {
            Line line = lineService.findById(request.getId());
            if(line==null){
                return getModelMap(StateParameter.FAULT, request, "找不到该旅线信息");
            }
            lineService.delete(line);
            return getModelMap(StateParameter.SUCCESS, null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 旅线列表
     * @date: 22:23 2020/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap list(LineRequestPageDTO request){
        LineResponsePageDTO resList = new LineResponsePageDTO();
        Long count = lineService.findAllByCount();
        Page<Line> linePage = lineService.findAllByPage(request);
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        resList.setLineList(linePage.getContent());
        log.info("返回旅线列表：{}", resList);
        return getModelMap(StateParameter.SUCCESS, resList, "获取旅线列表成功");
    }

}
