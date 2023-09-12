import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Forma {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    String url = "https://demoqa.com/automation-practice-form";

    @Test
    public void formPage() {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        WebElement nameField = driver.findElement(By.id("firstName"));
        nameField.sendKeys("Lazar");
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys("Lazic");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("l.layic95@gmail.com");
        WebElement gender = driver.findElement(By.cssSelector("label.custom-control-label"));
        gender.click();
        WebElement mobile = driver.findElement(By.id("userNumber"));
        mobile.sendKeys("064565678");
        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.clear();
        dateOfBirth.sendKeys("8 Sep 2023");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Lukovska" + "\n" + "Naselje 9.maj");


    }
}


