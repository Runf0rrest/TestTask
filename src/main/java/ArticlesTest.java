import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
    This test case is important because it gives opportunity to check if main elements of Article Page
    are displayed and all links to another are valid
 */


public class ArticlesTest {
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
    public void testArticles() {
        driver.get("https://dou.ua/lenta/");

        Assert.assertTrue(driver.findElement(By.name("category")).isDisplayed());

        Assert.assertTrue(driver.findElements(By.tagName("article")).size() != 0);

        driver.findElement(By.linkText("Лучшее")).click();
        Assert.assertTrue(driver.findElements(By.tagName("article")).size() != 0);
        Assert.assertTrue(driver.getTitle().contains("Лучшее — Лента | DOU"));

        driver.findElement(By.linkText("Все темы")).click();
        Assert.assertTrue(driver.getTitle().equals("Темы ленты | DOU"));
        Assert.assertTrue(driver.findElements(By.cssSelector("[class~=b-tag]")).size() != 0);

        driver.findElement(By.linkText("Последние комментарии")).click();
        Assert.assertTrue(driver.getTitle().equals("Последние комментарии ленты | DOU"));
        Assert.assertTrue(driver.findElements(By.cssSelector("li.item")).size() != 0);

        driver.findElement(By.linkText("Прислать статью")).click();
        Assert.assertTrue(driver.getTitle().equals("Как прислать статью | DOU"));
    }
}
