package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.entity.Area;
import com.spring.boot.service.AreaService;
import com.spring.boot.utils.Result;
import com.spring.boot.utils.ResultUtil;

@RestController
@RequestMapping("/app/v1/")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@GetMapping("area")
	public Result<List<Area>> list() {
		return ResultUtil.success(areaService.queryArea());
	}
	
}
