package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "LoginTestJSONDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {

		Gson gson = new Gson();
		File jsonTestDatafile = new File(System.getProperty("user.dir") + "\\TestData\\loginData.json");
		FileReader fileReader = new FileReader(jsonTestDatafile);
		TestData data = gson.fromJson(fileReader, TestData.class);

		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for (User user : data.getData()) {

			dataToReturn.add(new Object[] { user });
		}
		return dataToReturn.iterator();
	}
	
	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() throws CsvValidationException, IOException {
		return CSVReaderUtility.readCSVFile("loginData.csv");
	}
	
	@DataProvider(name = "LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() throws CsvValidationException, IOException {
		return ExcelReaderUtility.readExcelFIle("loginData.xlsx");
	}

}
