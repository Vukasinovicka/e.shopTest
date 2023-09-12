import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    public static final WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,20);

    String firstNameField = "firstname";
    String lastNameField = "lastname";
    String userNameField = "userName";
    String passwordField = "password";
    String registerButton = "register";

    String firstName = "Marijana";
    String lastName = "Vukasinovic";
    String userName = "Vukasinovicka";
    String password = "y$*m66iby2L4LtC";
// TC - Verify that user can not regster if he submit empty password field
    @Test
    public void Test01() throws Exception {
        driver.get("https://demoqa.com/register");
        driver.manage().window().maximize();
        System.out.println("01. I will open register page");
        driver.findElement(By.id(firstNameField)).sendKeys(firstName);
        System.out.println("02. I will enter first name");
        driver.findElement(By.id(lastNameField)).sendKeys(lastName);
        System.out.println("03. I will enter last name");
        driver.findElement(By.id(userNameField)).sendKeys(userName);
        System.out.println("03. I will enter user name");


        driver.findElement(By.id(registerButton)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        driver.findElement(By.id(passwordField)).getCssValue("border-color");
        String expectedResults = driver.findElement(By.id(passwordField)).getCssValue("border-color");

        if(!driver.findElement(By.id(passwordField)).getCssValue("border-color").isEmpty()) {
            String activeResults = driver.findElement(By.id(passwordField)).getCssValue("border-color");
            Assert.assertEquals(expectedResults,activeResults);
        }else {
            throw new Exception("Error!");
        }
}
}
