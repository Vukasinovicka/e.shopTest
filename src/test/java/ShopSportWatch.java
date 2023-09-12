import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopSportWatch {

    public static final WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,10);

    @Test
    public void shopWatch() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.action.action-edit")));
        driver.findElement(By.cssSelector("a.action.action-edit")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("qty")));
        driver.findElement(By.id("qty")).clear();
        driver.findElement(By.id("qty")).sendKeys("4");
        driver.findElement(By.id("product-updatecart-button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-success.success.message")));
        driver.findElement(By.cssSelector("div.message-success.success.message"));



    }
}
