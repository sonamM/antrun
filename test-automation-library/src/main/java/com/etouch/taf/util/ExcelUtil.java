/*
 * 
 */
package com.etouch.taf.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.etouch.taf.core.datamanager.excel.TestParameters;

// TODO: Auto-generated Javadoc
/**
 * This class contains utility methods for reading excel data.
 *
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public class ExcelUtil {

	/** The log. */
	private static Log log = LogUtil.getLog(ExcelUtil.class);

	/**
	 * CommonMethod(readExcelData) which reads the data from the excel sheet.
	 *
	 * @param filePath the file path
	 * @param sheetName the sheet name
	 * @param tableName the table name
	 * @return the string[][]
	 */
	
	/*
	 * This method reads the data from Excel files with .xls extension.
	 */
	
	public static String[][] readExcelData(String filePath, String sheetName,
			String tableName) {
		String[][] testData = null;

		try {
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
					filePath));
			HSSFSheet sheet = workbook.getSheet(sheetName);
			System.out.println("sheetName------------------" + sheetName);
			HSSFCell[] boundaryCells = findCell(sheet, tableName);
			System.out.println("tableName------------------" + tableName);
			HSSFCell startCell = boundaryCells[0];
			HSSFCell endCell = boundaryCells[1];
			int startRow = startCell.getRowIndex() + 1;
			int endRow = endCell.getRowIndex();
			int startCol = startCell.getColumnIndex() + 1;
			int endCol = endCell.getColumnIndex() - 1;
            testData = new String[endRow - startRow + 1][endCol - startCol + 1];

			for (int i = startRow; i < endRow + 1; i++) {
				for (int j = startCol; j < endCol + 1; j++) {
					if (null == sheet.getRow(i).getCell(j)
							|| sheet.getRow(i).getCell(j).getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						testData[i - startRow][j - startCol] = "";
					} else {

						if (sheet.getRow(i).getCell(j).getCellType() == HSSFCell.CELL_TYPE_STRING) {
							testData[i - startRow][j - startCol] = sheet
									.getRow(i).getCell(j).getStringCellValue();
						} else if (sheet.getRow(i).getCell(j).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							Double temp = sheet.getRow(i).getCell(j)
									.getNumericCellValue();
							testData[i - startRow][j - startCol] = String
									.valueOf(temp.intValue());
						}
					}

				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return testData;
	}
	
	/**
	 * CommonMethod(readExcelData) which reads the data from the excel sheet.
	 *
	 * @param filePath the file path
	 * @param sheetName the sheet name
	 * @param tableName the table name
	 * @return the test parameters[][]
	 */
	public static TestParameters[][] readExcelDataParams(String filePath, String sheetName,
			String tableName) {
		TestParameters[][] testData = null;
		int testParamColSize = 1;

		try {
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
					filePath));
			HSSFSheet sheet = workbook.getSheet(sheetName);
			System.out.println("sheetName------------------" + sheetName);
			HSSFCell[] boundaryCells = findCell(sheet, tableName);
			System.out.println("tableName------------------" + tableName);
			HSSFCell startCell = boundaryCells[0];
			HSSFCell endCell = boundaryCells[1];
			int headerRow = startCell.getRowIndex();
			int startRow = startCell.getRowIndex() + 1;
			int endRow = endCell.getRowIndex();
			int startCol = startCell.getColumnIndex() + 1;
			int endCol = endCell.getColumnIndex() - 1;
			
            testData = new TestParameters[endRow - startRow + 1][testParamColSize];
            for(int i = 0; i < (endRow - startRow + 1); i++){
            	testData[i][testParamColSize - 1] = new TestParameters();
            }
            
			for (int i = startRow; i < endRow + 1; i++) {
				for (int j = startCol; j < endCol + 1; j++) {
					if (null == sheet.getRow(i).getCell(j)
							|| sheet.getRow(i).getCell(j).getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						testData[i - startRow][testParamColSize - 1].setParamMap(sheet.getRow(headerRow).getCell(j).getStringCellValue(), "");
					} else {
						if (sheet.getRow(i).getCell(j).getCellType() == HSSFCell.CELL_TYPE_STRING) {
							testData[i - startRow][testParamColSize - 1].setParamMap(sheet.getRow(headerRow).getCell(j).getStringCellValue(), sheet
									.getRow(i).getCell(j).getStringCellValue());
						} else if (sheet.getRow(i).getCell(j).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							Double temp = sheet.getRow(i).getCell(j)
									.getNumericCellValue();
							testData[i - startRow][testParamColSize - 1].setParamMap(sheet.getRow(headerRow).getCell(j).getStringCellValue(), String
									.valueOf(temp.intValue()));
						}
					}

				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return testData;
	}



	/**
	 * Find cell.
	 *
	 * @param sheet the sheet
	 * @param text the text
	 * @return the HSSF cell[]
	 */
	public static HSSFCell[] findCell(HSSFSheet sheet, String text) {
		String pos = "start";
		HSSFCell[] cells = new HSSFCell[2];
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING
						&& text.equals(cell.getStringCellValue())) {
					if (pos.equalsIgnoreCase("start")) {
						cells[0] = (HSSFCell) cell;
						pos = "end";
					} else {
						cells[1] = (HSSFCell) cell;
					}
				}
			}
		}
		return cells;
	}

	/**
	 * Find range.
	 *
	 * @param sheet the sheet
	 * @param text the text
	 * @return the HSSF cell[]
	 */
	public static HSSFCell[] findRange(HSSFSheet sheet, String text) {
		String pos = "start";
		HSSFCell[] cells = new HSSFCell[2];
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (text.equals(cell.getStringCellValue())) {
					if (pos.equalsIgnoreCase("start")) {
						cells[0] = (HSSFCell) cell;
						// System.out.println("First Cell found at:"+cell.getRowIndex()+","+cell.getColumnIndex()
						// );
						pos = "end";
					} else {
						cells[1] = (HSSFCell) cell;
					}
				}
			}
		}
		return cells;
	}
}
