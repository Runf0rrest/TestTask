import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
    This test case is important because it gives opportunity to check if main elements of Calendar Page
    are displayed and all links to another pages with features to be tested are valid.
 */


public class CalendarPageTest {
    private WebDriver driver;

    @Before
    public void initDriver() {
        this.driver = new FirefoxDriver();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void testCalendarPageElements() {
        driver.get("https://dou.ua/calendar/");

        Assert.assertTrue(driver.findElement(By.name("city")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("tag")).isDisplayed());
        Assert.assertTrue(driver.findElements(By.cssSelector("div.event")).size() != 0);

        driver.findElement(By.linkText("Архив")).click();
        Assert.assertTrue(driver.getTitle().equals("Архив событий | DOU"));
        Assert.assertTrue(driver.findElement(By.name("city")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("tag")).isDisplayed());
        Assert.assertTrue(driver.findElements(By.cssSelector("div.event")).size() != 0);

        driver.findElement(By.linkText("Добавить событие")).click();
        Assert.assertTrue(driver.getTitle().equals("Новое событие | DOU"));
    }
}
