import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Watchable;

public class AddressBook {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,10);

    @Test
    public void fillingOutAddressBook() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("v.ana.95@hotmail.com");
        System.out.println("02. I will enter valid email");
        driver.findElement(By.id("pass")).sendKeys("Vaki@1504");
        System.out.println("02. I will enter valid password");
        driver.findElement(By.id("send2")).click();
        System.out.println("03. I will click Sing In button");
        driver.findElement(By.linkText("Address Book")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.action.save.primary")));
        WebElement phoneNumber = driver.findElement(By.id("telephone"));
        phoneNumber.sendKeys("0656565656");
        WebElement streetAddress = driver.findElement(By.id("street_1"));
        streetAddress.sendKeys("Partzanska 14");
        WebElement sity = driver.findElement(By.name("city"));
        sity.sendKeys("Nis");
        WebElement selectElement = driver.findElement(By.id("region_id"));

        Select select = new Select(selectElement);
        select.selectByValue("57");

        WebElement postalCode = driver.findElement(By.id("zip"));
        postalCode.sendKeys("18250");

        WebElement country = driver.findElement(By.id("country"));
         Select select1 = new Select(country);
         select1.selectByValue("RS");

         WebElement saveAddress = driver.findElement(By.cssSelector("button.action.save.primary"));
         saveAddress.click();



    }

}
