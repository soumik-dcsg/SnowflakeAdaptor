package com.dcsg.snowflake.adaptor.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SnowflakeUsgaeService {

	public List<Map<String, Object>> getUsage();
	public void fileUpload () throws IOException;

}
