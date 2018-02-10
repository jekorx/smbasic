package com.spring.boot.service;

import java.util.List;

import com.spring.boot.entity.Area;

public interface AreaService {
	
	/**
	 * 查询列表
	 * @return
	 */
	List<Area> queryArea();
	
	/**
	 * 根据id查询
	 * @param areaId
	 * @return
	 */
	Area queryAreaById(int areaId);
	
	/**
	 * 插入
	 * @param area
	 * @return
	 */
	boolean addArea(Area area);

	/**
	 * 更新
	 * @param area
	 * @return
	 */
	boolean modfiyArea(Area area);
	
	/**
	 * 根据id删除
	 * @param areaId
	 * @return
	 */
	boolean deleteArea(int areaId);
	
}
