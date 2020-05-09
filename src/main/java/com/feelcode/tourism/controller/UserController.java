package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.User;
import com.feelcode.tourism.entity.UserRequestPageDTO;
import com.feelcode.tourism.entity.UserResponsePageDTO;
import com.feelcode.tourism.service.UserService;
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
 * @Date: Created in 21:59 2020/5/7
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/s/user")
@Slf4j
public class UserController extends BaseController {

    @Resource
    UserService userService;

    /**
     * @auther: zhangyingqi
     * @date: 17:37 2020/4/30
     * @param: [request, user]
     * @return: org.springframework.ui.ModelMap
     * @Description: 用户保存&更新
     */
    @RequestMapping(value="/addUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap addUser(@RequestBody User user){
        try {
            if(StringUtils.isEmpty(user.getId())){
                user.setId(getUuid());
            }else{
                user.setUpdateDate(new Date());
            }
            userService.save(user);
            log.info("保存成功");
            return getModelMap(StateParameter.SUCCESS, user, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "保存失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @date: 17:47 2020/4/30
     * @param: [id]
     * @return: org.springframework.ui.ModelMap
     * @Description: 删除用户
     */
    @RequestMapping(value="/deleteUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap deleteUser(@RequestBody User request){
        try {
            User user = userService.findById(request.getId());
            if(user==null){
                return getModelMap(StateParameter.FAULT, request, "找不到该用户");
            }
            userService.delete(user);
            log.info("删除成功");
            return getModelMap(StateParameter.SUCCESS, null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @date: 17:47 2020/4/30
     * @param: [request]
     * @return: java.lang.String
     * @Description: 查询用户列表
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap view(@RequestBody UserRequestPageDTO request){
        UserResponsePageDTO resList = new UserResponsePageDTO();
        Long count = userService.findAllByCount();
        Page<User> userPage = userService.findAllByPage(request);
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        resList.setUserList(userPage.getContent());
        log.info("返回用户列表");
        return getModelMap(StateParameter.SUCCESS, resList, "获取用户列表成功");
    }

}
