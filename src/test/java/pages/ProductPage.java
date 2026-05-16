package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

    public class ProductPage {

        WebDriver driver;

        // Find elements on products page
        By pageTitle   = By.className("title");
        By addToCart   = By.cssSelector(".btn_primary.btn_inventory");
        By removeBtn   = By.cssSelector(".btn_secondary.btn_inventory");
        By cartCount   = By.className("shopping_cart_badge");
        By menuBtn     = By.id("react-burger-menu-btn");
        By logoutBtn   = By.id("logout_sidebar_link");
        By loginBtn    = By.id("login-button");

        public ProductPage(WebDriver driver) {
            this.driver = driver;
        }

        // Check if Products page is open
        public boolean isProductsPageOpen() {
            try {
                return driver.findElement(pageTitle).getText().equals("Products");
            } catch (Exception e) {
                return false;
            }
        }

        // Click Add to Cart button
        public void addProduct() {
            List<WebElement> buttons = driver.findElements(addToCart);
            buttons.get(0).click();
        }

        // Click Remove button
        public void removeProduct() {
            List<WebElement> buttons = driver.findElements(removeBtn);
            buttons.get(0).click();
        }

        // Get cart number
        public String getCartCount() {
            try {
                return driver.findElement(cartCount).getText();
            } catch (Exception e) {
                return "0";
            }
        }

        // Check if cart is empty
        public boolean isCartEmpty() {
            try {
                driver.findElement(cartCount);
                return false;
            } catch (Exception e) {
                return true;
            }
        }

        // Click menu
        public void clickMenu() {
            driver.findElement(menuBtn).click();
        }

        // Click logout
        public void clickLogout() throws InterruptedException {
            Thread.sleep(500);
            driver.findElement(logoutBtn).click();
        }

        // Check if login page is shown
        public boolean isLoginPageShown() {
            try {
                return driver.findElement(loginBtn).isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }
    }
