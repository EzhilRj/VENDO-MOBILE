package AppModules;

import Engines.TestEngine;
import Utilities.Actions;
import org.testng.Assert;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static Engines.TestEngine.RunEngine;
import static Scripts.Baseclass.driver;

public class Signup_Action {

    public void Execute() throws InterruptedException, IOException, InvocationTargetException, IllegalAccessException {

        RunEngine();
        try{
            Assert.assertTrue(Actions.Verify());
        }catch (Exception e){
            e.getMessage();
            Assert.fail();

        }



    }
}


