import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertBrowserFrames {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,10);

    @Test
    public void AlertBoxes (){
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.findElement(By.id("alertButton")).click();
        Alert alert  = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.id("confirmButton")).click();
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.dismiss();
        System.out.println(driver.findElement(By.id("confirmResult")).getText());
    }
    @Test
    public void BrowserWindows (){
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();
        System.out.println("1-" + driver.getWindowHandle());
        System.out.println("2-" + driver.getWindowHandles());
    }
    @Test
    public void findWindowsOfSecondHandle() {
        driver.get("https://demoqa.com/browser-windows");
        String firstWindowsHandle = driver.getWindowHandle();
        driver.findElement(By.id("tabButton")).click();

        String secondWindowsHandle = getSecondWindowsHandle(firstWindowsHandle);
        System.out.println(secondWindowsHandle);
        driver.switchTo().window(secondWindowsHandle);
        driver.close();
    }

    private String getSecondWindowsHandle(String firstWindowsHandle) {
        String secondWindowsHandle = null;

        for(String handle: driver.getWindowHandles()) {
            if (!firstWindowsHandle.equals(handle)){
                secondWindowsHandle = handle;
            }
        }
        return secondWindowsHandle;
    }

    @Test
    public void errorField (){
        driver.get("https://demoqa.com/register");
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("Marijana");
        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Vukasinovic");
        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("v.ana.95@hotmail.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("y$*m66iby2L4LtC");
        WebElement iAmNotRobot = driver.findElement(By.id("g-recaptcha"));
        iAmNotRobot.click();
        WebElement registerButton = driver.findElement(By.id("register"));
        registerButton.click();


    }




}
