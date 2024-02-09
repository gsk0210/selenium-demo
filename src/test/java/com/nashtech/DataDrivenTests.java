package com.nashtech;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.PageObjectManager;
import util.ProjectConfig;


import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class DataDrivenTests {
    public WebDriver driver;

    public WebDriverWait wait;
    PageObjectManager pom;
   // TestContextSetup tcs;



    @BeforeMethod
    public void setUp() throws MalformedURLException {
       // tcs.base.initializeDriver().get(ProjectConfig.url);

       /* base=new Base();
        driver=base.initializeDriver("Chrome");
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        pom=new PageObjectManager(driver);*/

       //driver=new ChromeDriver();


       ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "linux");
        chromeOptions.setCapability("se:name", "Demo Test");
        chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        

    }

    @Test(dataProvider = "getTestData")
    public void validateLoginCredentials(String username,String password) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(ProjectConfig.url);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user-name"))));
        driver.findElement(By.id("user-name")).sendKeys(username);
        WebElement passwordInput=driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
        WebElement loginButton=driver.findElement(By.id("login-button"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        Thread.sleep(2000);
        /*pom.getLoginPage().enterUserNameInInputBox(username);
        pom.getLoginPage().enterPasswordInputBox(password);
        pom.getLoginPage().clickOnSignInButton();*/
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @DataProvider
    public Object[][] getTestData() throws IOException, CsvException {
        String csvFilePath="src/main/resources/credentials.csv";
        CSVReader reader = new CSVReader(new FileReader(csvFilePath));
        reader.readNext();
        int numberOfRows=reader.readAll().size();
        Object[][] testData = new Object[numberOfRows][2];
        reader.close();
        reader = new CSVReader(new FileReader(csvFilePath));
        reader.readNext();
        for (int i = 0; i < numberOfRows; i++) {
            String[] dataRow = reader.readNext();
            testData[i][0] = dataRow[0];
            testData[i][1] = dataRow[1];
        }
        reader.close();

        return testData;
    }
}
