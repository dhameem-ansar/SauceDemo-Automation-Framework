package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    // Step 1: Find username box, password box and login button on the page
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMsg = By.cssSelector(".error-message-container h3");

    // Step 2: Constructor - receive driver from StepDefinitions
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Step 3: Type username
    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    // Step 4: Type password
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    // Step 5: Click login button
    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    // Step 6: Check if error message is shown
    public boolean isErrorShown() {

        try {

            WebElement errorElement =
                    driver.findElement(errorMsg);

            System.out.println("Error Message: "
                    + errorElement.getText());

            return errorElement.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}


