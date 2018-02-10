package com.spring.boot.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.dao.AreaDao;
import com.spring.boot.entity.Area;
import com.spring.boot.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	
	// 注入dao
	@Autowired
	private AreaDao areaDao;
	
	@Override
	public List<Area> queryArea() {
		return areaDao.queryArea();
	}

	@Override
	public Area queryAreaById(int areaId) {
		return areaDao.queryAreaById(areaId);
	}

	@Override
	@Transactional
	public boolean addArea(Area area) {
		if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
			Date date = new Date();
			area.setCreateTime(date);
			area.setLastEditTime(date);
		}
		return areaDao.insertArea(area) == 1;
	}

	@Override
	@Transactional
	public boolean modfiyArea(Area area) {
		return areaDao.updateArea(area) == 1;
	}

	@Override
	@Transactional
	public boolean deleteArea(int areaId) {
		return areaDao.deleteArea(areaId) == 1;
	}

}
