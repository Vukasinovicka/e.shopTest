import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Shopping {

    public static final WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,30);


    @Before
    public void login() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS93aXNobGlzdC9pbmRleC9hZGQv/");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("v.ana.95@hotmail.com");
        driver.findElement(By.id("pass")).sendKeys("Vuk@1504");
        driver.findElement(By.id("send2")).click();
    }
    //01.TC - Verify that user can add product to shopping cart
    @Test
    public void Test01() {

        driver.findElement(By.linkText("What's New")).click();
        driver.findElement(By.linkText("Bras & Tanks")).click();
        Select select = new Select(driver.findElement(By.id("sorter")));
        select.selectByValue("price");
        driver.findElement(By.linkText("Antonia Racer Tank")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("option-label-size-143-item-168")));
        driver.findElement(By.id("option-label-size-143-item-168")).click();
        driver.findElement(By.id("option-label-color-93-item-60")).click();
        driver.findElement(By.id("product-addtocart-button")).click();
        driver.findElement(By.cssSelector("span.counter-label")).isDisplayed();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-success.success.message")));
        driver.findElement(By.cssSelector("div.message-success.success.message")).isDisplayed();
        driver.findElement(By.linkText("shopping cart")).click();
    }
    //02.TC - Verify that user can edit selected product from shopping cart
    @Test
    public void Test02 () {
        driver.get("https://magento.softwaretestingboard.com/checkout/cart/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.action.action-edit")));
        driver.findElement(By.cssSelector("a.action.action-edit")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.swatch-option.text")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.swatch-option.color")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("qty")));
        driver.findElement(By.id("qty")).clear();
        driver.findElement(By.id("qty")).sendKeys("2");
        driver.findElement(By.id("product-updatecart-button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-success.success.message")));
        driver.findElement(By.cssSelector("div.message-success.success.message"));

    }
    // TC - Verify that user can not buy product if he doesn't choose a color
    @Test
    public void Test03(){


        driver.findElement(By.linkText("Men")).click();
        driver.findElement(By.linkText("Tops")).click();
        driver.findElement(By.linkText("Tiberius Gym Tank")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("option-label-size-143-item-167")));
        driver.findElement(By.id("option-label-size-143-item-167")).click();
        driver.findElement(By.id("product-addtocart-button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("super_attribute[93]-error")));
        driver.findElement(By.id("super_attribute[93]-error")).isDisplayed();

    }
    @Test
    public void Test04() {
        driver.findElement(By.linkText("Men")).click();
        driver.findElement(By.linkText("Tops")).click();
        driver.findElement(By.linkText("Tiberius Gym Tank")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("option-label-size-143-item-167")));
        driver.findElement(By.id("option-label-size-143-item-167")).click();
        driver.findElement(By.id("product-addtocart-button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("super_attribute[93]-error")));
        driver.findElement(By.id("super_attribute[93]-error")).isDisplayed();
        driver.findElement(By.cssSelector("a.action.towishlist")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-success.success.message")));
        driver.findElement(By.cssSelector("div.message-success.success.message")).isDisplayed();

    }
    //05.TC - Verify that user can not add from the my wish list to the shopping cart if he did not choose a color.
    @Test
    public void Test05() {
        driver.get("https://magento.softwaretestingboard.com/wishlist/index/index/wishlist_id/49853/");
        driver.findElement(By.xpath("//*[@id=\"wishlist-view-form\"]/div[2]/div[1]/button[3]/span")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-error.error.message")));
        driver.findElement(By.cssSelector("div.message-error.error.message")).isDisplayed();


    }


    // TC - Verify that user can add new product in Shopping Cart
    @Test
    public void Test06(){
        driver.get("https://magento.softwaretestingboard.com/checkout/cart/");
        driver.findElement((By.linkText("Affirm Water Bottle"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("product-addtocart-button")));
        driver.findElement(By.id("product-addtocart-button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("shopping cart")));
        driver.findElement(By.linkText("shopping cart")).click();
}
    // TC - Verify that user can delete thing he put in Shopping card
    @Test
    public void Test07() {
        driver.get("https://magento.softwaretestingboard.com/checkout/cart/");
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody[2]/tr[2]/td/div/a[3]")).click();

    }
    //08.TC - Verify that user can not get a discount if he submitted the wrong code.
    @Test
    public void Test08() {
        driver.get("https://magento.softwaretestingboard.com/checkout/cart/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("block-discount-heading")));
        driver.findElement(By.id("block-discount-heading")).click();
        driver.findElement(By.name("coupon_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("button.action.apply.primary")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-error.error.message")));
        driver.findElement(By.cssSelector("div.message-error.error.message")).isDisplayed();
    }
}








