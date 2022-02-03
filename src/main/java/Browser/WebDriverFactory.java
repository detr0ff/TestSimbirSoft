package Browser;

import Utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebDriverFactory {

    private static WebDriver instance;
    private static final String configFilePath = "src/main/resources/config.properties";
    private static final String node = PropertyReader.getProperty(configFilePath, "node");
    private static final String browserName = PropertyReader.getProperty(configFilePath, "browser");
    private static final int implicitlyWait = Integer.parseInt(PropertyReader.getProperty(configFilePath, "implicitlyWait"));

    public static WebDriver getDriver(){
        if (instance == null) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName(browserName);
            WebDriverManager.chromedriver().setup();
            try {
                instance = new RemoteWebDriver(new URL(node), caps);
                instance.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}


