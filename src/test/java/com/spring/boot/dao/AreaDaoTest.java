package com.spring.boot.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.entity.Area;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
	
	@Autowired
	private AreaDao areaDao;

	@Test
	public void testQueryArea() {
		List<Area> list = areaDao.queryArea();
		for (Area area : list) {
			System.out.println(area.getAreaName());
		}
	}

	@Test
	public void testQueryAreaById() {
		Area area = areaDao.queryAreaById(1);
		System.out.println(area.getAreaName());
	}
	
	@Test
	public void testInsertArea() {
		Area area = new Area();
		area.setAreaName("DDD");
		area.setCreateTime(new Date());
		int i = areaDao.insertArea(area);
		System.out.println(i);
	}
	
	@Test
	public void testUpdateArea() {
		Area area = new Area();
		area.setAreaId(5);
		area.setLastEditTime(new Date());
		int i = areaDao.updateArea(area);
		System.out.println(i);
	}
	
	@Test
	public void testDeleteArea() {
		int i = areaDao.deleteArea(4);
		System.out.println(i);
	}
	
}
