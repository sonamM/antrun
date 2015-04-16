package com.etouch.taf.core.datamanager.excel.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.etouch.taf.core.datamanager.excel.XlsReader;

public class XLS_ReaderTest {
	
	XlsReader datatable = null;
	
	@Before
	public void setUp()
	{
		datatable = new XlsReader("C:\\Lavanya\\Project\\eTouch\\eTap_framework\\emp1.xls");
	}


	@Test
	public void isSheetExiststest() {
		 
		   Assert.assertTrue(datatable.isSheetExist("E1"));  
	}
	
	@Test
	public void checkExcelData()
	{
		   Assert.assertEquals(5, datatable.getRowCount("E1"));
		   //Assert.assertEquals(3, datatable.getColumnCount("E1"));
		   Assert.assertEquals(2, datatable.getCellRowNum("E1", "Name", "Lavanya"));
	}
	
	@Test
	public void isSheetAdded()
	{
		   Assert.assertTrue(datatable.addSheet("E2"));
		   Assert.assertTrue(datatable.addSheet("E3"));	
	}
	
	@Test
	public void isColumnAdded()
	{
		   Assert.assertTrue( datatable.addColumn("E1", "Mail"));
		   Assert.assertTrue(datatable.addColumn("E1", "Phone"));
	}
	
	@Test
	public void isDataSet()
	{
		   Assert.assertTrue(datatable.setCellData("E1", "Salary", 2, "5000"));
		   Assert.assertTrue(datatable.setCellData("E1", "Age", 3, "30", "C:/Lavanya/Project/eTouch/eTap_framework/staff.xlsx"));
	}
	
	@Test
	public void checkCellDataTest()
	{
		   String cellText = datatable.getCellData("E1", 2, 4);
		   Assert.assertEquals("3000.0", cellText);
			
		   cellText = datatable.getCellData("E1", "Name", 3);
		   Assert.assertEquals("Raji" , cellText);
	}
	
	@Test
	public void readExcelDataTest()
	{
		   
		   String[][] data = datatable.readXLSData("E1");
		   Assert.assertNotNull(data);
		   Assert.assertEquals(5, data.length);		  
	}
	
	@Test
	public void isSheetRemovedTest()
	{
	    Assert.assertTrue(datatable.removeSheet("E2"));
	}
	
	@Test
	public void isColumnRemovedTest()
	{
	
		  Assert.assertTrue(datatable.removeColumn("E1", 4));			
			
	}
}
