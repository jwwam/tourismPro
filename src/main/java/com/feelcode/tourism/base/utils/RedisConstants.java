package com.feelcode.tourism.base.utils;

/**
 * @auther: zhangyingqi
 * @date: 17:50 2018/8/28
 * @Description: 此类用于区分redis的库
 */
public class RedisConstants {
	
	public static final String spilt=":";

	/**
	 * redis库1  保存档案树
	 */
	public static final Integer datebase1=1;

	/**
	 * 1.redis库2 保存档案表格
	 */
	public static final Integer datebase2=2;

	/**
	 * redis库3 保存档案image url
	 */
	public static final Integer datebase3=3;

	/**
	 * 1.redis库4 保存手机验证码
	 *
	 */
	public static final Integer datebase4=4;

	/**
	 * redis库5 保存身份认证信息
	 */
	public static final Integer datebase5=5;

	/**
	 * redis库6 记录身份认证次数
	 */
	public static final Integer datebase6=6;

	/**
	 * redis库7 记录重发次数
	 */
	public static final Integer datebase7=7;

	/**
	 * redis库8 记录任务参数
	 */
	public static final Integer datebase8=8;

	
	public RedisConstants() {

	}
}
