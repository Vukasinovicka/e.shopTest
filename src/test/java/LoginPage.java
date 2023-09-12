import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public static final WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,10);
    // 01. TC- Verify that user can not login if he submit empty mandatory fields.
    @Test
    public void Test01() throws  Exception {
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
        System.out.println("01. I will open login page");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
        driver.findElement(By.id("login")).click();
        System.out.println("02. I will click login button");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userName")));
        WebElement emptyFirstName = driver.findElement(By.id("userName"));
        String errormessage =  emptyFirstName.getCssValue("border-color");

        if(!emptyFirstName.getCssValue("border-color").isEmpty()) {
            String acErrorMessage = emptyFirstName.getCssValue("border-color");
            Assert.assertEquals(errormessage,acErrorMessage);
            System.out.println("User can not login");
        }else{
            throw new Exception("error");
        }
    }
    //02.TC - Verify that user can not login if he submit empty password
    @Test
    public void Test02() throws Exception{
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
        System.out.println("01.I will open a login page");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
        WebElement userNameFilds = driver.findElement(By.id("userName"));
        userNameFilds.sendKeys("Vukasnovicka");
        System.out.println("02.I will enter username ");
        driver.findElement(By.id("login")).click();
        System.out.println("03.I will click login button");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        WebElement emptyPasswordField = driver.findElement(By.id("password"));
        String errorMessage = emptyPasswordField.getCssValue("border-color");

        if(!emptyPasswordField.getCssValue("border-color").isEmpty()) {
            String activeMessage = emptyPasswordField.getCssValue("border-color");
            Assert.assertEquals(activeMessage,errorMessage);
            System.out.println("Verify that user can not login and he will see proper messsage");
        }else {
            throw new Exception("Error! User can not see proper message");
        }
    }
    //03.TC - Verify that user can not login if he submit valid username and wrong password
    @Test
    public void Test03() throws  Exception{
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
        System.out.println("01.I will open login page");
        WebElement userNameField = driver.findElement(By.id("userName"));
        userNameField.sendKeys("Vukasnovicka");
        System.out.println("02.I will ender valid username");
        WebElement wrongPasswordField = driver.findElement(By.id("password"));
        wrongPasswordField.sendKeys("12345");
        System.out.println("03. I will enter wrong password");
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        System.out.println("04.I will click login button ");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        String expectedErrorMessage = "Invalid username or password!";

        if(driver.findElement(By.id("name")).isDisplayed()) {
            String activeErrorMessage = driver.findElement(By.id("name")).getText();
            Assert.assertEquals(expectedErrorMessage,activeErrorMessage);
            System.out.println("Verify that user can not login");
        }else {
            throw new Exception("Error! Mesage is not present");

        }

    }
    //04.TC - Verify that user can not register if he submit empty username
    @Test
    public void Test04() throws Exception {
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
        System.out.println("01.I will open login page");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("y$*m66iby2L4LtC");
        System.out.println("02.I will enter valid password");
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        System.out.println("04.I will click login button");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userName")));
        WebElement emptyUserNameField = driver.findElement(By.id("userName"));
        String expectedErrorMessage = emptyUserNameField.getCssValue("border-color");

        if (!emptyUserNameField.getCssValue("border-color").isEmpty()) {
            String activeError = emptyUserNameField.getCssValue("border-color");
            Assert.assertEquals(expectedErrorMessage,activeError);
            System.out.println("Verify that user can not login");
        }else {
            throw new Exception("Error! Message is not present");
        }
    }
}
