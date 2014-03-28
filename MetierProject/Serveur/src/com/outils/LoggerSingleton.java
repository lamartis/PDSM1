package com.outils;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class LoggerSingleton {
	
	private static LoggerSingleton instance;
	public static final Logger logger = Logger.getLogger(new Throwable().getStackTrace()[1].getClassName());

	public static synchronized LoggerSingleton getInstance() {
        if (instance == null) {
            throw new IllegalStateException("not initialized");
        }
        return instance;
    }
    public static synchronized void initialize(String logLocation) {
        if (instance == null)
        	instance = new LoggerSingleton(logLocation);
    }
    
	public LoggerSingleton(String location){
		try {
			logger.addHandler(new FileHandler(location));
		} catch (Exception e) {}
	}

	public void addInfoLog(String message){
		logger.info(message);
	}
	
	public void addWarningLog(String message){
		logger.warning(message);
	}
}
