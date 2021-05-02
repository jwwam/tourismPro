package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.controller.BaseController;
import com.feelcode.tourism.base.utils.StateParameter;
import com.feelcode.tourism.entity.*;
import com.feelcode.tourism.service.CommentService;
import com.feelcode.tourism.service.HotelService;
import com.feelcode.tourism.service.ScoreService;
import com.feelcode.tourism.service.UserService;
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
import java.util.List;

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
    @Resource
    UserService userService;
    @Resource
    ScoreService scoreService;

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
        if(StringUtils.isEmpty(comment.getUserId())){
            return getModelMap(StateParameter.FAULT, null, "评论提交失败，请登录！");
        }
        try {
            if(StringUtils.isEmpty(comment.getId())){
                comment.setId(getUuid());
            }else{
                comment.setUpdateDate(new Date());
            }
            User user = userService.findById(comment.getUserId());
            comment.setUserName(user.getUserName());
            comment.setCommentTime(new Date());
            commentService.save(comment);
            log.info("评论保存成功");
            if(!StringUtils.isEmpty(comment.getScore())){
                Score score = new Score();
                Score olScore = scoreService.findByUserIdAndProductId(comment.getUserId(),comment.getProductId());
                if(olScore==null){
                    score.setId(getUuid());
                }else{
                    score.setId(olScore.getId());
                    score.setUpdateDate(new Date());
                }
                score.setGrade(String.valueOf(comment.getScore()));
                score.setProductId(comment.getProductId());
                score.setProductType(comment.getProductType());
                score.setUserId(user.getId());
                scoreService.save(score);
                log.info("评分保存成功");
            }
            return getModelMap(StateParameter.SUCCESS, null, "评论提交成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "评论提交失败");
        }
    }

    /**
     * @auther: 朱利尔
     * @Description: 评论列表
     * @date: 22:23 2020/5/7
     * @param: [request]
     * @return: org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelMap list(@RequestBody CommentRequestPageDTO request){
        CommentResponsePageDTO resList = new CommentResponsePageDTO();
        Long count = commentService.findAllByCount();
        Sort sort = new Sort(Sort.Direction.DESC,"commentTime");
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort);
        List<Comment> commentList = commentService.findByProductId(request.getProductId());
        resList.setRecordsTotal(count);
        resList.setRecordsFiltered(Integer.parseInt(String.valueOf(count)));
        resList.setCommentList(commentList);
        log.info("返回评论列表：{}", resList);
        return getModelMap(StateParameter.SUCCESS, resList, "获取评论列表成功");
    }

}
