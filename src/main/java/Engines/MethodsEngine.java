package Engines;

import Utilities.Actions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static Scripts.Baseclass.driver;
import static Utilities.ExcelUtils.Keywords;

public class MethodsEngine {
    Actions actions;

    // This constructor getting methods for Actions Class
    Method[ ] methods;


    public MethodsEngine() {

        actions = new Actions(driver);
        methods = actions.getClass().getMethods();
    }

    public void InvokeMethods() throws InvocationTargetException, IllegalAccessException, InterruptedException {

        try{

            for (int i = 0; i < methods.length; i++) {

                if (methods[i].getName().equalsIgnoreCase(Keywords)) {
                    methods[i].invoke(actions);
                    break;
                }
            }

        }catch(Exception e){

            e.printStackTrace();

        }



    }
}

