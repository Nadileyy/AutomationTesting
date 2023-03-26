import GlobalUse.Category;
import GlobalUse.TestSetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import java.util.List;
import static GlobalUse.Category.categoryAllocate;
import static GlobalUse.Constant.*;


public class CategoryTest {
    /*************************************************** Before **************************************************/
    @BeforeAll
    public static void SetUpMethod() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void SetUp() {
        TestSetUp.setUp();
    }
    /*************************************************** Test ***************************************************/
    @Test
    @DisplayName("Category has items")
    public void CheckCategoryItems(){
        String testName = "Category has items";
        try{
            List<WebElement> category = categoryAllocate(categoryXPath);
            Category.checkItems(category,testName);
        } catch (Exception exception){
            System.out.println(testName+"test, failed.\n" + "An Exception occurred: "+exception);
        }
    }
}