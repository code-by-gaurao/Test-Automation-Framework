package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) throws CsvValidationException, IOException {

		File csvfile = new File(System.getProperty("user.dir") + "\\TestData\\"+fileName);
		FileReader fileReader = new FileReader(csvfile);
		String[] data;
		CSVReader csvReader = new CSVReader(fileReader);
		
		csvReader.readNext(); //reading the col Names 1 just reading not storing for skipping 1st heading column
	
		//	csvReader.readNext(); //ROw 2
		//String[] data = csvReader.readNext(); //Row
		
		
		List<User> userList=new ArrayList<User>();
		while((data= csvReader.readNext())!=null) {
			User user=new User(data[0],data[1]);
			userList.add(user);
		}
		
		
		for(User userData:userList) {
			System.out.println(userData);
		}
		return userList.iterator();
	}
	
}
