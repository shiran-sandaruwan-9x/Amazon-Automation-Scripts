package tc;

import actions.OrderActions;
import base.LoadProperties;
import dto.Book;
import enums.Products;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ShoppingCartReviewPage;
import utils.DriverUtils;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class PurchaseOrderTest {
    public WebDriver driver;
    //private static OrderActions orderActions;
    private DriverUtils driverUtils;
    @BeforeClass
    public void setUp(){
        driver= driverUtils.getDriver();
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
    }

    @Test
    public void navigateToAmazon(){
       Products testBook = Products.HITCHHIKERS_GUIDE;
       OrderActions orderActions=new OrderActions();
       ShoppingCartReviewPage shoppingCartReviewPage = new ShoppingCartReviewPage();
       String email= LoadProperties.user.getProperty("tester23.username");
       String password= LoadProperties.user.getProperty("tester23.password");
       orderActions.navigateToHomePage();
       orderActions.loginAs(email,password);
       orderActions.initializeCart();
       Book bookProductPage = orderActions.loadProductPageDataIntoProductObject(testBook);
       orderActions.addProductToShoppingCartReview(testBook);

       //String expectedBookPrice = bookProductPage.getOfferPrice();
      // String actualCartSubtotalPrice =shoppingCartReviewPage.getCartSubtotal();
      // System.out.println("-------------------------------"+actualCartSubtotalPrice);
      // orderActions.checkMatchingValues("Verify the Price Listed for the book:", actualCartSubtotalPrice, expectedBookPrice);
      // assertEquals(actualCartSubtotalPrice, expectedBookPrice, "SHOPPING_CART_REVIEW: Cart Subtotal not what is expected!");
       orderActions.signOut();
    }

    @AfterClass
    public void tearDown(){

    }


}
