package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.TC_001_page;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TC_001_steps {

    private WebDriver driver;
    TC_001_page registerPage;
    String generatedPassword;


    public TC_001_steps() {
        this.driver = Hooks.driver;
    }


    @Given("I am on Demo Web Shops Register page")
    public void I_am_on_Demo_Web_Shops_Register_page() {
        driver.get("https://demowebshop.tricentis.com/register");
        registerPage = new TC_001_page(driver);
    }

    @When("I enter first name")
    public void enterFirstName() {
        registerPage.enterFirstName("Test");
    }

    @When("I enter second name")
    public void EnterSecondName() {
        registerPage.enterLastName("User");
    }

    @When("I enter email")
    public void EnterEmail() {
        String email = TC_001_page.TestDataGenerator.generateRandomEmail();
        registerPage.enterEmail(email);
    }

    @When("I enter password")
    public void EnterPassword() {
        generatedPassword = TC_001_page.TestDataGenerator.generateRandomPassword(6);
        registerPage.enterPassword(generatedPassword);
    }

    @When("I enter the same confirmation password")
    public void EnterSameConfirmationPassword() {
        registerPage.enterConfirmPassword(generatedPassword);
    }

    @When("I click Register")
    public void ClickRegister() {
        registerPage.clickRegister();
    }

    @Then("I am navigated to confirmation page")
    public void iAmOnConfirmationPage() {
        assertEquals("https://demowebshop.tricentis.com/registerresult/1", driver.getCurrentUrl());
        assertTrue("Your registration completed",
                registerPage.isRegistrationSuccessMessageDisplayed());
    }


    }