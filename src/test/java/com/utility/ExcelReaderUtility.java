package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFIle(String filename) {

		List<User> userList = new ArrayList<User>();
		File xlsxfile = new File(System.getProperty("user.dir") + "//TestData//" + filename);

		XSSFWorkbook xssfWorkbook = null;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user;
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxfile);
			xssfSheet = xssfWorkbook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next(); // to skip col name

			while (rowIterator.hasNext()) {

				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);

				user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
				xssfWorkbook.close();
			}
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return userList.iterator();
	}
}

/*
 * List<User> userList = new ArrayList<User>(); 
 * File xlsxfile = new File(System.getProperty("user.dir") + "//TestData//loginData.xlsx");
 * 
 * XSSFWorkbook xssfWorkbook = new XSSFWorkbook(xlsxfile);
 * 
 * XSSFSheet xssfSheet = xssfWorkbook.getSheet("LoginTestData"); 
 * Iterator<Row> rowIterator = xssfSheet.iterator(); 
 * rowIterator.next(); // to skip col name
 * 
 * while (rowIterator.hasNext()) {
 * 
 * Row row = rowIterator.next(); 
 * Cell firstCell = row.getCell(0); 
 * Cell secondCell = row.getCell(1);
 * 
 * syso(firstCell.toString(),secondCell.toString());

 * 
 * }
 * 
 * }
 * 
 * 
 */
