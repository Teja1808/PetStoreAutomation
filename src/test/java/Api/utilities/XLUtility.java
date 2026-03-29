package Api.utilities;


	

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class XLUtility {

	    public FileInputStream fi;
	    public FileOutputStream fo;
	    public XSSFWorkbook workbook;
	    public XSSFSheet sheet;
	    public XSSFRow row;
	    public XSSFCell cell;
	    String path;

	    // Constructor that takes the Excel file path [4]
	    public XLUtility(String path) {
	        this.path = path;
	    }

	    // Returns the total number of rows in a sheet [4, 5]
	    public int getRowCount(String sheetName) throws IOException {
	        fi = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fi);
	        sheet = workbook.getSheet(sheetName);
	        int rowcount = sheet.getLastRowNum();
	        workbook.close();
	        fi.close();
	        return rowcount;
	    }

	    // Returns the total number of cells (columns) in a specific row [5]
	    public int getCellCount(String sheetName, int rownum) throws IOException {
	        fi = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fi);
	        sheet = workbook.getSheet(sheetName);
	        row = sheet.getRow(rownum);
	        int cellcount = row.getLastCellNum();
	        workbook.close();
	        fi.close();
	        return cellcount;
	    }

	    // Retrieves data from a specific cell (Most frequently used method) [5]
	    public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
	        fi = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fi);
	        sheet = workbook.getSheet(sheetName);
	        row = sheet.getRow(rownum);
	        cell = row.getCell(colnum);

	        DataFormatter formatter = new DataFormatter();
	        String data;
	        try {
	            data = formatter.formatCellValue(cell); // Returns the formatted value of a cell as a String
	        } catch (Exception e) {
	            data = "";
	        }
	        workbook.close();
	        fi.close();
	        return data;
	    }

	    // Writes data into a specific cell [5, 6]
	    public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
	        fi = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fi);
	        sheet = workbook.getSheet(sheetName);
	        row = sheet.getRow(rownum);
	        cell = row.createCell(colnum);
	        cell.setCellValue(data);

	        fo = new FileOutputStream(path);
	        workbook.write(fo);
	        workbook.close();
	        fi.close();
	        fo.close();
	    }
	}

