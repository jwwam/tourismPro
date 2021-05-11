package com.feelcode.tourism.base.constant;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 15:33 2020/5/12
 * @Modified By:
 */
public interface SystemConstant {

    /**
     * 1-已提交/待支付
     * 2-已支付
     * 3-已完成
     */
    interface OrderStatus{
        Integer submit = 0;
        Integer pass = 1;
        Integer finish = 2;
    }

    /**
     * 1-酒店
     * 2-航班
     * 3-线路
     * 4-景点
     */
    interface ProductType{
        Integer hotel = 1;
        Integer flight = 2;
        Integer line = 3;
        Integer spots = 4;
    }

}
