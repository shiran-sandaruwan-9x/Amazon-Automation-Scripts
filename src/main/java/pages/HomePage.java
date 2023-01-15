package pages;

import enums.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

public class HomePage extends CommonUtils {
    private final By YOUR_ACCOUNT= By.cssSelector("#nav-link-accountList");
    private final By SHOPPING_CART_COUNT=By.xpath("//*[@id=\"nav-cart-count\"]");
    private final By SHOPPING_CART_ICON= By.xpath("//*[@id=\"nav-cart\"]");

    public HomePage() {
    }

    public void navigateToHomePage() {
        String url= Url.BASEURL.getUrl();
        System.out.println("Navigating to Amazon.com: "+url);
        navigateToUrl(url);
    }

    public void navigateToSignInPage(){
        System.out.println("HOME_PAGE: Selecting [YOUR_ACCOUNT] in navigation bar.");
        scrollToThenClick(YOUR_ACCOUNT);
        System.out.println("HOME_PAGE: Navigating to the SIGNIN_PAGE.\n");
    }

    public void signOutWithSignOutLink(){
        String url=Url.BASEURL.getUrl()+Url.SIGNOUT.getUrl();
        navigateToUrl(url);
    }

    public void selectShoppingCartIcon(){
        click(SHOPPING_CART_ICON);
    }

    public String getNumberOfItemsListedInShoppingCartIcon(){
        return getElementText(SHOPPING_CART_COUNT);
    }

}
