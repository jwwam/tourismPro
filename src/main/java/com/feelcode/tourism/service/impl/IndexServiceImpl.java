package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.base.constant.SystemConstant;
import com.feelcode.tourism.dao.*;
import com.feelcode.tourism.entity.*;
import com.feelcode.tourism.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 16:41 2020/6/5
 * @Modified By:
 */
@Service(value = "indexService")
public class IndexServiceImpl implements IndexService {
    @Resource
    CommentDao commentDao;
    @Resource
    GroupDao groupDao;
    @Resource
    HotelDao hotelDao;
    @Resource
    LineDao lineDao;
    @Resource
    PlaneDao planeDao;
    @Resource
    ScoreDao scoreDao;
    @Resource
    SpotsDao spotsDao;
    @Resource
    UserDao userDao;
    @Resource
    OrderDao orderDao;

    @Override
    public IndexResponseDTO getIndexData(IndexRequestDTO request) {
        Long todayOrder = orderDao.count();
        Long totalOrder = orderDao.count();
        Long totalSubmitOrder = orderDao.countByOrOrderStatus(SystemConstant.OrderStatus.submit);
        Long totalPassOrder = orderDao.countByOrOrderStatus(SystemConstant.OrderStatus.pass);
        Long totalRefuseOrder = orderDao.countByOrOrderStatus(SystemConstant.OrderStatus.refuse);
        Long totalSpots = spotsDao.count();
        Long totalHotel = hotelDao.count();
        Long totalLine = lineDao.count();
        Long totalGroup = groupDao.count();
        Long totalPlane = planeDao.count();
        Long totalComment = commentDao.count();
        Long totalUser = userDao.count();
        List<Spots> topTenSpots = null;//spotsDao.findTopTenSpots();
        List<Hotel> topTenHotel = null;//orderDao.count();
        List<Comment> topTenCommentUser = null;//orderDao.count();

        IndexResponseDTO indexResponseDTO = new IndexResponseDTO();
        indexResponseDTO.setTodayOrder(todayOrder);
        indexResponseDTO.setTotalOrder(totalOrder);
        indexResponseDTO.setTotalSubmitOrder(totalSubmitOrder);
        indexResponseDTO.setTotalPassOrder(totalPassOrder);
        indexResponseDTO.setTotalRefuseOrder(totalRefuseOrder);
        indexResponseDTO.setTotalSpots(totalSpots);
        indexResponseDTO.setTotalHotel(totalHotel);
        indexResponseDTO.setTotalLine(totalLine);
        indexResponseDTO.setTotalGroup(totalGroup);
        indexResponseDTO.setTotalPlane(totalPlane);
        indexResponseDTO.setTotalComment(totalComment);
        indexResponseDTO.setTotalUser(totalUser);
        indexResponseDTO.setTopTenSpots(topTenSpots);
        indexResponseDTO.setTopTenHotel(topTenHotel);
        indexResponseDTO.setTopTenCommentUser(topTenCommentUser);
        return indexResponseDTO;
    }

}
