package GlobalUse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static GlobalUse.Constant.itemsXPath;
import static GlobalUse.TestSetUp.locateElements;

/*
    Logic:
    1. Get Categories in a list
    => ['phones',Laptops','Monitors']
    2. Make sure each of them has items:
    => inside for loop collect items
    => put them in a list
    => if size()>0 ? "Test Pas" : "Test Fails"
*/
public class Category {
    public static List<WebElement> categoryAllocate(String category_xpath){
        List<WebElement> categoryList = TestSetUp.driver.findElements(By.xpath(category_xpath));
        return categoryList;
    }
    public static void checkItems(List<WebElement> category_list, String test_name){
        for (int i = 0; i < category_list.size(); i++) {
            WebElement categoryElement = category_list.get(i);
            categoryElement.click();
            //allocate each category items inside a list
            List<WebElement> items = locateElements(By.xpath(itemsXPath));
            if (items.size() > 0) {
                System.out.println(test_name+" "+ category_list.get(i).getText()+ " items test passed");
            } else {
                System.out.println(test_name + " test failed");
            }
        }

    }
}
