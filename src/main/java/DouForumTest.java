import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
    This test case is important because it gives opportunity to check if main elements of Forum Page
    are displayed and all links to another pages with features to be tested are valid.
 */

public class DouForumTest {
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
    public void testForumLinks() {
        driver.get("https://dou.ua/forums/");

        Assert.assertTrue(driver.findElement(By.cssSelector("select.select")).isDisplayed());

        Assert.assertTrue(driver.findElements(By.tagName("article")).size() != 0);

        driver.findElement(By.linkText("Новые")).click();
        Assert.assertTrue(driver.findElements(By.tagName("article")).size() != 0);
        Assert.assertTrue(driver.getTitle().equals("Новые обсуждения | DOU"));

        driver.findElement(By.linkText("Последние комментарии")).click();
        Assert.assertTrue(driver.getTitle().equals("Последние комментарии на форуме | DOU"));
        Assert.assertTrue(driver.findElements(By.cssSelector("li.item")).size() != 0);

        driver.findElement(By.linkText("Добавить топик")).click();
        Assert.assertTrue(driver.getTitle().equals("Новый топик | DOU"));
    }
}
