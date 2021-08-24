package Page_Object;

import base.Test_Data;
import base.config;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Profile_page extends config {

    Test_Data td=new Test_Data();
    static Faker randata = new Faker();
    int i=randata.number().numberBetween(1,5);
    int j=randata.number().numberBetween(1,17);
    int k=randata.number().numberBetween(1,3);
    int l=randata.number().numberBetween(1,2);
    int m=randata.number().numberBetween(1,35);
    public Profile_page(WebDriver driver){
        PageFactory.initElements(driver,this);
        config.driver=driver;
    }
    @FindBy(how= How.XPATH,using="//i[@class='topnav__menu-link-caret']")
    public static WebElement profile_Drop;
    @FindBy(how= How.XPATH,using="//a[@ui-sref='myAccount.profile']")
    public static WebElement profileButton;
    @FindBy(how= How.XPATH,using="//select[@ng-model='UI.energyUnits']")
    public WebElement enereydd;
    @FindBy(how= How.XPATH,using="//select[@ng-model='UI.waterUnits']")
    public WebElement waterdd;
    @FindBy(how= How.XPATH,using="//select[@ng-model='UI.wasteUnits']")
    public WebElement wastedd;
    @FindBy(how= How.XPATH,using="//select[@ng-model='UI.units']")
    public WebElement measurementdd;
    @FindBy(how= How.XPATH,using="//select[@ng-model='UI.currency']")
    public WebElement currencydd;
    @FindBy(how= How.XPATH,using="//button[@class='btn btn-success']")
    public WebElement saveButton;









      public void profile(){
          profile_Drop.click();
      }
      public void profile_button(){
          profileButton.click();
      }
      public void Energy(){

          Select sel1=new Select(enereydd);
          sel1.selectByIndex(i);
          Select sel2=new Select(waterdd);
          sel2.selectByIndex(j);
          Select sel3=new Select(wastedd);
          sel3.selectByIndex(k);
          Select sel4=new Select(measurementdd);
          sel4.selectByIndex(l);
          Select sel5=new Select(currencydd);
          sel5.selectByIndex(m);
          saveButton.click();
      }




}
