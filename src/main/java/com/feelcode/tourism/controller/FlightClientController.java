package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.Flight;
import com.feelcode.tourism.entity.FlightRequestPageDTO;
import com.feelcode.tourism.entity.FlightResponsePageDTO;
import com.feelcode.tourism.service.FlightService;
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
 * @Date: Created in 23:36 2021/4/7
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/c/flight")
@Slf4j
public class FlightClientController extends BaseController {

    @Resource
    FlightService flightService;

    /**
     * @auther: 朱利尔
     * @Description: 航班保存&更新
     * @date: 22:21 2020/5/7
     * @param: [flight]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/addFlight", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap addFlight(@RequestBody Flight flight){
        try {
            if(StringUtils.isEmpty(flight.getId())){
                flight.setId(getUuid());
            }else{
                flight.setUpdateDate(new Date());
            }
            flightService.save(flight);
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
    @RequestMapping(value="/deleteFlight", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap deleteFlight(@RequestBody Flight request){
        try {
            Flight flight = flightService.findById(request.getId());
            if(flight ==null){
                return getModelMap(StateParameter.FAULT, request, "找不到该航班信息");
            }
            flightService.delete(flight);
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
    public ModelMap list(FlightRequestPageDTO request){
        FlightResponsePageDTO resList = new FlightResponsePageDTO();
        Long count = flightService.findAllByCount();
        Page<Flight> flightPage = flightService.findAllByPage(request);
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        resList.setFlightList(flightPage.getContent());
        log.info("返回航班列表：{}", resList);
        return getModelMap(StateParameter.SUCCESS, resList, "获取航班列表成功");
    }

}
