import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profil {

    public static final WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Test
    public void goToBookStore() {
        driver.get("https://demoqa.com/profile");
        driver.findElement(By.linkText("login")).click();
        driver.manage().window().maximize();
        System.out.println("01. I will open login page");

        driver.findElement(By.id("userName")).sendKeys("Vukasinovicka");
        System.out.println("02. I will enter valid username");
        driver.findElement(By.id("password")).sendKeys("y$*m66iby2L4LtC");
        System.out.println("03. I will enter valid password");
        driver.findElement(By.id("login")).click();
        System.out.println("04. I will click login button ");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("delete-record-undefined")));

        driver.findElement(By.id("delete-record-undefined")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("closeSmallModal-ok")));
        driver.findElement(By.id("closeSmallModal-ok")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
    @Test
    public void test02() {
        driver.get("https://demoqa.com/profile");
        driver.findElement(By.linkText("login")).click();
        driver.manage().window().maximize();
        System.out.println("01. I will open login page");

        driver.findElement(By.id("userName")).sendKeys("Vukasinovicka");
        System.out.println("02. I will enter valid username");
        driver.findElement(By.id("password")).sendKeys("y$*m66iby2L4LtC");
        System.out.println("03. I will enter valid password");
        driver.findElement(By.id("login")).click();
        System.out.println("04. I will click login button ");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gotoStore")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gotoStore")));
        driver.findElement(By.id("gotoStore")).click();
    }

}
