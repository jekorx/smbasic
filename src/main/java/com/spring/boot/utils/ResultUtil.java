package com.spring.boot.utils;

import com.spring.boot.constant.Enums;

/**
 * 返回值包装工具类
 * @author wang_donggang
 */
public class ResultUtil {
	/**
	 * 请求成功
	 * @param object
	 * @return
	 */
	public static <T> Result<T> success() {
		return new Result<T>(Enums.SUCCESS);
	}
	/**
	 * 请求成功
	 * @param object
	 * @return
	 */
	public static <T> Result<T> success(T object) {
		return new Result<T>(Enums.SUCCESS, object);
	}
	/**
	 * 请求失败
	 * @param code
	 * @param msg
	 * @return
	 */
	public static <T> Result<T> error(int code, String msg) {
		return new Result<T>(code, msg);
	}
	/**
	 * 请求失败
	 * @return
	 */
	public static <T> Result<T> error() {
		return new Result<T>(Enums.FAILED);
	}
	/**
	 * 请求失败
	 * @param resultEnum
	 * @return
	 */
	public static <T> Result<T> error(Enums resultEnum) {
		return new Result<T>(resultEnum);
	}
	/**
	 * 请求失败
	 * @param msg
	 * @return
	 */
	public static <T> Result<T> error(String msg) {
		return new Result<T>(Enums.FAILED.getCode(), msg);
	}
}
