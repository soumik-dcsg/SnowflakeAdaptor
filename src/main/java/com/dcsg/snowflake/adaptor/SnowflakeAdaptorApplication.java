package com.dcsg.snowflake.adaptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.dcsg.snowflake.adaptor"})
public class SnowflakeAdaptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnowflakeAdaptorApplication.class, args);
		System.out.println();
	}

}
