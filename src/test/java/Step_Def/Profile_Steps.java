package Step_Def;

import Page_Object.Profile_page;
import base.config;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Profile_Steps extends config {
    
    Profile_page pp=new Profile_page(driver);
    @And("user click on profile")
    public void userClickOnProfile() throws InterruptedException {
        Thread.sleep(2000);
        pp.profile();
        pp.profile_button();

    }


    @And("user select random value and save it")
    public void userSelectRandomValue() {
        pp.Energy();
    }

    @Then("user will verify he can select value")
    public void userWillVerifyHeCanSelectValue() throws InterruptedException {
        Thread.sleep(10000);
        Shutterbug.shootPage(driver, Capture.FULL_SCROLL).withName("Expected_profile_Image").save("target");

    }

    @Then("user varify the selected value")
    public void userVarifyTheSelectedValue() throws IOException {
        File image=new File("target/Expected_profile_Image.png");
        BufferedImage expectedImage= ImageIO.read(image);
        boolean br= Shutterbug.shootPage(driver, Capture.FULL_SCROLL).withName("Actual_profile").equals(expectedImage);
        System.out.println(br);
        Assert.assertTrue(br);
    }
}
