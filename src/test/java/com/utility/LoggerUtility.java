package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Singleton Design Pattern  only one object i.e y private for constructor
public class LoggerUtility {

	//private static Logger logger;

	private LoggerUtility() {

	}

	public static Logger getLogger(Class<?> clazz) {
		
         Logger logger=null;     //this will hwlp to print resp call and method name for logger
		if (logger == null) {
			logger = LogManager.getLogger(clazz);
		}
		return logger;
	}

}
