package com.MVN.Hackathon_Team6;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel_Xpath 
{
	
	public String[] readFromExcel() throws Exception
	{

		  File src=new File(System.getProperty("user.dir")+"//Excel//Bike_ReadData.xlsx");
		 
		  
		   FileInputStream fis=new FileInputStream(src);
		 
		   
		   XSSFWorkbook wb=new XSSFWorkbook(fis);
		   
		  
		      XSSFSheet sh1= wb.getSheetAt(0);
		      
		      int rowCount=sh1.getLastRowNum();
		      
		    String str[]=new String[12];
		 
		    
		    int k=0;
		  for(int i=1;i<(rowCount+1);i++)
		  {
		      Row row=sh1.getRow(i);
		     for(int j=1;j<row.getLastCellNum();j++)
		     {
		    	// Cell cell =row.getCell(j);
		    	 
		    		 str[k]=row.getCell(j).getStringCellValue();
		    	 
		    		 k++;
		     }
		   //  System.out.println();
		}
		  
		  return str;
	}
	

}
