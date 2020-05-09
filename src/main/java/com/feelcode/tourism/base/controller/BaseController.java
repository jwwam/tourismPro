package com.feelcode.tourism.base.controller;

import com.feelcode.tourism.base.utils.StateParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import java.util.UUID;

public abstract class BaseController{

	protected final String success = StateParameter.SUCCESS;
	protected final String  fail = StateParameter.FAULT;

	public ModelMap getModelMap(String status,Object data,String msg){
		ModelMap modelMap=new ModelMap();
		modelMap.put("status", status);
		modelMap.put("data", data);
		modelMap.put("msg", msg);
		return modelMap;
		
	}

	public String getUuid(){
		String uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象
		uuid = uuid.replace("-", "");
		return uuid;
	}

}
