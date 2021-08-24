package Step_Def;

import Page_Object.Login_page;
import Page_Object.SignUp_page;
import base.Test_Data;
import base.config;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SignUp_Steps extends config {

    SignUp_page signup=new SignUp_page(driver);
    Login_page login= new Login_page(driver);
   public static Faker randata = new Faker();
    public static String fn = randata.name().firstName();
    public static String ln = randata.name().lastName();
    public static String email = randata.internet().safeEmailAddress();
    public static String company=randata.name().title();
    @And("user click on create account link")
    public void userClickOnCreateAccountLink() {
        login.createaccountlink();
    }


    @And("user will verify that he is on correct page")
    public void userWillVerifyThatHeIsOnCorrectPage() throws IOException {


        File image=new File("target/Expected_SignUp_Page.png");
        BufferedImage ExpectedImage= ImageIO.read(image);
       boolean br= Shutterbug.shootPage(driver, Capture.FULL_SCROLL).withName("Actual_SignUp_Image").equals(ExpectedImage);
        Assert.assertTrue(br);

    }

    @And("user fill out the form")
    public void userFillOutTheForm() {
        signup.email_Id(email);
        signup.Npassword("Abc@1234");
        signup.Conpassword("Abc@1234");
        signup.FirstName(fn);
        signup.LastName(ln);
        signup.companyName(company);
    }

    @And("user check the check box")
    public void userCheckTheCheckBox() {
        signup.CheckBox();

    }

    @When("user click on create account button")
    public void userClickOnCreateAccountButton() {
        signup.create_Button();

    }

    @Then("user successfully create his account")
    public void userSuccessfullyCreateHisAccount() {
    }


    @And("user fill out the form keep email field empty")
    public void userFillOutTheFormKeepEmailFieldEmpty() {
        signup.Npassword("Abc@1234");
        signup.Conpassword("Abc@1234");
        signup.FirstName("xyz");
        signup.LastName("abc");
        signup.companyName("abc");

    }

    @Then("user should not be able to create his account")
    public void userShouldNotBeAbleToCreateHisAccount() {

    }
}
