package GlobalUse;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static GlobalUse.Constant.*;
import static GlobalUse.TestSetUp.locateElement;
import static GlobalUse.TestSetUp.locateElements;

public class DeleteFromCart {

    public static int tableRows(){
        List<WebElement> rowsListBefore = locateElements(By.xpath(itemsTableRows));
        int rowsBeforeDelete = rowsListBefore.size();
        return rowsBeforeDelete;
    }
    public static void deleteAllocate(String delete_link_xpath){
        WebElement deleteRowsList = locateElement(By.xpath(delete_link_xpath));
        deleteRowsList.click();
    }

    public static void deleteItemVerificationByRows(String test_name, int table_rows) throws InterruptedException {
        Thread.sleep(2000);
        try{
            boolean isTagPresent = TestSetUp.driver.findElements(By.tagName(itemsTableRows)).size() > 0;
            if(!isTagPresent){
                System.out.println(test_name+" passed");
            } else{
                System.out.println(test_name+" failed");
            }
        } catch (Exception ex){
            System.out.println("An exception occurs : "+ex);
        }

    }

    public static void deleteItemVerificationByItem(String test_name) throws InterruptedException {
        Thread.sleep(2000);
        try{
            boolean deletedItem = TestSetUp.driver.findElements(By.xpath(itemNameCartPage)).isEmpty();
            Assertions.assertTrue(deletedItem);
            System.out.println(test_name+" passed");
        } catch (AssertionError assertionError){
            System.out.println(test_name+" failed\nAn AssertionError occurs : "+assertionError);
        }

    }



}
