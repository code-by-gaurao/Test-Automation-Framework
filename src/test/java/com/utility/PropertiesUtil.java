package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String readProperty(Env env, String propertyName) {

		File propfile = new File(System.getProperty("user.dir") + "//config//" + env + ".properties");

		FileReader fileReader = null;
		try {
			fileReader = new FileReader(propfile);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Properties properties = new Properties();
		try {
			properties.load(fileReader);
		} catch (IOException e) {

			e.printStackTrace();
		}
		String value = properties.getProperty(propertyName);
		return value;
	}

}

/*
 * public static String readProperty(){
 * 
 * File propfile= new
 * File(System.getProperty("user.dir")+"\\config\\QA.properties"); FileReader
 * fileReader=new FileReader(propfile); Properties properties=new Properties();
 * properties.load(fileReader); String value=properties.getProperty("URL");
 * syso(value)
 */
