import GlobalUse.Cart;
import GlobalUse.TestSetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import java.util.List;
import static GlobalUse.Constant.*;
import static GlobalUse.DeleteFromCart.*;

public class DeleteFromCartTest {
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
    @DisplayName("Delete item from cart")
    public void deleteItemFromCartRowsCheck(){
        String testName = "Delete item row check";
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
            //get rows count
            int tableRows = tableRows();
            //allocate delete link
            deleteAllocate(deleteXPath);
            try {
                deleteItemVerificationByRows(testName,tableRows);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception exception){
            System.out.println(testName+" failed\nAn Exception occurs :"+exception);
        }
    }

    @Test
    @DisplayName("Delete item from cart")
    public void deleteItemFromCartNameCheck(){
        String testName = "Delete item name check";
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
            //allocate delete link
            deleteAllocate(deleteXPath);
            try {
                deleteItemVerificationByItem(testName);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
