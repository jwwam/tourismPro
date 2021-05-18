package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.Car;
import com.feelcode.tourism.entity.CarRequestPageDTO;
import com.feelcode.tourism.entity.CarResponsePageDTO;
import com.feelcode.tourism.service.CarService;
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

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 21:59 2021/5/7
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/c/car")
@Slf4j
public class CarController extends BaseController {

    @Resource
    CarService carService;

    /**
     * @auther: 朱利尔
     * @Description: 车保存&更新
     * @date: 22:21 2021/5/7
     * @param: [car]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/addCar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap addCar(@RequestBody Car car){
        try {
            if(StringUtils.isEmpty(car.getId())){
                car.setId(getUuid());
            }else{
                car.setUpdateDate(new Date());
            }
            //List<String> carImgs = Arrays.asList(car.getCarImages().split(","));
            carService.save(car);
            log.info("保存成功");
            return getModelMap(StateParameter.SUCCESS, null, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "保存失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 车删除
     * @date: 22:22 2021/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/deleteCar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap deleteCar(@RequestBody Car request){
        try {
            Car car = carService.findById(request.getId());
            if(car ==null){
                return getModelMap(StateParameter.FAULT, request, "找不到该车信息");
            }
            carService.delete(car);
            return getModelMap(StateParameter.SUCCESS, null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 车列表
     * @date: 22:23 2021/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap list(@RequestBody CarRequestPageDTO request){
        CarResponsePageDTO resList = new CarResponsePageDTO();
        Long count = carService.findAllByCount();
        Sort sort = new Sort(Sort.Direction.DESC,"createDate");
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort);
        Page<Car> carPage = carService.findAllByKeys(request, pageable);
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        resList.setCarList(carPage.getContent());
        log.info("返回车列表：{}", resList);
        return getModelMap(StateParameter.SUCCESS, resList, "获取车列表成功");
    }

    /**
     * @auther: 朱利尔
     * @Description: 车详情
     * @date: 22:23 2021/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/detail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap detail(@RequestBody Car request){
        Car car = carService.findById(request.getId());
        log.info("返回车详情：{}", car);
        return getModelMap(StateParameter.SUCCESS, car, "获取车详情成功");
    }

}
