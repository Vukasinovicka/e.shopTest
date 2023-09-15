import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgetYourPassword {
     public static final WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,10);

    String envUrl = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2NyZWF0ZS8%2C/";

    String emailField ="email_address";

    String resetMyPasswordButton = "button.action.submit.primary";

    //01. TC - Verify that user can not restart password if he submit empty email
    @Test
    public void Test01() {
        driver.get(envUrl);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Forgot Your Password?")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(resetMyPasswordButton)));
        driver.findElement(By.cssSelector(resetMyPasswordButton)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address-error")));
        driver.findElement(By.id("email_address-error")).isDisplayed();
    }
    @Test
    public void Test02() {
        driver.get(envUrl);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Forgot Your Password?")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(resetMyPasswordButton)));
        driver.findElement(By.id(emailField)).sendKeys("v.ana.95@hotmail.com");
        driver.findElement(By.cssSelector(resetMyPasswordButton)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-success.success.message")));
        driver.findElement(By.cssSelector("div.message-success.success.message")).isDisplayed();


    }
}
