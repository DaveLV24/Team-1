package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy (how = How.CSS, using = "a[href='/customer/info']")
    private WebElement customerInfoHeaderButton;
    @FindBy(how = How.CSS, using = "a[href='/login']")
    private WebElement loginHeaderButton;
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

    public void clickLoginHeaderButton() {
        loginHeaderButton.click();
    }

    public void clickWishlistHeaderButton() {
        wishlistHeaderButton.click();
    }

    public void clickNewsFooterButton() {
        newsFooterButton.click();
    }

    public void clickBlogFooterButton() {
        blogFooterButton.click();
    }

}
