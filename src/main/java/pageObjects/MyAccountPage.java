package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountPage {
    @FindBy(how = How.XPATH, using = "//*[@class='title']/*[text()='My account']")
    private WebElement myAccountTitle;
    @FindBy(how = How.CSS, using = ".listbox a[href='/customer/info']")
    private WebElement customerInfoSubMenu;
    @FindBy(how = How.CSS, using = ".listbox a[href='/customer/orders']")
    private WebElement ordersSubMenu;
    @FindBy(how = How.CSS, using = ".listbox a[href='/customer/downloadableproducts']")
    private WebElement downloadableProductsSubMenu;
    @FindBy(how = How.CSS, using = ".listbox a[href='/customer/rewardpoints']")
    private WebElement rewardPointsSubMenu;
    @FindBy(how = How.CSS, using = ".listbox a[href='/customer/changepassword']")
    private WebElement changePasswordSubMenu;

    public String getPageUrl() {
        return "https://demowebshop.tricentis.com/customer/info";
    }

    public void openCustomerInfoSubMenu() {
        customerInfoSubMenu.click();
    }

    public WebElement getMyAccountTitle() {
        return myAccountTitle;
    }

    public WebElement getCustomerInfoSubMenu() {
        return customerInfoSubMenu;
    }

    public WebElement getOrdersSubMenu() {
        return ordersSubMenu;
    }

    public  WebElement getDownloadableProductsSubMenu() {
        return downloadableProductsSubMenu;
    }

    public  WebElement getRewardPointsSubMenu() {
        return rewardPointsSubMenu;
    }

    public  WebElement getChangePasswordSubMenu() {
        return changePasswordSubMenu;
    }
}
