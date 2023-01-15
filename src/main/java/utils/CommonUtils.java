package utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import java.time.Duration;

import java.util.List;
import java.util.concurrent.TimeUnit;


public abstract class CommonUtils {

    private final int timeout=10;



    public CommonUtils() {
        driver=DriverUtils.getDriver();
    }
    public static WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
//-------------- navigation ann tittle -----------------------

    public void navigateToUrl(String url){
        try {
            driver.navigate().to(url);
        }catch (Exception e){
            System.out.println("FAILURE: URL did not load: " + url);
            throw new TestException("URL did not load");
        }
    }

    public void navigateBack(){
        try {
            driver.navigate().back();
        }catch (Exception e){
            System.out.println("FAILURE: Could not navigate back to previous page.");
            throw new TestException("Could not navigate back to previous page.");
        }
    }

    public String pageTittle(){
        try {
           return driver.getTitle();
        }catch (Exception e){
            throw new TestException(String.format("Current page title is: %s", driver.getTitle()));
        }
    }

    public String getCurrentUrl(){
        try {
            return driver.getCurrentUrl();
        }catch (Exception e){
            throw new TestException(String.format("Current URl is: %s", driver.getCurrentUrl()));
        }
    }

//--------------------- Element / Send Key --------------------------

    public WebElement getElement(By selector){
        try {
            return driver.findElement(selector);
        }catch (Exception e){
            throw new TestException(String.format("Element %s does not exist - proceeding", selector));
        }
    }

    public List<WebElement> getElements(By Selector) {
        waitForElementToBeVisible(Selector);
        try {
            return driver.findElements(Selector);
        } catch (Exception e) {
            throw new NoSuchElementException(String.format("The following element did not display: [%s] ", Selector.toString()));
        }
    }

    public void sendKeys(By selector,String value){
        WebElement element=getElement(selector);
        clearField(element);
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            throw new TestException(String.format("Error in sending [%s] to the following element: [%s]", value, selector.toString()));
        }
    }

    public void waitForElementTextToBeEmpty(WebElement element){
        String text;
        try {
            text = element.getText();
            int maxRetries = 10;
            int retry = 0;
            while ((text.length() >= 1) || (retry < maxRetries)) {
                retry++;
                text = element.getText();
            }
        }catch (Exception e){
            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
        }
        }


    public void clearField(WebElement element){
        try {
            element.clear();
            waitForElementTextToBeEmpty(element);
        }catch (Exception e){
            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
        }
    }



//--------------------- button click -------------------------------------

    public void waitForElementToBeClickable(By selector){
        try {
            WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.elementToBeClickable(selector));
        } catch (Exception e) {
            throw new TestException("The following element is not clickable: " + selector);
        }
    }

    public void click(By selector){
        WebElement element=getElement(selector);
        waitForElementToBeClickable(selector);
        try {
            element.click();
        }catch (Exception e){
            throw new TestException(String.format("The following element is not clickable: [%s]", selector));
        }
    }

    public void sleep(final long millis) {
        System.out.println((String.format("sleeping %d ms", millis)));
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

//--------------------- visible ---------

     public void waitForElementToBeVisible(By selector){
         try {
             wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
             wait.until(ExpectedConditions.presenceOfElementLocated(selector));
         } catch (Exception e) {
             throw new NoSuchElementException(String.format("The following element was not visible: %s", selector));
         }
     }

//------------- scrollToThenClick ---------------------

    public void scrollToThenClick(By selector){
        WebElement element=getElement(selector);
        actions=new Actions(driver);

        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            actions.moveToElement(element).perform();
            actions.click(element).perform();
        } catch (Exception e) {
            throw new TestException(String.format("The following element is not clickable: [%s]", element.toString()));
        }


    }

    public String getElementText(By selector){
      waitUntilElementIsDisplayedOnScreen(selector);
      try{
          return StringUtils.trim(driver.findElement(selector).getText());
      }catch (Exception e){
          System.out.println(String.format("Element %s does not exist - proceeding", selector));
      }
      return null;
    }

    public void waitUntilElementIsDisplayedOnScreen(By selector){
        try{
           wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
           wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        }catch (Exception e){
            throw new NoSuchElementException(String.format("The following element was not visible: %s ", selector));
        }
    }


}
