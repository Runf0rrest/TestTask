import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
    This test is important because it helps us to find out whether links on main
    page are not broken. And we can continue testing of functionality of other pages
    this links lead to.
 */
public class HomePageLinksTest {
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
    public void testLinks() {
        driver.get("https://dou.ua/");
        Assert.assertTrue(driver.getTitle().equals("Сообщество программистов | DOU"));

        driver.findElement(By.linkText("ФОРУМ")).click();
        Assert.assertTrue(driver.getTitle().equals("Форум программистов | DOU"));

        driver.findElement(By.linkText("ЛЕНТА")).click();
        Assert.assertTrue(driver.getTitle().equals("Новые записи — Лента | DOU"));

        driver.findElement(By.linkText("ЗАРПЛАТЫ")).click();
        Assert.assertTrue(driver.getTitle().equals("Cтатистика зарплат программистов, тестировщиков и PM в Украине | DOU"));

        driver.findElement(By.linkText("РАБОТА")).click();
        Assert.assertTrue(driver.getTitle().equals("Вакансии | DOU"));

        driver.findElement(By.linkText("КАЛЕНДАРЬ")).click();
        Assert.assertTrue(driver.getTitle().equals("Календарь ИТ-событий | DOU"));

        driver.findElement(By.linkText("ГЛАВНАЯ")).click();
        Assert.assertTrue(driver.getTitle().equals("Сообщество программистов | DOU"));
    }
}
