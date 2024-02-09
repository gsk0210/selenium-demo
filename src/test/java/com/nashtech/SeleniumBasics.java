package com.nashtech;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;

public class SeleniumBasics {
    public WebDriver driver;

    @Parameters(value = {"browser"})
    @BeforeClass
    public void setUp(String browser){
        if(browser.equalsIgnoreCase("Chrome"))
        {
            driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("Edge")){
            driver=new EdgeDriver();
        }
    }
    @Test
    public void basicTests() throws InterruptedException {

       /* driver.get("https://www.google.co.in/");
        driver.manage().window().minimize();
        driver.navigate().to("https://www.google.co.in/");
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();*/
        driver.navigate().to("https://www.saucedemo.com/v1/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("user-name")).sendKeys("007");
        System.out.println(driver.findElement(By.id("user-name")).getAttribute("value"));
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(RelativeLocator.with(By.tagName("input")).below(driver.findElement(By.id("user-name"))));
        System.out.println(driver.findElement(By.id("login-button")).isEnabled());
        driver.findElement(By.id("login-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement errorMessage=driver.findElement(By.cssSelector("h3[data-test='error']"));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        System.out.println(driver.findElement(By.cssSelector("h3[data-test='error']")).getText());
       /*driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        Select dropdown=new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByIndex(2);
        dropdown.selectByValue("1");
        dropdown.selectByVisibleText("Option 2");
        System.out.println(dropdown.getAllSelectedOptions());
        System.out.println(dropdown.isMultiple());
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector("a[href=\"/windows/new\"]")).click();
        System.out.println(driver.getWindowHandles());
        String currentWindowHandle=driver.getWindowHandle();
        for (String windowHandle: driver.getWindowHandles()){
            if (!currentWindowHandle.contentEquals(windowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement iframeLocator=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeLocator);
        driver.findElement(By.id("tinymce")).sendKeys("Testing");
        driver.switchTo().defaultContent();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        alert.dismiss();
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        alert.sendKeys("Test");
        alert.accept();*/
    }
}
