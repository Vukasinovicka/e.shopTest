import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CostimerSignUp {
    public static final WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    String envUrl = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
    // Locators
    String firstNameField = "firstname";
    String lastNameField = "lastname";
    String emailField = "email_address";
    String passwordField = "password";
    String passwordConfirmationField = "password-confirmation";
    String createAnAccountButton = "div.primary";
    String errorMessage = "div.mage-error";

    //Test data
    String firstName = "Marijana";
    String lastName = "Vukasinovic";
    String email = "v.ana.95@hotmail.com";
    String password = "Vaki@1504";

    String confirmationPassword = "Vaki@1504";
    String wrongConfirmationPassword = "Vakki@1504";


    @Before
    public void openRegisterpage() {
        driver.get(envUrl);
        driver.manage().window().maximize();
        System.out.println("01. I will open Sing up page");
        driver.findElement(By.linkText("Create an Account")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(createAnAccountButton)));
    }

    //01. TC - Verify that user can not create account if he submit empty mandatory felds.
    @Test
    public void Test01() {
        driver.findElement(By.cssSelector(createAnAccountButton)).click();
        driver.findElement(By.cssSelector(errorMessage)).isDisplayed();
    }

    @Test
    public void Test02() throws Exception {
        driver.findElement(By.id(lastNameField)).sendKeys(lastName);
        System.out.println("02. I will enter Last Name");
        driver.findElement(By.id(emailField)).sendKeys(email);
        System.out.println("03. I will enter Email");
        driver.findElement(By.id(passwordField)).sendKeys(password);
        System.out.println("04. I will enter Password");
        driver.findElement(By.id(passwordConfirmationField)).sendKeys(confirmationPassword);
        System.out.println("05. I will enter Confirmation Password");
        driver.findElement(By.cssSelector(createAnAccountButton)).click();
        System.out.println("06. I will click Create an Account button ");
        String expectedErrorMessageInFullName = "This is a required field.";
        driver.findElement(By.id("firstname-error"));

        if (driver.findElement(By.id("firstname-error")).isDisplayed()) {
            String activeErrorMessageInFullName = driver.findElement(By.id("firstname-error")).getText();
            Assert.assertEquals(expectedErrorMessageInFullName, activeErrorMessageInFullName);
            System.out.println("User can not create account and he will see proper message under First Name field" +
                    " " + "'This is a required field.' ");
        } else {
            throw new Exception("Error!");
        }
    }

    //03. TC - Verify that user can not create account if he submit empty Last Name
    @Test
    public void Test03() throws Exception {
        driver.findElement(By.id(firstNameField)).sendKeys(firstName);
        System.out.println("02. I will enter First Name");
        driver.findElement(By.id(emailField)).sendKeys(email);
        System.out.println("03. I will enter Email");
        driver.findElement(By.id(passwordField)).sendKeys(password);
        System.out.println("04. I will enter Password");
        driver.findElement(By.id(passwordConfirmationField)).sendKeys(confirmationPassword);
        System.out.println("05. I will enter Confirmation Password");
        driver.findElement(By.cssSelector(createAnAccountButton)).click();
        System.out.println("06. I will click Create an Account button ");
        String expectedErrorMessageInLastName = "This is a required field.";

        if (driver.findElement(By.id("lastname-error")).isDisplayed()) {
            String activeErrorMessagInLastName = driver.findElement(By.id("lastname-error")).getText();
            Assert.assertEquals(expectedErrorMessageInLastName, activeErrorMessagInLastName);
            System.out.println("User can not create account and he will see proper message under Last Name field" +
                    " " + "'This is a required field.' ");
        } else {
            throw new Exception("Error!");
        }
    }

    @Test
    public void Test04() throws Exception {
        driver.findElement(By.id(firstNameField)).sendKeys(firstName);
        System.out.println("02. I will enter First Name");
        driver.findElement(By.id(lastNameField)).sendKeys(lastName);
        System.out.println("03. I will enter Last Name");
        driver.findElement(By.id(passwordField)).sendKeys(password);
        System.out.println("04. I will enter Password");
        driver.findElement(By.id(passwordConfirmationField)).sendKeys(confirmationPassword);
        System.out.println("05. I will enter Confirmation Password");
        driver.findElement(By.cssSelector(createAnAccountButton)).click();
        System.out.println("06. I will click Create an Account button ");
        String expectedErrorMessageInEmailField = "This is a required field.";

        if (driver.findElement(By.id("email_address-error")).isDisplayed()) {
            String activeErrorMessagInEmail = driver.findElement(By.id("email_address-error")).getText();
            Assert.assertEquals(expectedErrorMessageInEmailField, activeErrorMessagInEmail);
            System.out.println("User can not create account and he will see proper message under Email field" +
                    " " + "'This is a required field.' ");
        } else {
            throw new Exception("Error!");
        }
    }

    @Test
    public void Test05() throws Exception {
        driver.findElement(By.id(firstNameField)).sendKeys(firstName);
        System.out.println("02. I will enter First Name");
        driver.findElement(By.id(lastNameField)).sendKeys(lastName);
        System.out.println("03. I will enter Last Name");
        driver.findElement(By.id(emailField)).sendKeys(email);
        System.out.println("04. I will enter Email");
        driver.findElement(By.id(passwordConfirmationField)).sendKeys(confirmationPassword);
        System.out.println("05. I will enter Confirmation Password");
        driver.findElement(By.cssSelector(createAnAccountButton)).click();
        System.out.println("06. I will click Create an Account button ");
        String expectedErrorMessageInPaswordField = "This is a required field.";

        if (driver.findElement(By.id("password-error")).isDisplayed()) {
            String activeErrorMessagInPassword = driver.findElement(By.id("password-error")).getText();
            Assert.assertEquals(expectedErrorMessageInPaswordField, activeErrorMessagInPassword);
            System.out.println("User can not create account and he will see proper message under Password field" +
                    " " + "'This is a required field.' ");
        } else {
            throw new Exception("Error!");
        }
        driver.findElement(By.id("password-confirmation-error")).isDisplayed();
    }

    // 06. TC - Verify that user can not create account if he submit empty password field
    @Test
    public void Test06() throws Exception {
        driver.findElement(By.id(firstNameField)).sendKeys(firstName);
        System.out.println("02. I will enter First Name");
        driver.findElement(By.id(lastNameField)).sendKeys(lastName);
        System.out.println("03. I will enter Last Name");
        driver.findElement(By.id(emailField)).sendKeys(email);
        System.out.println("04. I will enter Email");
        driver.findElement(By.id(passwordField)).sendKeys(password);
        System.out.println("05. I will enter Password");
        driver.findElement(By.cssSelector(createAnAccountButton)).click();
        System.out.println("06. I will click Create an Account button ");
        String expectedErrorMessageInConfirmationField = "This is a required field.";

        if (driver.findElement(By.id("password-confirmation-error")).isDisplayed()) {
            String activeErrorMessagInConfirmationPassword = driver.findElement(By.id("password-confirmation-error")).getText();
            Assert.assertEquals(expectedErrorMessageInConfirmationField, activeErrorMessagInConfirmationPassword);
            System.out.println("User can not create account and he will see proper message under Confirmation Password field" +
                    " " + "'This is a required field.' ");
        } else {
            throw new Exception("Error!");
        }
    }
    //07. TC - Verify that user can not create account if he submit wrong conformation password
    @Test
    public void Test07() throws Exception {
        driver.findElement(By.id(firstNameField)).sendKeys(firstName);
        System.out.println("02. I will enter First Name");
        driver.findElement(By.id(lastNameField)).sendKeys(lastName);
        System.out.println("03. I will enter Last Name");
        driver.findElement(By.id(emailField)).sendKeys(email);
        System.out.println("04. I will enter Email");
        driver.findElement(By.id(passwordField)).sendKeys(password);
        System.out.println("05. I will enter Password");
        driver.findElement(By.cssSelector(createAnAccountButton)).click();
        driver.findElement(By.id(passwordConfirmationField)).sendKeys(wrongConfirmationPassword);
        System.out.println("06. I will enter Confirmation Password");
        driver.findElement(By.cssSelector(createAnAccountButton)).click();
        System.out.println("07. I will click Create an Account button ");
        String exErrorMessageInConfrmationPassword = "Please enter the same value again.";

        if (driver.findElement(By.id("password-confirmation-error")).isDisplayed()) {
            String activeErrorMessagInConfirmationPassword = driver.findElement(By.id("password-confirmation-error")).getText();
            Assert.assertEquals(exErrorMessageInConfrmationPassword, activeErrorMessagInConfirmationPassword);
            System.out.println("User can not create account and he will see proper message under Confirmation Password field" +
                    " " + "'This is a required field.' ");
        } else {
            throw new Exception("Error!");
        }
    }
    //08. TC - Verify that user can create account
    @Test
    public void Test08() {
        driver.findElement(By.id(firstNameField)).sendKeys(firstName);
        System.out.println("02. I will enter First Name");
        driver.findElement(By.id(lastNameField)).sendKeys(lastName);
        System.out.println("03. I will enter Last Name");
        driver.findElement(By.id(emailField)).sendKeys(email);
        System.out.println("04. I will enter Email");
        driver.findElement(By.id(passwordField)).sendKeys(password);
        System.out.println("05. I will enter Password");
        driver.findElement(By.cssSelector(createAnAccountButton)).click();
        driver.findElement(By.id(passwordConfirmationField)).sendKeys(confirmationPassword);
        System.out.println("06. I will enter Confirmation Password");
        driver.findElement(By.cssSelector(createAnAccountButton)).click();
        System.out.println("07. I will click Create an Account button ");
    }
}