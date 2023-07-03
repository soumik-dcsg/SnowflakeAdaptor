package com.dcsg.snowflake.adaptor.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dcsg.snowflake.adaptor.service.SnowflakeUsgaeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class SnowflakeUsgaeServiceImpl implements SnowflakeUsgaeService {

	Logger logger = LoggerFactory.getLogger(SnowflakeUsgaeServiceImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Value("${snowflake.usage.sql}")
	private String usageSql;

	public List<Map<String, Object>> getUsage() {

		logger.info(usageSql);

		return jdbcTemplate.queryForList(usageSql);
	}

	public void fileUpload() throws IOException {

		String fileName = "cost_" + new Date().getTime() + ".json";
		String filePath = System.getProperty("java.io.tmpdir") + "/" + fileName;
		logger.info("USAGE_FILE_LOCAL_STORAGE_LOCATION="+filePath);
		File usgae = new File(filePath);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		String arrayToJson = objectMapper.writeValueAsString(getUsage());

		FileOutputStream fileOutputStream = new FileOutputStream(usgae);

		PrintWriter out = new PrintWriter(fileOutputStream);
		out.println(arrayToJson);
		out.close();
		fileOutputStream.close();

	}

}
