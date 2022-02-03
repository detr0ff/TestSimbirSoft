package Pages;

import Browser.PageFactory;
import Browser.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AuthPage {
    private final WebElement emailInput = PageFactory.findElement(By.xpath("//input[@type = 'email']"));
    private final WebElement nextButtonEmail = PageFactory.findElement(By.id("identifierNext"));
    private final By passwordInputLocator = By.xpath("//input[@type = 'password']");
    private final By nextButtonPassword = By.id("passwordNext");
    private final WebDriverWait webDriverWait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(10));

    public void enterEmail(String email){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(email);
    }

    public void enterPassword(String password){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(passwordInputLocator)).sendKeys(password);
    }

    public void authorization(String email, String password){
        enterEmail(email);
        nextButtonEmail.click();
        enterPassword(password);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(nextButtonPassword)).click();
    }
}
