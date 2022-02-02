package Pages;

import Browser.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewMailForm {
    private final WebElement WHO_INPUT = WebDriverFactory.getDriver().findElement(By.xpath("//textarea[@name = 'to']"));
    private final WebElement THEME_INPUT = WebDriverFactory.getDriver().findElement(By.xpath("//input[@name='subjectbox']"));
    private final WebElement TEXT_INPUT = WebDriverFactory.getDriver().findElement(By.xpath("//div[@role = 'textbox']"));
    private final WebElement SEND_BUTTON = WebDriverFactory.getDriver().findElement(By.xpath("//div[@class = 'dC']/div[1]"));
    private final By NEW_LETTER_CHECK_LOCATOR = By.xpath("//div[@role = 'alert']//div[@class = 'vh']");

    public void enterRecipient(String name){
        WHO_INPUT.sendKeys(name);
    }

    public void enterTheme(String theme){
        THEME_INPUT.sendKeys(theme);
    }

    public void enterText(String text){
        TEXT_INPUT.sendKeys(text);
    }

    public void sendButtonClick(){
        SEND_BUTTON.click();
    }

    public void writeMail(String recipient, String theme, String text){
        enterRecipient(recipient);
        enterTheme(theme);
        enterText(text);
        sendButtonClick();
        new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(30))
                .until(ExpectedConditions.invisibilityOfElementLocated(NEW_LETTER_CHECK_LOCATOR));
    }
}
