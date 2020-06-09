package com.feelcode.tourism.entity;

import com.feelcode.tourism.entity.vo.OrderDateCountVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 16:40 2020/6/5
 * @Modified By:
 */
@Data
public class IndexResponseDTO {
    /**
     * 所有订单
     */
    private List<Order> orderList;
    private BigDecimal hotelPercent;
    private BigDecimal planePercent;
    private BigDecimal linePercent;
    private BigDecimal otherPercent;
    /**
     * 今日订单数
     */
    private  Long todayOrder=0L;
    /**
     * 订单总数
     */
    private  Long totalOrder=0L;
    /**
     * 订单审核中量
     */
    private  Long totalSubmitOrder=0L;
    /**
     * 订单通过量
     */
    private  Long totalPassOrder=0L;
    /**
     * 订单拒绝量
     */
    private  Long totalRefuseOrder=0L;
    /**
     * 景点总数
     */
    private  Long totalSpots=0L;
    /**
     * 酒店总数
     */
    private  Long totalHotel=0L;
    /**
     * 旅线总数
     */
    private  Long totalLine=0L;
    /**
     * 旅团总数
     */
    private  Long totalGroup=0L;
    /**
     * 航班总数
     */
    private  Long totalPlane=0L;
    /**
     * 总留言条数
     */
    private  Long totalComment=0L;
    /**
     * 总用户注册量
     */
    private Long totalUser=0L;
    /**
     * 景点评分前十
     */
    private List<Spots> TopTenSpots;
    /**
     * 酒店评分前十
     */
    private List<Hotel> TopTenHotel;
    /**
     * 留言前十
     */
    private List<Comment> TopTenCommentUser;

    /**
     * 所有订单-日期数组
     */
    private List<OrderDateCountVO> dateOrder;
    /**
     * 酒店订单-日期数组
     */
    private List<OrderDateCountVO> hotelDateOrder;
    /**
     * 机票订单-日期数组
     */
    private List<OrderDateCountVO> planeDateOrder;
    /**
     * 评论列表
     */
    List<Comment> commentList;

}
