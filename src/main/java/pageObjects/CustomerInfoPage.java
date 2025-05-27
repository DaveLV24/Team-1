package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CustomerInfoPage extends MyAccountPage {
    @FindBy(how = How.ID, using = "FirstName")
    private WebElement firstNameInput;
    @FindBy(how = How.ID, using = "LastName")
    private WebElement lastNameInput;
    @FindBy(how = How.ID, using = "Email")
    private WebElement emailInput;

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }
}
