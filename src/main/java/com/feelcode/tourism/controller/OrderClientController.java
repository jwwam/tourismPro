package com.feelcode.tourism.controller;

import com.alibaba.fastjson.JSON;
import com.feelcode.tourism.base.constant.SystemConstant;
import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.OrderNoGenerateUtils;
import com.feelcode.tourism.base.utils.RedisConstants;
import com.feelcode.tourism.base.utils.RedisUtil;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.*;
import com.feelcode.tourism.service.CarService;
import com.feelcode.tourism.service.OrderService;
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
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 23:37 2021/5/7
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
    CarService carService;
    @Resource
    SpotsService spotsService;
    @Resource
    RedisUtil redisUtil;

    /**
     * @auther: 朱利尔
     * @Description: 订单保存&更新
     * @date: 22:21 2021/5/7
     * @param: [order]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap create(@RequestBody Order order){
        try {
            if(StringUtils.isEmpty(order.getUserId())){
                return getModelMap(StateParameter.FAULT, null, "订单提交失败，请重新登陆【参数校验错误userId is empty】");
            }
            Object obj = redisUtil.get("user_session_"+ order.getUserId(), RedisConstants.datebase1);
            if(obj==null){
                return getModelMap(StateParameter.FAULT, null, "订单提交失败，请重新登录后预订");
            }
            User u = JSON.parseObject(obj.toString(),User.class);
            if(StringUtils.isEmpty(order.getId())){
                order.setId(getUuid());
            }else{
                order.setUpdateDate(new Date());
            }
            Order oldOrder = orderService.findByUserIdAndProductId(order.getUserId(),order.getProductId());
            if(oldOrder!=null && SystemConstant.OrderStatus.submit.equals(oldOrder.getOrderStatus())){
                return getModelMap(StateParameter.FAULT, null, "当前存在未支付的订单，请不要重复提交");
            }
            Map<String,String> va = new HashMap<>();
            if(SystemConstant.ProductType.hotel.equals(order.getProductType())){
                Car car = carService.findById(order.getProductId());
                va.put("orderAmount", car.getCarPrice());
                va.put("previewImages", car.getCarImages());
                va.put("productName", car.getCarName());
                order.setOrderContent(order.getOrderContent());
            }
//            if(SystemConstant.ProductType.flight.equals(order.getProductType())){
//                Flight flight = flightservice.findById(order.getProductId());
//                va.put("orderAmount", flight.getFlightPrice());
//                va.put("previewImages", flight.getFlightImages());
//                va.put("productName",flight.getFlightName());
//                order.setOrderContent(JSON.toJSONString(flight));
//            }
            if(SystemConstant.ProductType.spots.equals(order.getProductType())){
                Spots spots = spotsService.findById(order.getProductId());
                va.put("orderAmount", spots.getSpotsPrice());
                va.put("previewImages", spots.getSpotsImages());
                va.put("productName",spots.getSpotsName());
                order.setOrderContent(JSON.toJSONString(spots));
            }
            order.setUserName(u.getUserName());
            order.setOrderNo(OrderNoGenerateUtils.getOrderNoNYR(String.valueOf(order.getProductType()), new Date()));
            order.setOrderAmount(String.valueOf(va.get("orderAmount")));
            order.setPreviewImages(String.valueOf(va.get("previewImages")).split(",")[0]);
            order.setProductName(String.valueOf(va.get("productName")));
            order.setDealingTime(new Date());
            orderService.save(order);
            log.info("订单提交成功");
            return getModelMap(StateParameter.SUCCESS, order, "订单提交成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "订单提交失败");
        }
    }

    @RequestMapping(value="/pay", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap pay(@RequestBody Order order){
        try {
            if(StringUtils.isEmpty(order.getUserId())){
                return getModelMap(StateParameter.FAULT, null, "支付失败，参数校验错误userId is empty");
            }
            if(StringUtils.isEmpty(order.getOrderNo())){
                return getModelMap(StateParameter.FAULT, null, "支付失败，参数校验错误orderNo is empty");
            }
            Object obj = redisUtil.get("user_session_"+ order.getUserId(), RedisConstants.datebase1);
            if(obj==null){
                return getModelMap(StateParameter.FAULT, null, "支付失败，请重新登录后支付");
            }
            Order o = orderService.findByOrderNo(order.getOrderNo());
            if(o==null){
                return getModelMap(StateParameter.FAULT, null, "支付失败，订单不存在");
            }
            if(!SystemConstant.OrderStatus.submit.equals(o.getOrderStatus())){
                return getModelMap(StateParameter.FAULT, null, "支付失败，当前订单已支付");
            }
            o.setOrderStatus(1);
            o.setUpdateDate(new Date());
            orderService.save(o);
            log.info("支付成功");
            return getModelMap(StateParameter.SUCCESS, order, "支付成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "支付失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 订单删除
     * @date: 22:22 2021/5/7
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
     * @date: 22:23 2021/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap list(@RequestBody OrderRequestPageDTO request){

        OrderResponsePageDTO resList = new OrderResponsePageDTO();
        Long count = orderService.findAllByCount();
        Sort sort = new Sort(Sort.Direction.DESC,"createDate");
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort);
        Page<Order> orderPage = orderService.findAllByKeys(request, pageable);
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        resList.setOrderList(orderPage.getContent());
        log.info("返回订单列表：{}", resList);
        return getModelMap(StateParameter.SUCCESS, resList, "获取订单列表成功");
    }

}
