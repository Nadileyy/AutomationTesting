import GlobalUse.Cart;
import GlobalUse.TestSetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import java.util.List;
import static GlobalUse.CheckOut.*;
import static GlobalUse.Constant.*;

public class CheckOutTest {
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
    @DisplayName("Positive Checkout")
    public void positiveCheckout(){
        String testName = "Positive Checkout";
        try{
            //allocate elements from the home page
            List<WebElement> items = Cart.itemsAllocate();
            //Click on one of them randomly
            Cart.clickOnItem(items);
            //Click on add to cart button
            Cart.addElementToCart(addToCartBtn);
            //accept alert
            TestSetUp.acceptAlert();
            //Now navigate to the cart page
            Cart.openCartPage(cartPageXPath);
            allocatePlaceOrder();
            enterPositiveCardInfo(cardNameInput, cardCountryInput, cardCityInput, cardNumberInput,
                    cardMonthInput, cardYearInput);
            purchaseAllocate();
            positiveVerification(testName);
        } catch (Exception exception){
            System.out.println(testName+" failed\nAn Exception occurs :"+exception);
        }
    }
    @Test
    @DisplayName("Checkout with empty cart")
    public void emptyCartCheckOut(){
        String testName = "Checkout with empty cart";
        try{
            Cart.openCartPage(cartPageXPath);
            allocatePlaceOrder();
            enterPositiveCardInfo(cardNameInput, cardCountryInput, cardCityInput, cardNumberInput,
                    cardMonthInput, cardYearInput);
            purchaseAllocate();
            emptyCartVerification(testName);
        } catch (Exception exception){
            System.out.println(testName+" failed\nAn Exception occurs :"+exception);
        }
    }

    @Test
    @DisplayName("Checkout with empty fields")
    public void emptyFieldsCheckOut(){
        String testName = "Checkout with empty field";
        try{
            Cart.openCartPage(cartPageXPath);
            allocatePlaceOrder();
            enterPositiveCardInfo(emptyInput, emptyInput, emptyInput, emptyInput,
                    emptyInput, emptyInput);
            purchaseAllocate();
            String text = TestSetUp.alertText();
            emptyFieldsVerification(checkOutAlert,text,testName);
            TestSetUp.acceptAlert();
        } catch (Exception exception){
            System.out.println(testName+" failed\nAn Exception occurs :"+exception);
        }

    }

    /*************************************************** After **************************************************/
    @AfterEach
    public void tearDown(){
        TestSetUp.quitDriver();
    }
}
