package com.test.automation.uiAutomation.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String path;
	public FileInputStream file;
	public FileOutputStream Output;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public ExcelReader(String path) throws IOException

	{
		this.path = path;

		try {
			file = new FileInputStream(path);
			workbook = new XSSFWorkbook(file);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "deprecation" })
	public String[][] getDataFromSheet(String ExcelName, String SheetName) {

		String dataset[][] = null;

		try {

			XSSFSheet sheet = workbook.getSheet(SheetName);

			int totalRow = sheet.getLastRowNum() + 1;

			int totalCol = sheet.getRow(0).getLastCellNum();

			dataset = new String[totalRow - 1][totalCol];

			for (int i = 1; i < totalRow; i++)

			{
				XSSFRow row = sheet.getRow(i);

				for (int j = 0; j < totalCol; j++)

				{

					XSSFCell cell = row.getCell(j);

					if (cell.getCellType() == cell.CELL_TYPE_STRING)

					{
						dataset[i - 1][j] = cell.getStringCellValue();

					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC)

					{
						String celltext = String.valueOf(cell
								.getNumericCellValue());

						dataset[i - 1][j] = celltext;

					}

					else

						dataset[i - 1][j] = String.valueOf(cell
								.getBooleanCellValue());

				}

			}

			return dataset;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataset;
	}

}
