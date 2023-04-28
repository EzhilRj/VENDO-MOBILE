package Engines;

import Utilities.ExcelUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static Utilities.Constants.*;
import static Utilities.Constants.datacolumn;
import static Utilities.ExcelUtils.totalrows;

public class TestEngine {

    public static void Execute() throws IOException, InvocationTargetException, IllegalAccessException, InterruptedException {

        ExcelUtils.ReadExcel(Excelpath);
        MethodsEngine methodsEngine = new MethodsEngine();

        for (int row = 1; row <= totalrows; row++) {

            ExcelUtils.Get_Locators_Keyword_Datas(row,Testdescription,locatorcolumn, keywordcolumn, datacolumn);

            ObjectsEngine.element();
            methodsEngine.InvokeMethods();

        }
    }
}
