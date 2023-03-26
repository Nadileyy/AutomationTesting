package GlobalUse;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static GlobalUse.Constant.*;
import static GlobalUse.TestSetUp.*;

public class CheckOut {

    public static void allocatePlaceOrder(){
        WebElement placeOrderBtn = TestSetUp.driver.findElement(By.xpath(placeOrderXPath));
        placeOrderBtn.click();
    }

    public static void enterPositiveCardInfo(String name_input, String country_input, String city_input,
                                             String card_number_input, String month_input, String year_input){
        WebElement nameInput = locateElement(By.xpath(name));
        nameInput.sendKeys(name_input);

        WebElement countryInput = locateElement(By.xpath(country));
        countryInput.sendKeys(country_input);

        WebElement cityInput = locateElement(By.xpath(city));
        cityInput.sendKeys(city_input);

        WebElement cardNumberInput = locateElement(By.xpath(creditCard));
        cardNumberInput.sendKeys(card_number_input);

        WebElement monthInput = locateElement(By.xpath(month));
        monthInput.sendKeys(month_input);

        WebElement yearInput = locateElement(By.xpath(year));
        yearInput.sendKeys(year_input);
    }
    public static void purchaseAllocate(){
        WebElement placeOrderBtn = TestSetUp.driver.findElement(By.xpath(purchaseXPath));
        placeOrderBtn.click();
    }

    public static void positiveVerification(String test_name) {
        try{
            WebElement element = locateElement(By.xpath(positiveCheckOut));
            String text = element.getText();
            Assertions.assertEquals("Thank you for your purchase!",text);
            System.out.println(test_name+" passed");
        } catch (AssertionError assertionError){
            System.out.println(test_name+" failed\nAn AssertionError occurs :"+assertionError);
        }

    }

    public static void emptyCartVerification(String test_name){
        try{
            WebElement element = locateElement(By.xpath(positiveCheckOut));
            String text = element.getText().toLowerCase();
            if(text.equalsIgnoreCase("Thank you for your purchase!")){
                System.out.println(test_name+" failed");
            } else{
                System.out.println(test_name+" passed");
                System.out.println(text);
            }
        } catch (Exception exception){
            System.out.println(test_name+" failed\nAn Exception occurs :"+exception);
        }

    }

    public static void emptyFieldsVerification(String actual_text, String alert_text,String test_name){
        try{
            Assertions.assertEquals(actual_text,alert_text);
            System.out.println(test_name+" passed");
        } catch (AssertionError assertionError){
            System.out.println(test_name+" failed\nAn AssertionError occurs :"+assertionError);
        }
    }
}

/*
 Assertions.assertEquals("Thank you for your purchase!",allocatedText);
            System.out.println(test_name+" passed");
        } catch (AssertionError assertionError){
            System.out.println("An AssertionError occurs :"+assertionError);
        }
 */
