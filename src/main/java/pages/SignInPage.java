package pages;

import org.openqa.selenium.By;
import utils.CommonUtils;

public class SignInPage extends CommonUtils {
    private final By EMAIL = By.cssSelector("#ap_email");
    private final By PASSWORD = By.cssSelector("#ap_password");
    private final By CONTINUE = By.xpath("//input[@id=\"continue\" and @class=\"a-button-input\"]");
    private final By SIGNIN_BUTTON = By.cssSelector("#signInSubmit");

    public void enterEmail(String email){
        System.out.println("SIGNIN_PAGE: Entering username: " + email);
        waitForElementToBeVisible(EMAIL);
        sendKeys(EMAIL, email);
    }

    public void clickContinueBtn(){
        System.out.println("SIGNIN_PAGE: Clicking the [CONTINUE] button.\n");
        click(CONTINUE);
    }

    public void enterPassword(String password){
        System.out.println("SIGNIN_PAGE: Entering username: " + password);
        waitForElementToBeVisible(PASSWORD);
        sendKeys(PASSWORD,password);
    }

    public void clickSignButton(){
        System.out.println("SIGNIN_PAGE: Clicking the [SIGN_IN] button.\n");
        click(SIGNIN_BUTTON);
        System.out.println(driver.getTitle());
    }


}
