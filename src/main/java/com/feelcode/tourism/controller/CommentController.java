package com.feelcode.tourism.controller;

import com.feelcode.tourism.base.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 18:38 2020/5/24
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/s/comment")
@Slf4j
public class CommentController extends BaseController {

}
