package Page_Object;

import base.config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignUp_page extends config {

    public SignUp_page(WebDriver driver){
        PageFactory.initElements(driver,this);
        config.driver=driver;
    }
    @FindBy(how= How.ID,using="user_email")
    public static WebElement emailId;
    @FindBy(how=How.ID,using="user_password")
    public static WebElement Npass;
    @FindBy(how=How.ID,using="user_password_confirmation")
    public static WebElement conpass;
    @FindBy(how=How.ID,using="user_first_name")
    public static WebElement fn;
    @FindBy(how=How.ID,using="user_last_name")
    public static WebElement ln;
    @FindBy(how=How.ID,using="user_company")
    public static WebElement comName;
    @FindBy(how=How.ID,using="user_terms_and_conditions")
    public static WebElement checkbox;
    @FindBy(how=How.XPATH,using="//button[@class=' btn btn-success pull-right']")
    public static WebElement createaccountbutton;




    public void email_Id(String email){
        emailId.sendKeys(email);
    }
    public void Npassword(String npas){
        Npass.sendKeys(npas);
    }
    public void Conpassword(String cpas){
        conpass.sendKeys(cpas);
    }
    public void FirstName(String Fname){
        fn.sendKeys(Fname);
    }
    public void LastName(String Lname){
        ln.sendKeys(Lname);
    }
    public void companyName(String Company){
        comName.sendKeys(Company);
    }
    public void CheckBox(){
        checkbox.click();
    }
    public void create_Button(){
        createaccountbutton.click();
    }








}
