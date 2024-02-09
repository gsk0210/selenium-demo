package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    WebDriver driver;
    WebDriverWait wait;

    public Login(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user-name")
    WebElement userNameInputBox;
    @FindBy(id = "password") WebElement passwordInputBox;
    @FindBy(id = "login-button") WebElement loginButton;

    public void enterUserNameInInputBox(String username){
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        userNameInputBox.sendKeys(username);
    }

    public void enterPasswordInputBox(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
       passwordInputBox.sendKeys(password);
    }

    public void clickOnSignInButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

}
