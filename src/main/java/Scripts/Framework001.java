package Scripts;

import AppModules.Signup_Action;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static Engines.TestEngine.RunEngine;
import static Engines.TestEngine.RunEngine;

public class Framework001 extends Baseclass {

    @Test
    public void ISPFillform() throws InterruptedException, IOException, InvocationTargetException, IllegalAccessException {

        Signup_Action action = new Signup_Action();
        action.Execute();
    }




}
