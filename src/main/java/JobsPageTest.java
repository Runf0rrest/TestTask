import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
    This test case is important because it gives opportunity to check if main elements of Jobs Page
    are displayed and all related features can be tested
 */

public class JobsPageTest {
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
    public void testJobsPageElements() {
        driver.get("https://jobs.dou.ua/");

        Assert.assertTrue(driver.findElement(By.name("category")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.name("search")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.cssSelector("input.btn-search")).isDisplayed());

        Assert.assertTrue(driver.findElements(By.cssSelector("a.cat-link")).size() != 0);

        Assert.assertTrue(driver.findElements(By.cssSelector("a.vt")).size() != 0);
    }
}
