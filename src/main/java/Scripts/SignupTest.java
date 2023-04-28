package Scripts;

import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static Engines.TestEngine.Execute;

public class SignupTest extends Baseclass {

    @Test
    public void ISPFillform() throws InterruptedException, IOException, InvocationTargetException, IllegalAccessException {

        Thread.sleep(3000);
        Execute();


    }


}
