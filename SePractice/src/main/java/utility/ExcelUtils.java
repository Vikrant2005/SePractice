package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFRow Row;
	private static XSSFCell Cell;
	
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	
	public static void setExcelFile(String Path,String SheetName) throws Exception
	{
		try
		{	//Open the Excel File
			FileInputStream ExcelFile =new FileInputStream(Path);
			ExcelWBook=new XSSFWorkbook(ExcelFile);  //Access the required test data sheet
			ExcelWSheet=ExcelWBook.getSheet(SheetName);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	//This method is to read the test data from the Excel cell, in this w
	
	public static String getCellData(int RowNum,int ColNum) throws Exception
	{
		try
		{	
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		}
		catch(Exception e)
		{
			return "";
		}
	}
	
	//This method is to write in the Excel cell
	public static String setCellData(String Result,int RowNum,int ColNum) throws Exception
	{
		try
		{	
			Row =ExcelWSheet.getRow(RowNum);
			Cell=Row.getCell(ColNum,Row.RETURN_BLANK_AS_NULL);
			if(Cell==null)
			{
				Cell=Row.createCell(ColNum);
				Cell.setCellValue(Result);
			}
			else
			{
				Cell.setCellValue(Result);
			}
			
			// Constant variables Test Data path and Test Data file name
			

				FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

				ExcelWBook.write(fileOut);

				fileOut.flush();

				fileOut.close();
			
		}
		catch(Exception e)
		{
			throw(e);
		}
		return Result;
	}
	

	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
		int i;
	    try {
		    int rowCount = ExcelUtils.ExcelWSheet.getLastRowNum();
	        for ( i=0 ; i<rowCount; i++){
		        if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
		            break;
		           }
		        }
	        return i;
	    }catch (Exception e){
		    Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
	        throw(e);
		    }
	    }
	

	
	
}
