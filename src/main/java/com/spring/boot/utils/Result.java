package com.spring.boot.utils;

import com.spring.boot.constant.Enums;

/**
 * 返回值包装类
 * @author wang_donggang
 * @param <T>
 */
public class Result<T> {
	// 状态码
	private int code;
	// 状态信息
	private String msg;
	// 返回值
	private T data;
	public Result() {
	}
	public Result(Enums resultEnum) {
		this.code = resultEnum.getCode();
		this.msg = resultEnum.getMsg();
	}
	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Result(Enums resultEnum, T data) {
		this.code = resultEnum.getCode();
		this.msg = resultEnum.getMsg();
		this.data = data;
	}
	public Result(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
