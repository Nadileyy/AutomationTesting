package GlobalUse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static GlobalUse.Constant.itemsXPath;
import static GlobalUse.TestSetUp.locateElement;
import static GlobalUse.TestSetUp.locateElements;

public class Cart {
    public static List<WebElement> itemsAllocate(){
        List<WebElement> itemsList = locateElements(By.xpath(itemsXPath));
        return itemsList;
    }
    public static void clickOnItem(List<WebElement> item_list){
        if(!item_list.isEmpty()){
            int length = item_list.size();
            Random random = new Random();
            int itemIndex = random.nextInt(length); //0-8
            //click on random element
            item_list.get(itemIndex).click();
        } else{
            System.out.println("List of items is empty");
        }
    }
    public static void addElementToCart(String add_btn_xpath){
        WebElement addBtn =  locateElement(By.xpath(add_btn_xpath));
        addBtn.click();
    }
    public static void openCartPage(String cart_xpath){
        WebElement cartLink =  locateElement(By.xpath(cart_xpath));
        cartLink.click();
    }

}
