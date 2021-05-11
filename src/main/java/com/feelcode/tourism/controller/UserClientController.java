package com.feelcode.tourism.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.RedisConstants;
import com.feelcode.tourism.base.utils.RedisUtil;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.*;
import com.feelcode.tourism.service.PermissionService;
import com.feelcode.tourism.service.RoleService;
import com.feelcode.tourism.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
@RequestMapping(value="/c/user")
@Slf4j
public class UserClientController extends BaseController {

    @Resource
    UserService userService;
    @Resource
    RoleService roleService;
    @Resource
    PermissionService permissionService;
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
                //初始化用户角色
                UserRole ur = new UserRole();
                Role role = roleService.findByName("用户");
                ur.setRoleId(role.getId());
                ur.setUserId(user.getId());
                ur.setId(getUuid());
                roleService.saveUserRole(ur);
                user.setUserName(user.getUserName());
                user.setPassword(user.getPassword());
                user.setStatus("1");
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
            if(us!=null && us.getStatus().equals("1")){
                UserSessionEntity userSessionEntity = new UserSessionEntity();
                userSessionEntity.setUserName(us.getUserName());
                us.setUserInfo(userSessionEntity);
                String userJsonString = JSON.toJSONString(us);
                redisUtil.set("user_session_"+us.getId(), userJsonString, RedisConstants.datebase1,600);
                if("admin".equals(us.getUserName())){
                    us.setIsAdmin("true");
                }
                //用户菜单
                UserRole ur = roleService.findByUserId(us.getId());
                List<RolePermission> rp = permissionService.findByRoleId(ur.getRoleId());
                List<Permission> permissionList = new ArrayList<>();
                rp.forEach(rps->{
                    permissionList.add(permissionService.findById(rps.getPermissionId()));
                });
                us.setPermissionList(permissionList);
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
            User u = new User();
            Object obj = redisUtil.get("user_session_"+user.getId(),RedisConstants.datebase1);
            if(obj!=null){
                redisUtil.expire("user_session_"+user.getId(),RedisConstants.datebase1,600);
                u = JSON.parseObject(obj.toString(),User.class);
                UserSessionEntity userSessionEntity = new UserSessionEntity();
                userSessionEntity.setUserName(u.getUserName());
                u.setUserInfo(userSessionEntity);
                //用户菜单
                UserRole ur = roleService.findByUserId(u.getId());
                List<RolePermission> rp = permissionService.findByRoleId(ur.getRoleId());
                List<Permission> permissionList = new ArrayList<>();
                rp.forEach(rps->{
                    permissionList.add(permissionService.findById(rps.getPermissionId()));
                });
                u.setPermissionList(permissionList);
                return getModelMap(StateParameter.SUCCESS, u, "已登录");
            }else {
                //游客菜单
                Role role = roleService.findByName("游客");
                List<RolePermission> rp = permissionService.findByRoleId(role.getId());
                List<Permission> permissionList = new ArrayList<>();
                rp.forEach(rps->{
                    permissionList.add(permissionService.findById(rps.getPermissionId()));
                });
                u.setPermissionList(permissionList);
                return getModelMap(StateParameter.FAULT, u, "未登录");
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

    /**
     * @auther: 朱利尔
     * @date: 17:47 2021/4/30
     * @param: [request]
     * @return: java.lang.String
     * @Description: 查询用户列表
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap list(@RequestBody UserRequestPageDTO request){
        UserResponsePageDTO resList = new UserResponsePageDTO();
        Page<User> userPage = userService.findAllByPage(request);
        if(userPage.getTotalElements()>0){
            userPage.getContent().forEach(s->{
                s.setPassword("********");
            });
        }
        resList.setRecordsTotal(userPage.getTotalElements());
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(userPage.getTotalElements())));
        resList.setUserList(userPage.getContent());
        resList.setTotalPages(userPage.getTotalPages());
        log.info("返回用户列表");
        return getModelMap(StateParameter.SUCCESS, resList, "获取用户列表成功");
    }

    /**
     * @Author: zhangyingqi
     * @Date: 14:14 2021/5/5
     * @Param: [user]
     * @Return: org.springframework.ui.ModelMap
     * @Description: 修改用户状态【启用/禁用】
     */
    @RequestMapping(value="/updateUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap updateUser(@RequestBody User user){
        if(StringUtils.isEmpty(user.getId())){
            return getModelMap(StateParameter.FAULT, null, "参数校验失败userId is empty");
        }
        User u = userService.findById(user.getId());
        if("1".equals(u.getStatus())){
            u.setStatus("0");
        }else{
            u.setStatus("1");
        }
        u.setUpdateDate(new Date());
        userService.save(u);
        return getModelMap(StateParameter.SUCCESS, u, "用户状态修改成功");
    }

}
