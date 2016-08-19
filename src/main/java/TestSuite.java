import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    LogInTest.class,
    HomePageLinksTest.class,
    DouForumTest.class,
    ArticlesTest.class,
    JobsPageTest.class,
    CalendarPageTest.class
})
public class TestSuite {}