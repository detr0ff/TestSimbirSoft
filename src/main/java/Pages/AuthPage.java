package Pages;

import Browser.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AuthPage {
    private final WebElement EMAIL_INPUT = WebDriverFactory.getDriver().findElement(By.xpath("//input[@type = 'email']"));
    private final WebElement NEXT_BUTTON_EMAIL = WebDriverFactory.getDriver().findElement(By.id("identifierNext"));
    private final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@type = 'password']");
    private final By NEXT_BUTTON_PASSWORD = By.id("passwordNext");



    public void enterEmail(String email){
        new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(EMAIL_INPUT)).sendKeys(email);
    }

    public void enterPassword(String password){
       new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(PASSWORD_INPUT_LOCATOR)).sendKeys(password);
    }

    public void Authorization(String email, String password){
        enterEmail(email);
        NEXT_BUTTON_EMAIL.click();
        enterPassword(password);
        new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON_PASSWORD)).click();
    }
}
