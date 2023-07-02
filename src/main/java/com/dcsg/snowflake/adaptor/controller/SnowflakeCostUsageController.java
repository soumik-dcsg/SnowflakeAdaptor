package com.dcsg.snowflake.adaptor.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcsg.snowflake.adaptor.service.SnowflakeUsgaeService;

@RestController
@RequestMapping("${dcsg.cloud.economics.api.endpoint}")
public class SnowflakeCostUsageController {
	
	@Autowired
	private SnowflakeUsgaeService snowflakeUsgaeService;
	
	@GetMapping("/snowflake/spot/usage")
	public ResponseEntity<List<Map<String, Object>>> getSnowflakeUsage() {
		try {
			return ResponseEntity.ok(snowflakeUsgaeService.getUsage());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
