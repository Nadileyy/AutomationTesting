import GlobalUse.Cart;
import GlobalUse.TestSetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import java.util.List;
import static GlobalUse.AddToCart.*;
import static GlobalUse.Constant.*;

public class AddToCartTest {
    /*************************************************** Before **************************************************/
    @BeforeAll
    public static void SetUpMethod() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void SetUp() {
        TestSetUp.setUp();
    }
    /*************************************************** Tests ***************************************************/

    @Test
    @DisplayName("Add to cart with alert check")
    public void addToCartAlertVerification(){
        String testName = "Add to cart with alert check";
        try{
            //allocate elements from the home page
            List<WebElement> items = Cart.itemsAllocate();
            //Click on one of them randomly
            Cart.clickOnItem(items);
            //Click on add to cart button
            Cart.addElementToCart(addToCartBtn);
            //Verify that alert works properly
            String alertText = TestSetUp.alertText();
            TestSetUp.verificationAlert(successfulAddition,alertText,testName);
            TestSetUp.acceptAlert();
        } catch (Exception exception){
            System.out.println(testName+" failed\nAn Exception occurs :"+exception);
        }
    }

    @Test
    @DisplayName("Add to cart")
    public void addToCartVerification() {
        String testName = "Add to cart";
        try {
            //allocate elements from the home page
            List<WebElement> items = Cart.itemsAllocate();
            //Click on one of them randomly
            Cart.clickOnItem(items);
            //Click on add to cart button
            Cart.addElementToCart(addToCartBtn);
            //accept alert
            TestSetUp.acceptAlert();
            //get the actual name of the item from this page before navigating to the cart page
            String itemText = elementText(itemName);
            //Now navigate to the cart page
            Cart.openCartPage(cartPageXPath);
            //Now if we find the same name of the product in the cart page, so item is added successfully.
            checkCart(itemText, itemNameCartPage, testName);
        } catch (Exception exception) {
            System.out.println(testName + " failed\nAn Exception occurs :" + exception);
        }
    }

    /*************************************************** After **************************************************/
    @AfterEach
    public void tearDown(){
        TestSetUp.quitDriver();
    }

}
