package pages;

import dto.Book;
import enums.Products;
import enums.Url;
import org.openqa.selenium.By;
import org.testng.TestException;
import utils.CommonUtils;

public class ProductPage extends CommonUtils {
    private final By PRODUCT_TITLE=By.xpath("//span[@id=\"productTitle\"]");
    private final By PRICE=By.xpath("//span[@id=\"usedPrice\"]");
    private final By AUTHOR=By.xpath("//*[@id=\"bylineInfo\"]/span/span[1]/a[1]");
    private final By EDITION = By.xpath("//*[@id=\"productSubtitle\"]");
    private final By ADD_TO_CART = By.cssSelector("#add-to-cart-button");

    private Book book;

    public void navigateToProductPage(Products products){
        String url = Url.BASEURL.getUrl() + Url.PRODUCT_SECTION.getUrl() + "/" + products.getId();
        navigateToUrl(url);
        System.out.println("PRODUCT_PAGE: Navigated to " + url);
    }

    public void verifyProductTitle(String expectedTitle){
        String actualTitle =getProductTitle();
        System.out.println("PRODUCT_PAGE: Verifying that the product title is '" + actualTitle + "'");
        if (!expectedTitle.equals(actualTitle)){
            throw new TestException("ERROR: PRODUCT_PAGE: Product Title is ['" + actualTitle + "']. Expected ['" + expectedTitle + "'].");
        }
    }

    public Book loadInfoFromProductPage() {
        ProductPage productPage = new ProductPage();
        String currentURL = productPage.getCurrentUrl();
        book=new Book();
        if (!currentURL.contains("product")) {
            throw new TestException("LOAD INFO ERROR: Product data should only be loaded from product page!\nCurrent URL: " + currentURL);
        } else {
            System.out.println("LOAD_INFO: Loading data...\n");
            book.setProductTitle(productPage.getProductTitle());
            book.setAuthor(productPage.getAuthor());
            book.setOfferPrice(productPage.getPrice());
            book.setEdition(productPage.getEdition());
        }
        return book;
    }


    public String getProductTitle(){
        return getElementText(PRODUCT_TITLE);
    }

    public String getAuthor(){
        return getElementText(AUTHOR);
    }

    public String getEdition(){
        return getElementText(EDITION);
    }

    public String getPrice(){
        return getElementText(PRICE);
    }

    public void clickAddToCart(){
        System.out.println("PRODUCT_PAGE: Clicking on [ADD_TO_CART] button. \n");
        click(ADD_TO_CART);
    }



    }
