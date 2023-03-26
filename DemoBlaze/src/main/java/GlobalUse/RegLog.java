package GlobalUse;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static GlobalUse.TestSetUp.locateElement;

public class RegLog {
    public static void signUpAllocate(String sign_path){
        WebElement signUpButton = locateElement(By.xpath(sign_path));
        signUpButton.click();
    }
    public static void closeWindow(String close_path){
        WebElement closeBtn =  locateElement(By.xpath(close_path));
        closeBtn.click();
    }
    public static void userNameAndPasswordAllocate(String username_path, String password_path, String button_xpath
        , String userName, String password){

        WebElement userNameInput =  locateElement(By.xpath(username_path));
        userNameInput.sendKeys(userName);

        WebElement passwordInput =  locateElement(By.xpath(password_path));
        passwordInput.sendKeys(password);

        WebElement signButton =  locateElement(By.xpath(button_xpath));
        signButton.click();
    }





}
