package com.feelcode.tourism.base.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/** 
 * @auther: 朱利尔
 * @Description: 
 * @date: 15:11 2020/5/8
 * @param: 
 * @return: 
 */
@Component
public class UUIDUtils {

    public static String getUuid(){
        String uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象
        uuid = uuid.replace("-", "");
        return uuid;
    }

}
