package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductPage;

import java.time.Duration;

public class Stepdefinition {

    WebDriver driver;
    LoginPage loginPage;
    ProductPage productsPage;

    // Opens Chrome browser before each test
    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductPage(driver);
    }

    // Closes Chrome browser after each test
    @After
    public void closeBrowser() {
        driver.quit();
    }

    // Open SauceDemo website
    @Given("the user is on the SauceDemo login page")
    public void openWebsite() {
        driver.get("https://www.saucedemo.com");
    }

    // Type username and password
    @When("the user enters username {string} and password {string}")
    public void enterCredentials(String user, String pass) {
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
    }

    // Click login button
    @When("the user clicks the login button")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    // Check products page opened
    @Then("the user should be redirected to the products page")
    public void checkProductsPage() {
        Assert.assertTrue(productsPage.isProductsPageOpen());
    }

    // Check error message shown
    @Then("an error message should be displayed")
    public void checkErrorMessage() {
        Assert.assertTrue(loginPage.isErrorShown());
    }

    // Add product to cart
    @When("the user adds the first product to the cart")
    public void addProduct() {
        productsPage.addProduct();
    }

    // Check cart count
    @Then("the cart count should be {string}")
    public void checkCartCount(String count) {
        Assert.assertEquals(productsPage.getCartCount(), count);
    }

    // Remove product from cart
    @When("the user removes the product from the cart")
    public void removeProduct() {
        productsPage.removeProduct();
    }

    // Check cart is empty
    @Then("the cart should be empty")
    public void checkCartEmpty() {
        Assert.assertTrue(productsPage.isCartEmpty());
    }

    // Click menu button
    @When("the user clicks on the menu button")
    public void clickMenu() {
        productsPage.clickMenu();
    }

    // Click logout
    @When("the user clicks on logout")
    public void clickLogout() throws InterruptedException {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("logout_sidebar_link")
                )
        ).click();
    }

    // Check login page shown after logout
    @Then("the user should be redirected to the login page")
    public void checkLoginPage() {
        boolean loginButtonDisplayed =
                driver.findElement(By.id("login-button")).isDisplayed();

        Assert.assertTrue(loginButtonDisplayed);
    }
}