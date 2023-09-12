import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountInformation {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,10);

    @Test
    public void editAccountInformation() {
        driver.get("https://magento.softwaretestingboard.com/customer/address/new/");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("v.ana.95@hotmail.com");
        System.out.println("02. I will enter valid email");
        driver.findElement(By.id("pass")).sendKeys("Vaki@1504");
        System.out.println("02. I will enter valid password");
        driver.findElement(By.id("send2")).click();
        System.out.println("03. I will click Sing In button");
        driver.findElement(By.linkText("Account Information")).click();

        WebElement changePassword = driver.findElement(By.id("change-password"));
        changePassword.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("current-password")));
        driver.findElement(By.id("current-password")).sendKeys("Vaki@1504");
        WebElement newPassword = driver.findElement(By.id("password"));
        newPassword.sendKeys("Vuk@1504");

        WebElement confirmNewPassword = driver.findElement(By.id("password-confirmation"));
        confirmNewPassword.sendKeys("Vuk@1504");

        WebElement saveButton = driver.findElement(By.cssSelector("button.action.save.primary"));
        saveButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-success.success.message")));
        driver.findElement(By.cssSelector("div.message-success.success.message")).isDisplayed();


    }
}
