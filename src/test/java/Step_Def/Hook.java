package Step_Def;

import base.config;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hook extends config {
    public static String url;
   // public static String baseurl= System.getProperty("env");
    public static String DriverType=System.getProperty("browser");
    @Before
    public void openbrowser(){
        driver=setupDriver(DriverType);
        url="https://app.measurabl.com/sign-in";
        driver.get(url);
    }
    @After
    public void tearDown(Scenario scenario){
        try{
            if (scenario.isFailed()){

                Shutterbug.shootPage(driver, Capture.FULL_SCROLL).withName("ActualFailure").save("C:\\Users\\smdsh\\Documents\\Measurabl\\target");


            }

        } catch (Exception e){
            System.out.println(e);
        }

        driver.quit();
    }



}



