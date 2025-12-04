package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	FileInputStream fis;
	Workbook wb;
	Sheet ss;
	Row rr;
	Cell cc;
	String ExcelPath;
	ExcelUtility(String Excelpath){
		this.ExcelPath=Excelpath;
	}
	
public String getDataFromExcel(String sheetname,int rownum,int cellnumber) throws EncryptedDocumentException, IOException {
	fis=new FileInputStream(ExcelPath);
	wb=WorkbookFactory.create(fis);
	ss=wb.getSheet(sheetname);
	rr=ss.getRow(rownum);
	 cc=rr.getCell(cellnumber);
	String data= cc.getStringCellValue().toString();
	fis.close();
	wb.close();
	return data;
}

public int getRowFromExcel(String sheetname) throws EncryptedDocumentException, IOException {
	fis=new FileInputStream(ExcelPath);
	wb=WorkbookFactory.create(fis);
	ss=wb.getSheet(sheetname);
	int rows= ss.getPhysicalNumberOfRows();
	fis.close();
	wb.close();
	return rows;
}


public int getcellFromExcel(String sheetname,int rownum) throws EncryptedDocumentException, IOException {
	fis=new FileInputStream(ExcelPath);
	wb=WorkbookFactory.create(fis);
	ss=wb.getSheet(sheetname);
	int cells=ss.getRow(rownum).getPhysicalNumberOfCells();
	fis.close();
	wb.close();
	return cells;
}

public void setDataFromExcel(String sheetname,int rownum,int cellnumber,String value) throws EncryptedDocumentException, IOException {
	fis=new FileInputStream(ExcelPath);
	wb=WorkbookFactory.create(fis);
	ss=wb.getSheet(sheetname);
	if(ss.getRow(rownum)==null)
		rr=ss.createRow(rownum);
	if(rr.getCell(cellnumber)==null)
		cc=rr.createCell(cellnumber);
	cc.setCellValue(value);
	FileOutputStream fos=new FileOutputStream(ExcelPath);
	wb.write(fos);
	fis.close();

}
}
