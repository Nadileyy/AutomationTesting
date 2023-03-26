package GlobalUse;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class TestSetUp {
    public static WebDriver driver;
    public static final int WAIT_FOR_ELEMENT_TIMEOUT = 30;
    public static WebDriverWait webDriverWait;
    public static Actions actions;
    public static void setUp(){
        //I use this approach because of webSocketException
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
//        driver.manage().window().maximize();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));

        actions = new Actions(driver);

        driver.navigate().to("https://www.demoblaze.com/");
    }
    public static void quitDriver(){
        //quit driver if it's initialize
        if(driver != null){
            driver.quit();
        }
    }
    public static WebElement locateElement(By locator) {
        //wait until the element appears and return the element.
        return TestSetUp.webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static List<WebElement> locateElements(By locator) {
        //wait until the elements appear and return the element.
        return Collections.singletonList(TestSetUp.webDriverWait.until(ExpectedConditions.elementToBeClickable(locator)));
    }

    public static String alertText(){
        TestSetUp.webDriverWait.until(ExpectedConditions.alertIsPresent());
        String alertText = TestSetUp.driver.switchTo().alert().getText();
        return alertText;
    }
    public static void acceptAlert(){
        TestSetUp.webDriverWait.until(ExpectedConditions.alertIsPresent());
        TestSetUp.driver.switchTo().alert().accept();
    }

    public  static  void verificationAlert(String expected_alert, String alert_text, String test_name){
        try{
            Assertions.assertEquals(expected_alert,alert_text);
            System.out.println(test_name+" passed");
        } catch (AssertionError assertionError){
            System.out.println("An AssertionError occurs while completing registration.\n" +
                    "AssertionError : "+assertionError);
        }
    }
}
