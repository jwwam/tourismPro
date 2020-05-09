package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.*;
import com.feelcode.tourism.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 21:59 2020/5/7
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/s/hotel")
@Slf4j
public class HotelController extends BaseController {

    @Resource
    HotelService hotelService;

    /**
     * @auther: 朱利尔
     * @Description: 酒店保存&更新
     * @date: 22:21 2020/5/7
     * @param: [hotel]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/addHotel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap addHotel(@RequestBody Hotel hotel){
        try {
            if(StringUtils.isEmpty(hotel.getId())){
                hotel.setId(getUuid());
            }else{
                hotel.setUpdateDate(new Date());
            }
            //List<String> hotelImgs = Arrays.asList(hotel.getHotelImages().split(","));
            hotelService.save(hotel);
            log.info("保存成功");
            return getModelMap(StateParameter.SUCCESS, null, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "保存失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 酒店删除
     * @date: 22:22 2020/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/deleteHotel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap deleteHotel(@RequestBody Hotel request){
        try {
            Hotel hotel = hotelService.findById(request.getId());
            if(hotel==null){
                return getModelMap(StateParameter.FAULT, request, "找不到该酒店信息");
            }
            hotelService.delete(hotel);
            return getModelMap(StateParameter.SUCCESS, null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 酒店列表
     * @date: 22:23 2020/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap list(@RequestBody HotelRequestPageDTO request){
        HotelResponsePageDTO resList = new HotelResponsePageDTO();
        Long count = hotelService.findAllByCount();
        Page<Hotel> hotelPage = hotelService.findAllByPage(request);
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        resList.setHotelList(hotelPage.getContent());
        log.info("返回酒店列表：{}", resList);
        return getModelMap(StateParameter.SUCCESS, resList, "获取酒店列表成功");
    }

}
