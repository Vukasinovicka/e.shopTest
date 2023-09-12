import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CostimerSignIN {
    public static final WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    String envUrl = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2ZvcmdvdHBhc3N3b3JkLw%2C%2C/";
    //Locators
    String emailField = "email";
    String passwordField = "pass";
    String signInButton = "send2";
    String errorMessage = "div.mage-error";
    //Test data
    String validEmail = "v.ana.95@hotmail.com";
    String wrongEmail = "m.vukasinovic1504@gmail.com";
    String validPassword = "Vaki@1504";
    String wrongPassword = "Vak@1504";

    @Before
    public void openSignUpPage() {
        driver.get(envUrl);
        driver.manage().window().maximize();
        System.out.println("01. I will open login page");
        wait.until(ExpectedConditions.elementToBeClickable(By.id(signInButton)));
    }

    //01. TC - Verify that user can not login if he submit empty mandatory fields
    @Test
    public void Test01() {
        driver.findElement(By.id(signInButton)).click();
        System.out.println("02. I will click Sign In button");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-error.error.message")));
        driver.findElement(By.cssSelector("div.message-error.error.message")).isDisplayed();
    }

    //02. TC - Verify that user can not login if he submit empty email field
    @Test
    public void Test02() throws Exception {
        driver.findElement(By.id(passwordField)).sendKeys(validPassword);
        System.out.println("02. I will enter valid password");
        driver.findElement(By.id(signInButton)).click();
        System.out.println("03. I will click Sing In button");
        String expectedErrorMessageInEmail = "This is a required field.";

        if (driver.findElement(By.id("email-error")).isDisplayed()) {
            String activeErrorMessage = driver.findElement(By.id("email-error")).getText();
            Assert.assertEquals(expectedErrorMessageInEmail, activeErrorMessage);
            System.out.println("User can not login");
        } else {
            throw new Exception("Error!");
        }
    }

    //03 TC - Verify that user can not login if he submit empty password field
    @Test
    public void Test03() throws Exception {
        driver.findElement(By.id(emailField)).sendKeys(validEmail);
        System.out.println("02. I will enter valid email");
        driver.findElement(By.id(signInButton)).click();
        System.out.println("03. I will click Sing In button");
        String expectedErrorMessageInPassword = "This is a required field.";

        if (driver.findElement(By.id("pass-error")).isDisplayed()) {
            String activeErrorMessage = driver.findElement(By.id("pass-error")).getText();
            Assert.assertEquals(expectedErrorMessageInPassword, activeErrorMessage);
            System.out.println("User can not login");
        } else {
            throw new Exception("Error!");
        }
    }
    // 04. TC - Verify that user can not login if he submit wrong user name and valid password
    @Test
    public void Test04() {
        driver.findElement(By.id(emailField)).sendKeys(wrongEmail);
        System.out.println("02. I will enter wrong email");
        driver.findElement(By.id(passwordField)).sendKeys(validPassword);
        System.out.println("02. I will enter valid password");
        driver.findElement(By.id(signInButton)).click();
        System.out.println("03. I will click Sing In button");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-error.error.message")));
        driver.findElement(By.cssSelector("div.message-error.error.message")).isDisplayed();
        System.out.println("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
}
    // 05. TC - Verify that user can not login uf he submit wrong password and valid email
    @Test
    public void Test05() {
        driver.findElement(By.id(emailField)).sendKeys(validEmail);
        System.out.println("02. I will enter valid email");
        driver.findElement(By.id(passwordField)).sendKeys(wrongPassword);
        System.out.println("03. I will enter wrong password");
        driver.findElement(By.id(signInButton)).click();
        System.out.println("03. I will click Sing In button");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-error.error.message")));
        driver.findElement(By.cssSelector("div.message-error.error.message")).isDisplayed();
        System.out.println("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
    }
    //06. TC - Verify that user can not login if he submit wrong email and password
    @Test
    public void Test06() {
        driver.findElement(By.id(emailField)).sendKeys(wrongEmail);
        System.out.println("02. I will enter wrong email");
        driver.findElement(By.id(passwordField)).sendKeys(wrongPassword);
        System.out.println("03. I will enter wrong password");
        driver.findElement(By.id(signInButton)).click();
        System.out.println("03. I will click Sing In button");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-error.error.message")));
        driver.findElement(By.cssSelector("div.message-error.error.message")).isDisplayed();
        System.out.println("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
    }
    @Test
    public void Test07(){
        driver.findElement(By.id(emailField)).sendKeys(validEmail);
        System.out.println("02. I will enter valid email");
        driver.findElement(By.id(passwordField)).sendKeys(validPassword);
        System.out.println("02. I will enter valid password");
        driver.findElement(By.id(signInButton)).click();
        System.out.println("03. I will click Sing In button");

    }

    }

