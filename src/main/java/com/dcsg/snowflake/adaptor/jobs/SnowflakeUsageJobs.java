package com.dcsg.snowflake.adaptor.jobs;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.dcsg.snowflake.adaptor.service.SnowflakeUsgaeService;
import com.dcsg.snowflake.adaptor.service.impl.SnowflakeUsgaeServiceImpl;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
public class SnowflakeUsageJobs {

	Logger logger = LoggerFactory.getLogger(SnowflakeUsgaeServiceImpl.class);

	@Autowired
	private SnowflakeUsgaeService snowflakeUsgaeService;

	@Async
	@Scheduled(cron = "59 * * * * *")
	public void scheduler() {
		try {
			logger.info("Cost Service Job Started");
			snowflakeUsgaeService.fileUpload();
			logger.info("Cost Service Job End");
		} catch (IOException e) {
			logger.error("File Upload Job Failed with error-" + e.getMessage());
		}
	}

}
