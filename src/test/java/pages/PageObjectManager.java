package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    WebDriver driver;
    Login login;

    public PageObjectManager(WebDriver driver){
       this.driver = driver;
    }

    public Login getLoginPage(){
        login=new Login(driver);
        return login;
    }



}
