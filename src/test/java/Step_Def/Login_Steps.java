package Step_Def;

import Page_Object.Login_page;
import base.config;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Login_Steps extends config {

    Login_page login=new Login_page(driver);
    @Given("User is in login page")
    public void user_is_in_login_page() {
    }


    @And("user verify he is in correct page")
    public void userVerifyHeIsInCorrectPage() throws IOException {
        File image=new File("target/Expected.png");
        BufferedImage expectedImage= ImageIO.read(image);
        boolean br= Shutterbug.shootPage(driver, Capture.FULL_SCROLL).withName("Actual").equals(expectedImage);
        System.out.println(br);
        Assert.assertTrue(br);

    }

    @And("user enter his userID and Password")
    public void userEnterHisUserIDAndPassword() {
        login.user_ID("abc@gmail.com");
        login.password("Abc@1234");
    }

    @When("user click on login button")
    public void userClickOnLoginButton() {
        login.button();
    }

    @Then("User will successfully login")
    public void userWillSuccessfullyLogin() {
    }

    @And("user enter their invalid userID and Password")
    public void userEnterTheirInvalidUserIDAndPassword() {
        login.user_ID("abcd@gmail.com");
        login.password("abc123");
    }


    @Then("User will not be able to login")
    public void userWillNotBeAbleToLogin() {
    }
}
