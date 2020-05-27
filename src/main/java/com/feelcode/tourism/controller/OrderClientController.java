package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.constant.SystemConstant;
import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.Hotel;
import com.feelcode.tourism.entity.Order;
import com.feelcode.tourism.entity.OrderRequestPageDTO;
import com.feelcode.tourism.entity.OrderResponsePageDTO;
import com.feelcode.tourism.service.HotelService;
import com.feelcode.tourism.service.OrderService;
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
 * @Date: Created in 23:37 2020/5/7
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/c/order")
@Slf4j
public class OrderClientController extends BaseController {

    @Resource
    OrderService orderService;
    @Resource
    HotelService hotelService;

    /**
     * @auther: 朱利尔
     * @Description: 订单保存&更新
     * @date: 22:21 2020/5/7
     * @param: [order]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap create(@RequestBody Order order){
        try {
            if(StringUtils.isEmpty(order.getId())){
                order.setId(getUuid());
            }else{
                order.setUpdateDate(new Date());
            }
            if(SystemConstant.ProductType.hotel.equals(order.getProductType())){
                Order oldOrder = orderService.findByUserIdAndProductId(order.getUserId(),order.getProductId());
                if(oldOrder!=null && SystemConstant.OrderStatus.submit.equals(oldOrder.getOrderStatus())){
                    return getModelMap(StateParameter.FAULT, null, "不能重复提交订单");
                }
                Hotel hotel = hotelService.findById(order.getProductId());
                order.setOrderAmount(hotel.getHotelPrice());
                order.setPreviewImage((hotel.getHotelImages().split(","))[0]);
                order.setDealingTime(new Date());
                order.setOrderStatus(SystemConstant.OrderStatus.submit);
            }
            orderService.save(order);
            log.info("订单提交成功");
            return getModelMap(StateParameter.SUCCESS, null, "订单提交成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "订单提交失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 订单删除
     * @date: 22:22 2020/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/deleteOrder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap deleteOrder(@RequestBody Order request){
        try {
            Order order = orderService.findById(request.getId());
            if(order==null){
                return getModelMap(StateParameter.FAULT, request, "找不到该订单信息");
            }
            orderService.delete(order);
            return getModelMap(StateParameter.SUCCESS, null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 订单列表
     * @date: 22:23 2020/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap list(@RequestBody OrderRequestPageDTO request){

        OrderResponsePageDTO resList = new OrderResponsePageDTO();
        Long count = orderService.findAllByCount();
        Page<Order> orderPage = orderService.findAllByUserIdAndPage(request);
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        resList.setOrderList(orderPage.getContent());
        log.info("返回订单列表：{}", resList);
        return getModelMap(StateParameter.SUCCESS, resList, "获取订单列表成功");
    }

}
