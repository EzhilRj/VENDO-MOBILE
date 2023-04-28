package Utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtils {

    public static XSSFSheet sheet;
    public static XSSFCell cell;

    public static String Locators;

    public static String Description;
    public static String locatorname;

    public static String locatorvalue;

    public static String Keywords;

    public static String TestDatas ;

    public static int totalrows ;

    public static void ReadExcel(String path) throws IOException {

        FileInputStream fi =  new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        sheet = wb.getSheet("ISPFillForm");

        totalrows = sheet.getLastRowNum();
    }


    public static String Get_Locators_Keyword_Datas(int row , int Testdescription ,int locatorcell , int keywordcell, int datacell) throws IOException {


        Locators = sheet.getRow(row).getCell(locatorcell).toString().trim();

        if(!Locators.contains("NA")){
            String[] split =  Locators.split("=",2);
            locatorname =  split[0].toString().trim();
            locatorvalue = split[1].toString().trim();
        }
        else{
            locatorname = "NA";
            locatorvalue = "NA";
        }

        Description  = sheet.getRow(row).getCell(Testdescription).toString().trim();
        Keywords = sheet.getRow(row).getCell(keywordcell).toString().trim();
        TestDatas = sheet.getRow(row).getCell(datacell).toString().trim();


        return Locators;

    }
}
