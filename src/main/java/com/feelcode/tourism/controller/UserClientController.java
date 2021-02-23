package com.feelcode.tourism.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.RedisConstants;
import com.feelcode.tourism.base.utils.RedisUtil;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.ChangePasswordEntity;
import com.feelcode.tourism.entity.User;
import com.feelcode.tourism.entity.UserSessionEntity;
import com.feelcode.tourism.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 21:59 2020/5/7
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/c/user")
@Slf4j
public class UserClientController extends BaseController {

    @Resource
    UserService userService;
    @Resource
    RedisUtil redisUtil;

    /**
     * @auther: zhangyingqi
     * @date: 17:37 2020/4/30
     * @param: [request, user]
     * @return: org.springframework.ui.ModelMap
     * @Description: 用户注册
     */
    @RequestMapping(value="/logon", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap logon(@RequestBody User user){
        try {
            User us = userService.findByUserName(user.getUserName());
            if(us!=null){
                return getModelMap(StateParameter.FAULT, null, "注册失败，用户已存在");
            }else {
                user.setId(getUuid());
                user.setUserName(user.getUserName());
                user.setPassword(user.getPassword());
                userService.save(user);
                log.info("注册成功");
                return getModelMap(StateParameter.SUCCESS, us, "注册成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "注册失败");
        }
    }

    /**
     * @auther: zhangyingqi
     * @date: 17:37 2020/4/30
     * @param: [request, user]
     * @return: org.springframework.ui.ModelMap
     * @Description: 用户登录
     */
    @RequestMapping(value="/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap login(@RequestBody User user){
        try {
            User us = userService.findByUserNameAndPassword(user.getUserName(),user.getPassword());
            if(us!=null){
                UserSessionEntity userSessionEntity = new UserSessionEntity();
                userSessionEntity.setUserName(us.getUserName());
                us.setUserInfo(userSessionEntity);
                String userJsonString = JSON.toJSONString(us);
                redisUtil.set("user_session_"+us.getId(), userJsonString, RedisConstants.datebase1,300);
                if("admin".equals(us.getUserName())){
                    us.setIsAdmin("true");
                }
                return getModelMap(StateParameter.SUCCESS, us, "登录成功");
            }else {
                return getModelMap(StateParameter.FAULT, null, "登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "登录失败");
        }
    }

    /**
     * @auther: zhangyingqi
     * @date: 17:37 2020/4/30
     * @param: [request, user]
     * @return: org.springframework.ui.ModelMap
     * @Description: 用户注销
     */
    @RequestMapping(value="/logout", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap logout(@RequestBody User user){
        try {
            User us = userService.findByUserName(user.getUserName());
            if(us!=null){
                redisUtil.del(RedisConstants.datebase1, "user_session_"+us.getId());
                return getModelMap(StateParameter.SUCCESS, us, "注销成功");
            }else {
                return getModelMap(StateParameter.FAULT, null, "注销失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "注销失败");
        }
    }

    /**
     * @auther: zhangyingqi
     * @date: 17:37 2020/4/30
     * @param: [request, user]
     * @return: org.springframework.ui.ModelMap
     * @Description: 用户保存&更新
     */
    @RequestMapping(value="/getSession", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap getSession(@RequestBody User user){
        try {
            Object obj = redisUtil.get("user_session_"+user.getId(),RedisConstants.datebase1);
            if(obj!=null){
                redisUtil.expire("user_session_"+user.getId(),RedisConstants.datebase1,300);
                User us = JSON.parseObject(obj.toString(),User.class);
                UserSessionEntity userSessionEntity = new UserSessionEntity();
                userSessionEntity.setUserName(us.getUserName());
                us.setUserInfo(userSessionEntity);
                return getModelMap(StateParameter.SUCCESS, us, "已登录");
            }else {
                return getModelMap(StateParameter.FAULT, null, "未登录");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "登录态检测失败");
        }
    }

    /**
     * @Author: zhangyingqi
     * @Date: 21:28 2021/2/23
     * @Param: [user]
     * @Return: org.springframework.ui.ModelMap
     * @Description: 用户修改密码
     */
    @RequestMapping(value="/changePassword", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap changePassword(@RequestBody ChangePasswordEntity param){
        try {
            User us = userService.findById(param.getUserId());
            if(us!=null && us.getPassword().equals(param.getOldpassword())){
                Integer res = userService.changePassword(us.getId(),param.getNewpassword());
                if(res != 1){
                    log.info("数据库密码修改失败");
                    return getModelMap(StateParameter.FAULT, null, "修改失败");
                }
                redisUtil.del(RedisConstants.datebase1, "user_session_"+us.getId());
                return getModelMap(StateParameter.SUCCESS, us, "修改成功，请重新登录");
            }else {
                log.info("找不到用户或原密码错误");
                return getModelMap(StateParameter.FAULT, null, "修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "修改失败");
        }
    }

}
