package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageFactory {
    public static WebElement findElement(By locator){
        return WebDriverFactory.getDriver().findElement(locator);
    }
}
