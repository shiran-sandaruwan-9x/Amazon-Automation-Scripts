package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.TestException;
import utils.CommonUtils;

import java.util.List;

public class ShoppingCartPage extends CommonUtils {

    private final By SHOPPING_CART_HEADER = By.xpath("//*[@id=\"sc-active-cart\"]/div/div/div[1]/h1");
    private final By DELETE_BUTTONS = By.cssSelector("input[value='Delete']");
    private final String SHOPPING_CART_EMPTY_MSG = "Your Shopping Cart is empty.";

    public void verifyOnShoppingCartPage(){
        String url= getCurrentUrl();
        System.out.println("SHOPPING_CART_PAGE: Verifying that we are on SHOPPING_CART_PAGE.");
        if (!url.contains("cart")){
            throw new TestException("ERROR: Not on SHOPPING_CART_PAGE! URL: " + url);
        }
    }

    public void verifyOnShoppingCartReviewPage(){
        String url = getCurrentUrl();
        System.out.println("SHOPPING_CART_PAGE: Verifying that we are on SHOPPING_CART_REVIEW_PAGE.");
        if (!url.contains("view")){
            throw new TestException("ERROR: Not on SHOPPING_CART_PAGE! URL: " + url);
        }
    }

    public String getShoppingCartMessage(){
        return getElementText(SHOPPING_CART_HEADER);
    }

    public boolean checkIfShoppingCartHeaderListsEmptyMessage(){
        String actualMessage = getShoppingCartMessage();
        return (actualMessage.equals(SHOPPING_CART_EMPTY_MSG));
    }

    public void deleteAllItemsInCart(){
        List<WebElement> deleteButtons =getElements(DELETE_BUTTONS);
        for (WebElement button : deleteButtons){
            button.click();
        }
    }


}
