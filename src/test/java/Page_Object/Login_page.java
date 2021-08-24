package Page_Object;

import base.config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login_page extends config {

    public Login_page(WebDriver driver){
        PageFactory.initElements(driver,this);
        config.driver=driver;

    }
    @FindBy(how= How.ID,using="user_email")
    public static WebElement userId;
    @FindBy(how= How.ID,using="user_password")
    public static WebElement pass;
    @FindBy(how= How.XPATH,using="//button[@type='submit']")
    public static WebElement loginButton;
    @FindBy(how= How.XPATH,using="//input[@type='checkbox']")
    public static WebElement checkbox;
    @FindBy(how= How.PARTIAL_LINK_TEXT,using="Create an account")
    public static WebElement signuplink;







    public void user_ID(String gmail){
        userId.sendKeys(gmail);
    }
    public void password(String pas){
        pass.sendKeys(pas);
    }
    public void button(){
        loginButton.click();
    }
    public void createaccountlink(){
        signuplink.click();
    }






}
