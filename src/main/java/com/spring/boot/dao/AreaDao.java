package com.spring.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.boot.entity.Area;

@Mapper
public interface AreaDao {
	
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
	int insertArea(Area area);

	/**
	 * 更新
	 * @param area
	 * @return
	 */
	int updateArea(Area area);
	
	/**
	 * 根据id删除
	 * @param areaId
	 * @return
	 */
	int deleteArea(int areaId);
	
}
