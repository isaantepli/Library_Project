package com.library.stepDefinitions;

import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtilities;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on library login page")
    public void user_is_on_library_login_page() {
        String libraryUrl = ConfigurationReader.getProperty("libraryUrl");
        Driver.getDriver().get(libraryUrl);
    }


    @When("user enters {string} valid credentials")
    public void user_enters_valid_credentials(String string) {
        loginPage.login(string);
        BrowserUtilities.wait(2);
    }

    @Then("user should land on Library Home Page")
    public void user_should_land_on_library_home_page() {
        String expectedUrl = "http://library2.cybertekschool.com/#dashboard";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("Url Verification Failed!", expectedUrl, actualUrl);

        Driver.closeDriver();
    }


}
