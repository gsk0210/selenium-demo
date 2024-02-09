//package util;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//public class Base {
//
//    WebDriver driver;
//
//    public WebDriver initializeDriver(){
//        if(driver==null) {
//            if (ProjectConfig.browser.equals("Chrome")) {
//                driver = new ChromeDriver();
//            } else if (ProjectConfig.browser.equals("Firefox")) {
//                driver = new FirefoxDriver();
//            }
//        }
//        return driver;
//    }
//
//
//}
