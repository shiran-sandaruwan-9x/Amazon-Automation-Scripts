package pages;

import org.openqa.selenium.By;
import org.testng.TestException;
import utils.CommonUtils;

public class ShoppingCartReviewPage extends CommonUtils {
    private final By CART_BUTTON = By.cssSelector("#hlb-view-cart-announce");
    private final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("#hlb-ptc-btn-native");
    private final By PRICE = By.xpath("//span[@class='a-offscreen']");

    public void verifyOnShoppingCartReviewPage(){
        String url = getCurrentUrl();
        System.out.println("SHOPPING_CART_REVIEW_PAGE: Verifying that we are on SHOPPING_CART_REVIEW_PAGE.");
        if (!url.contains("view")){
            throw new TestException("ERROR: Not on SHOPPING_CART_REVIEW_PAGE! URL: " + url);
        }
    }

    public String getCartSubtotal(){
        return getElementText(PRICE);
    }

    public void clickProceedToCheckoutButton(){
        click(PROCEED_TO_CHECKOUT_BUTTON);
    }

    public void clickCartButton() {
        click(CART_BUTTON);
    }


}
