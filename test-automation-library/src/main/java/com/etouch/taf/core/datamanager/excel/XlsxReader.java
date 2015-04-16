/*
 * 
 */
package com.etouch.taf.core.datamanager.excel;

import org.apache.commons.logging.Log;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import com.etouch.taf.util.LogUtil;

import java.io.*;
import java.util.Calendar;
import java.util.Iterator;


// TODO: Auto-generated Javadoc
/**
 * The Class Xlsx_Reader.
 */
public class XlsxReader extends ExcelReader{
	
	/** The log. */
	private static Log log = LogUtil.getLog(XlsxReader.class);
	
	/** The path. */
	public  String path;
	
	/** The fis. */
	public  FileInputStream fis = null;
	
	/** The file out. */
	public  FileOutputStream fileOut =null;
	
	/** The workbook. */
	private XSSFWorkbook workbook = null;
	
	/** The sheet. */
	private XSSFSheet sheet = null;
	
	/** The row. */
	private XSSFRow row   =null;
	
	/** The cell. */
	private XSSFCell cell = null;
	
	//private Row row = null;
	//private Cell cell = null;
	
	/**
	 * Instantiates a new xlsx_ reader.
	 *
	 * @param path the path
	 */
	public XlsxReader(String path) {
		
		this.path=path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);			
			sheet = workbook.getSheetAt(0);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		} 
		finally
		{
			closeFileObjects(fis, fileOut);	
		}
		
	}
	
	/*
	 * This method reads the complete data and returns the String[][]from Excel files with .xlsx extension.
	 */
	
	/**
	 * Read xls data.
	 *
	 * @param sheetName the sheet name
	 * @return the string[][]
	 */
	public String[][] readXLSData(String sheetName)
			
	{
		String[][] data = readXLSData(workbook, sheetName);		
	    return data;     
	}
	
	// returns the row count in a sheet
	/**
	 * Gets the row count.
	 *
	 * @param sheetName the sheet name
	 * @return the row count
	 */
	public int getRowCount(String sheetName){
		int rowCount = getRowCount(workbook, sheetName);
		return rowCount;
		
	}
	
	// returns the data from a cell
	/* (non-Javadoc)
	 * @see com.etouch.taf.core.datamanager.excel.ExcelReader#getCellData(java.lang.String, java.lang.String, int)
	 */
	public String getCellData(String sheetName,String colName,int rowNum){
		String cellText = getCellData(workbook, sheetName, colName, rowNum);
		return cellText;
		
	}
	
	// returns the data from a cell
	/* (non-Javadoc)
	 * @see com.etouch.taf.core.datamanager.excel.ExcelReader#getCellData(java.lang.String, int, int)
	 */
	public String getCellData(String sheetName,int colNum,int rowNum){
		String cellText = getCellData(workbook, sheetName, colNum, rowNum);
		return cellText;
	}
	
	// returns true if data is set successfully else false
	/**
	 * Sets the cell data.
	 *
	 * @param sheetName the sheet name
	 * @param colName the col name
	 * @param rowNum the row num
	 * @param data the data
	 * @return true, if successful
	 */
	public boolean setCellData(String sheetName,String colName,int rowNum, String data){
		boolean isSet = false;
		try{
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);
			isSet = setCellData(path, workbook, sheetName, colName, rowNum, data);			
		}catch(Exception ex)
		{
			log.error(ex.getMessage());;
		}
		finally
		{
			closeFileObjects(fis, fileOut);	
		}
		return isSet;
	}
	
	
	// returns true if data is set successfully else false
	/* (non-Javadoc)
	 * @see com.etouch.taf.core.datamanager.excel.ExcelReader#setCellData(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String)
	 */
	public boolean setCellData(String sheetName,String colName,int rowNum, String data,String url){
		//System.out.println("setCellData setCellData******************");
		boolean isSet = false;
		try{
		fis = new FileInputStream(path); 
		workbook = new XSSFWorkbook(fis);		
		sheet = (XSSFSheet)getSheet(workbook, sheetName);
		
		if(sheet!=null)
		{
			int colNum = getColNumber(sheet, colName);
			
			if(rowNum<=0 || colNum<0)
				return false;		
			
			cell = (XSSFCell)setCellValue(sheet, rowNum, colNum, data);
		    setHyperlink(cell, url);	    
		      
		    fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
	
			isSet = true;
		}

		}
		catch(Exception e){
			log.error(e.getMessage());
			return false;
		}
		finally
		{
			closeFileObjects(fis, fileOut);	
		}
		return isSet;
	}	
	
	
	/**
	 * Sets the hyperlink.
	 *
	 * @param cell the cell
	 * @param url the url
	 */
	public void setHyperlink(XSSFCell cell, String url)
	{
		XSSFCreationHelper createHelper =(XSSFCreationHelper) workbook.getCreationHelper();

	    //cell style for hyperlinks
	    //by default hypelrinks are blue and underlined
	    CellStyle hlink_style = workbook.createCellStyle();
	    XSSFFont hlink_font = workbook.createFont();
	    hlink_font.setUnderline(XSSFFont.U_SINGLE);
	    hlink_font.setColor(IndexedColors.BLUE.getIndex());
	    hlink_style.setFont(hlink_font);
	    //hlink_style.setWrapText(true);

	    XSSFHyperlink link = createHelper.createHyperlink(XSSFHyperlink.LINK_FILE);
	    link.setAddress(url);
	    cell.setHyperlink(link);
	    cell.setCellStyle(hlink_style);
	    
	    //return cell;
	}
	
	
	
	// returns true if sheet is created successfully else false
	/**
	 * Adds the sheet.
	 *
	 * @param sheetName the sheet name
	 * @return true, if successful
	 */
	public boolean addSheet(String  sheetName){		
		boolean isSheetAdded = false;
		try{
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			isSheetAdded = addSheet(path, workbook, sheetName);			
		}catch(Exception ex)
		{
			log.error(ex.getMessage());			
		}
		finally{
			closeFileObjects(fis, fileOut);
		}
		
		return isSheetAdded;
	}
	
	// returns true if sheet is removed successfully else false if sheet does not exist
	/**
	 * Removes the sheet.
	 *
	 * @param sheetName the sheet name
	 * @return true, if successful
	 */
	public boolean removeSheet(String sheetName){	
		boolean isSheetRemoved = false;
		try{
			
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			isSheetRemoved = removeSheet(path, workbook, sheetName);			
		}catch(Exception ex)
		{
			log.error(ex.getMessage());			
		}
		finally
		{
			closeFileObjects(fis, fileOut);	
		}
		return isSheetRemoved;
	}
	// returns true if column is created successfully
	/* (non-Javadoc)
	 * @see com.etouch.taf.core.datamanager.excel.ExcelReader#addColumn(java.lang.String, java.lang.String)
	 */
	public boolean addColumn(String sheetName,String colName){
		//System.out.println("**************addColumn*********************");
		
		try{				
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return false;
			
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		sheet=workbook.getSheetAt(index);
		
		row = sheet.getRow(0);
		if (row == null)
			row = sheet.createRow(0);
		
		//cell = row.getCell();	
		//if (cell == null)
		//System.out.println(row.getLastCellNum());
		if(row.getLastCellNum() == -1)
			cell = row.createCell(0);
		else
			cell = row.createCell(row.getLastCellNum());
	        
	        cell.setCellValue(colName);
	        cell.setCellStyle(style);
	        
	        fileOut = new FileOutputStream(path);
			workbook.write(fileOut);				    

		}catch(Exception e){
			log.error(e.getMessage());
			return false;
		}
		finally
		{
			closeFileObjects(fis, fileOut);	
		}	
		
		return true;
		
		
	}
	// removes a column and all the contents
	/* (non-Javadoc)
	 * @see com.etouch.taf.core.datamanager.excel.ExcelReader#removeColumn(java.lang.String, int)
	 */
	public boolean removeColumn(String sheetName, int colNum) {
		try{
		if(!isSheetExist(sheetName))
			return false;
		fis = new FileInputStream(path); 
		workbook = new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		XSSFCreationHelper createHelper = workbook.getCreationHelper();
		style.setFillPattern(HSSFCellStyle.NO_FILL);
		
	    
	
		for(int i =0;i<getRowCount(sheetName);i++){
			row=sheet.getRow(i);	
			if(row!=null){
				cell=row.getCell(colNum);
				if(cell!=null){
					cell.setCellStyle(style);
					row.removeCell(cell);
				}
			}
		}
		fileOut = new FileOutputStream(path);
		workbook.write(fileOut);		    
		}
		catch(Exception e){
			log.error(e.getMessage());
			return false;
		}
		finally
		{
			closeFileObjects(fis, fileOut);	
		}
		return true;
		
	}
  // find whether sheets exists	
	/**
   * Checks if is sheet exist.
   *
   * @param sheetName the sheet name
   * @return true, if is sheet exist
   */
  public boolean isSheetExist(String sheetName){
		boolean isSheetExists = isSheetExist(workbook, sheetName);
		return isSheetExists;
	}
	
	// returns number of columns in a sheet	
	/**
	 * Gets the column count.
	 *
	 * @param sheetName the sheet name
	 * @return the column count
	 */
	public int getColumnCount(String sheetName){
		int colCount = getColumnCount(workbook, sheetName);
		return colCount;
		
		
		
	}
	//String sheetName, String testCaseName,String keyword ,String URL,String message
	/* (non-Javadoc)
	 * @see com.etouch.taf.core.datamanager.excel.ExcelReader#addHyperLink(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String)
	 */
	public boolean addHyperLink(String sheetName,String screenShotColName,String testCaseName,int index,String url,String message){
		//System.out.println("ADDING addHyperLink******************");
		
		url=url.replace('\\', '/');
		if(!isSheetExist(sheetName))
			 return false;
		
	    sheet = workbook.getSheet(sheetName);
	    
	    for(int i=2;i<=getRowCount(sheetName);i++){
	    	if(getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)){
	    		//System.out.println("**caught "+(i+index));
	    		setCellData(sheetName, screenShotColName, i+index, message,url);
	    		break;
	    	}
	    }
	    
		return true; 
	}
	
	/* (non-Javadoc)
	 * @see com.etouch.taf.core.datamanager.excel.ExcelReader#getCellRowNum(java.lang.String, java.lang.String, java.lang.String)
	 */
	public int getCellRowNum(String sheetName,String colName,String cellValue){
		
		for(int i=2;i<=getRowCount(sheetName);i++){
	    	if(getCellData(sheetName,colName , i).equalsIgnoreCase(cellValue)){
	    		return i;
	    	}
	    }
		return -1;
		
	}
		
	// to run this on stand alone
	/**
	 * The main method.
	 *
	 * @param arg the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String arg[]) throws IOException{
		
		  /* Xlsx_Reader datatable = new Xlsx_Reader("C:\\Lavanya\\Project\\eTouch\\eTap_framework\\staff.xlsx");
		   
		   System.out.println("Is Sheet exists: " + datatable.isSheetExist("E1"));
		   System.out.println("Row Count: " + datatable.getRowCount("E1"));
		   System.out.println("Column Count: " + datatable.getColumnCount("E1"));
		   System.out.println("Cell Row Number is: " + datatable.getCellRowNum("E1", "Name", "Lavanya"));
		   System.out.println("Is Sheet Added? " + datatable.addSheet("E2"));
		   System.out.println("Is Sheet added? " + datatable.addSheet("E3"));		   
			
		   System.out.println("Is column added? " + datatable.addColumn("E1", "Mail"));
		   System.out.println("Is column added? " + datatable.addColumn("E1", "Phone"));
		   System.out.println("Is data set? " + datatable.setCellData("E1", "Salary", 2, "5000"));
		   System.out.println("Is data set? " + datatable.setCellData("E1", "Age", 3, "30", "C:/Lavanya/Project/eTouch/eTap_framework/emp1.xls"));
		   String cellText = datatable.getCellData("E1", 2, 2);
		   System.out.println("cellData1 is: "  + cellText);
			
		   cellText = datatable.getCellData("E1", "Name", 3);
		   System.out.println("cellData2 is: " + cellText);
		   
		   String[][] data = datatable.readXLSData("E1");
		   if(data!=null)
		   for(int i=0;i<data.length;i++)
		   {
				for(int j=0;j<data[0].length;j++)
				{
					System.out.print(data[i][j]+"\t\t");
				}
				
				System.out.println("");
		   }
			
		   datatable.removeSheet("E2");
			
		   datatable.removeColumn("E1", 4);	*/		
			
	}
	
	
}
