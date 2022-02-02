
import Browser.WebDriverFactory;
import Pages.AuthPage;
import Pages.MailPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.List;

public class TestSimbir {

    @Before
    public void start(){
        WebDriver driver = WebDriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://mail.google.com/");
    }

    @Test
    public void Test1(){
        AuthPage authPage = new AuthPage();
        authPage.Authorization(testData.login, testData.password);
        MailPage mailPage = new MailPage();
        List<String> receivedThemes = mailPage.getMailsThemes();
        String theme = testData.mailTheme;
        int n = (int) receivedThemes.stream().filter(theme::equals).count();
        mailPage.writeMail(testData.newLetterEmail, testData.newLetterTheme, String.valueOf(n));
    }

    @After
    public void end(){
        WebDriverFactory.getDriver().quit();
    }
}
