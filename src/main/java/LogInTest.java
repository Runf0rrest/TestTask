import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
    This test case is important because it shows possibility of further testing of features
    that depend on User's rights
 */

public class LogInTest {
    private WebDriver driver;
    private String Email = "pechenkkin@gmail.com";
    private String Password = "";

    @Before
    public void initDriver() {
        this.driver = new FirefoxDriver();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void testLogInFlow() {
        driver.get("https://dou.ua/");

        driver.findElement(By.cssSelector("#login-link")).click();
        driver.findElement(By.id("_loginByMail")).click();

        driver.findElement(By.name("username")).sendKeys(Email);
        driver.findElement(By.name("password")).sendKeys(Password);
        driver.findElement(By.cssSelector(".big-button.btnSubmit")).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".min-profile")));
        driver.findElement(By.cssSelector(".min-profile")).click();

        driver.findElement(By.linkText("Logout")).click();
    }
}

