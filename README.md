# SnowflakeAdaptor
Use Case:
  1) Scheduler will pull the cost and credit usage from Snowflake instance on every miniutes and will store in the local storage in JSON format
  2) Rest API will will pull cost and credit usage from Snowflake instance and will give output in JSON format
# System Requirement JAVA 11
# Run from terminal
Download the Jar from the Jar folder from this Repo
Execute in terminal -> java -jar SnowflakeAdaptor-0.0.1-SNAPSHOT.jar
# Verify output
1) Find the USAGE_FILE_LOCAL_STORAGE_LOCATION from the log and check cost_<number>.json for cost and credit usage from that location
2) Get cost and credit usage via API call from browser or postman - http://localhost:8080/dcsg/cloud/economics/snowflake/spot/usage, asumption App running on localhost
