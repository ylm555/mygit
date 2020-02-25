package com.icss.ssm.util;

import org.apache.log4j.Logger;


public class Log {

private static Logger logger =Logger.getLogger(Log.class.getName());
	
//	public void error(String message){
//		logger.error(message);
//	}
	
	public static void info(String message){
		logger.info(message);
	}
}
