package com.spring.boot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.constant.Enums;
import com.spring.boot.utils.Result;
import com.spring.boot.utils.ResultUtil;

/**
 * 自定义异常处理类
 * @author wang_donggang
 */
@ControllerAdvice
public class ExceptionHandler {
	
	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	@ResponseBody
	public <T> Result<T> handler(Exception e) {
		if (e instanceof WebException) {
			WebException ce = (WebException) e;
			logger.error("【程序异常】--> {}", e);
			return ResultUtil.error(ce.getCode(), ce.getMessage());
		} else {
			logger.error("【系统异常】--> {}", e);
			return ResultUtil.error(Enums.UNKNOW_ERROR.getCode(), Enums.UNKNOW_ERROR.getMsg());
		}
	}
}
