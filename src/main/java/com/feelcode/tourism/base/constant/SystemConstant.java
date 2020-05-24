package com.feelcode.tourism.base.constant;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 15:33 2020/5/12
 * @Modified By:
 */
public interface SystemConstant {

    /**
     * 1-已提交
     * 2-已完成
     */
    interface OrderStatus{
        Integer submit = 1;
        Integer done = 2;
    }

    /**
     * 1-酒店
     * 2-航班
     */
    interface ProductType{
        Integer hotel = 1;
        Integer plane = 2;
    }

}
