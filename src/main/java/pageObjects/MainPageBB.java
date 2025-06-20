package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPageBB {
    @FindBy (how = How.CSS, using = "a[href='/customer/info']")
    private WebElement customerInfoHeaderButton;
    @FindBy(how = How.CSS, using = "a[href='/register']")
    private WebElement registerHeaderButton;
    @FindBy(how = How.CSS, using = "a[href='/login']")
    private WebElement loginHeaderButton;
    @FindBy(how = How.CSS, using = "a[href='/logout']")
    private WebElement logoutHeaderButton;
    @FindBy(how = How.CSS, using = ".header-links a[href='/wishlist']")
    private WebElement wishlistHeaderButton;
    @FindBy(how = How.CSS, using = "a[href='/news']")
    private WebElement newsFooterButton;
    @FindBy(how = How.CSS, using = "a[href='/blog']")
    private WebElement blogFooterButton;

    public String getPageUrl() {
        return "https://demowebshop.tricentis.com/";
    }

    public void clickCustomerInfoHeaderButton() {
        customerInfoHeaderButton.click();
    }

    public void clickRegisterHeaderButton() {
        registerHeaderButton.click();
    }

    public void clickLoginHeaderButton() {
        loginHeaderButton.click();
    }

    public WebElement getWishlistHeaderButton() {
        return wishlistHeaderButton;
    }

    public WebElement getLogoutHeaderButton() {
        return logoutHeaderButton;
    }

    public WebElement getNewsFooterButton() {
        return newsFooterButton;
    }

    public WebElement getBlogFooterButton() {
        return blogFooterButton;
    }

}
