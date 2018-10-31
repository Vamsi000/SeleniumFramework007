package com.crm.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Vamsi
 *
 */
public class FileLib 

{
	public static String getExcelData(String sheetName,int rowNum,int cellNum) throws FileNotFoundException
	{
	try {
	FileInputStream fis=new FileInputStream("./testData/Validations.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	return data;
		}
	catch(Exception rv)
	{
		return "invaliddata";
	}
	}

	public static Properties getPropertyFileObject() throws Throwable
	{
		FileInputStream fobj=new FileInputStream("./testData/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fobj);
		
		return pobj;
		
	}

}