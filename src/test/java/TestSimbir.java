
import Browser.WebDriverFactory;
import Pages.AuthPage;
import Pages.MailPage;
import Utils.PropertyReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.List;

public class TestSimbir {
    String propertyFilePath = "src/test/resources/conf.properties";
    String url = PropertyReader.getProperty(propertyFilePath, "url");
    String login = PropertyReader.getProperty(propertyFilePath, "login");
    String password = PropertyReader.getProperty(propertyFilePath, "password");


    @Before
    public void start(){
        WebDriver driver = WebDriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(url);
    }

    @Test
    public void Test1(){
        AuthPage authPage = new AuthPage();
        authPage.authorization(login, password);
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
