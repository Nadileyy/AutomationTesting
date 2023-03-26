package GlobalUse;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

import static GlobalUse.Constant.itemsXPath;
import static GlobalUse.TestSetUp.locateElement;
import static GlobalUse.TestSetUp.locateElements;

public class AddToCart {

    public static String elementText(String ele_name_xpath){
        String text = locateElement(By.xpath(ele_name_xpath)).getText();
        return text;
    }
    public static void checkCart(String actual_text, String cart_text_xpath, String test_name){
        try{
            String cartText = locateElement(By.xpath(cart_text_xpath)).getText();
            Assertions.assertEquals(actual_text,cartText);
            System.out.println(test_name+" Passed");
        } catch (AssertionError assertionError){
            System.out.println("An AssertionError occurs while completing registration.\n" +
                    "AssertionError : "+assertionError);
        }
    }
}
/*
    -Logic:
    1. Allocate all elements in a list.
    2. Use random()
    3. Click on any item in the list
    4. Get a text
    5. Get out of the loop
    6. allocate add to cart button
    7. click on it

    -Verification
    1. Alert msg 
    2. Click on cart
    3. allocate element
    4. get text
    5. compare texts using assert
*/
