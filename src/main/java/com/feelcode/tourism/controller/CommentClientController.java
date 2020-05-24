package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.Comment;
import com.feelcode.tourism.entity.Hotel;
import com.feelcode.tourism.service.CommentService;
import com.feelcode.tourism.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 18:38 2020/5/24
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/c/comment")
@Slf4j
public class CommentClientController extends BaseController {

    @Resource
    CommentService commentService;

    /**
     * @auther: 朱利尔
     * @Description: 评论保存&更新
     * @date: 22:21 2020/5/7
     * @param: [hotel]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/addComment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap addComment(@RequestBody Comment comment){
        try {
            if(StringUtils.isEmpty(comment.getId())){
                comment.setId(getUuid());
            }else{
                comment.setUpdateDate(new Date());
            }
            commentService.save(comment);
            log.info("保存成功");
            return getModelMap(StateParameter.SUCCESS, null, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "保存失败");
        }
    }

}
