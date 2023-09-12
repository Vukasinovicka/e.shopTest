import com.sun.org.apache.bcel.internal.generic.DUP2_X2;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    String url = "https://demoqa.com/text-box";

    @Test
    public void TextBox() {
        driver.get(url);
        driver.manage().window().maximize();
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Marijana");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("v.ana.95@hotmail.com");
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Lukovska");
        permanentAddress.sendKeys("\n");
        permanentAddress.sendKeys("Naselje 9.Maj");
        permanentAddress.sendKeys("\n");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }

    @Test
    public void CheckBox() {
        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize();
        WebElement checkBox = driver.findElement(By.cssSelector("span.rct-checkbox"));
        checkBox.isSelected();
        Assert.assertFalse(checkBox.isSelected());
        System.out.println(checkBox.isSelected());
        checkBox.click();
        String expectedMessage = "You have selected :\n" +
                "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" +
                "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" +
                "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile";

        WebElement activeMessage = driver.findElement(By.id("result"));
        activeMessage.getText();
        Assert.assertEquals(expectedMessage, activeMessage.getText());
        System.out.println(expectedMessage);
    }

    @Test
    public void RadioButton() {
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        WebElement yesRadioButton = driver.findElement(By.cssSelector("label.custom-control-label"));
        yesRadioButton.click();
        String expectedMessage = "Yes";
        WebElement activeMessage = driver.findElement(By.cssSelector("span.text-success"));
        Assert.assertEquals(expectedMessage, activeMessage.getText());
        System.out.println("You have selected " + activeMessage.getText());

    }

    @Test
    public void WebTables() {
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
        addButton.click();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Marijana");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Vukasinovic");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("v.ana.95@hotmail.com");
        WebElement age = driver.findElement(By.id("age"));
        age.sendKeys("28");
        WebElement salary = driver.findElement(By.id("salary"));
        salary.sendKeys("1850");
        WebElement department = driver.findElement(By.id("department"));
        department.sendKeys("Ledaly");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }

    @Test
    public void userCanNotSubmit() {
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
        addButton.click();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Marijana");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Vukasinovic");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("v.ana.95@hotmail.com");
        WebElement age = driver.findElement(By.id("age"));
        age.sendKeys("28");
        WebElement salary = driver.findElement(By.id("salary"));
        salary.sendKeys("1850");
        WebElement emptyFieldDepartment = driver.findElement(By.id("department"));
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        emptyFieldDepartment.getCssValue("border-color");
        String expectedBorderColor = "rgb(209, 175, 183)";
        Assert.assertEquals(expectedBorderColor, emptyFieldDepartment.getCssValue("border-color"));
        System.out.println("User can not submit");
    }

    @Test
    public void emptyEditForm() {
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("edit-record-1")));
        WebElement editButton = driver.findElement(By.id("edit-record-1"));
        editButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.clear();
        firstName.sendKeys();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }

    @Test
    public void Button() {
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickMe = driver.findElement(By.id("doubleClickBtn"));
        doubleClickMe.click();
        doubleClickMe.click();
    }

    @Test
    public void Link() {
        driver.get("https://demoqa.com/links");
        driver.manage().window().maximize();
        String firstWindowHandle = driver.getWindowHandle();
        WebElement homeLink = driver.findElement(By.linkText("Home"));
        homeLink.click();
    }

    @Test
    public void Link2() {
        driver.get("https://demoqa.com/links");
        driver.close();
        WebElement noContentLnk = driver.findElement(By.linkText("No Content"));
        noContentLnk.click();
        String expectedMessage = "Link has responded with staus 204 and status text No Content";
        WebElement activeMessage = driver.findElement(By.id("linkResponse"));
        Assert.assertEquals(expectedMessage, activeMessage.getText());
        System.out.println(expectedMessage);
    }
}
