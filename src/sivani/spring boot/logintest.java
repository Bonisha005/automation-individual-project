package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.enterUsername("Admin");
        lp.enterPassword("admin123");
        lp.clickLogin();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"));
    }

    @Test
    public void invalidLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.enterUsername("Admin");
        lp.enterPassword("wrongpass");
        lp.clickLogin();

        String error = lp.getErrorMessage();
        Assert.assertEquals(error, "Invalid credentials");
    }

    @Test
    public void emptyCredentialsTest() {
        LoginPage lp = new LoginPage(driver);
        lp.clickLogin();

        String error = lp.getErrorMessage();
        Assert.assertTrue(error.contains("Required"));
    }
}
