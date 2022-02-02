package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    private static WebDriver instance;
    private static final String Node = "http://localhost:4444";


    public static WebDriver getDriver(){
        if (instance == null) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName("chrome");
            WebDriverManager.chromedriver().setup();
            try {
                instance = new RemoteWebDriver(new URL(Node), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}

