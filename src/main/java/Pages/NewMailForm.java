package Pages;

import Browser.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NewMailForm {
    private final WebDriverWait webDriverWait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(40));
    private final WebElement whoInput = WebDriverFactory.getDriver().findElement(By.xpath("//textarea[@name = 'to']"));
    private final WebElement themeInput = WebDriverFactory.getDriver().findElement(By.xpath("//input[@name='subjectbox']"));
    private final WebElement textInput = WebDriverFactory.getDriver().findElement(By.xpath("//div[@role = 'textbox']"));
    private final WebElement sendButton = WebDriverFactory.getDriver().findElement(By.xpath("//div[@class = 'dC']/div[1]"));
    private final By newLetterCheckLocator = By.xpath("//div[@role = 'alert']//div[@class = 'vh']");

    public void enterRecipient(String name){
        whoInput.sendKeys(name);
    }

    public void enterTheme(String theme){
        themeInput.sendKeys(theme);
    }

    public void enterText(String text){
        textInput.sendKeys(text);
    }

    public void sendButtonClick(){
        sendButton.click();
    }

    public void writeMail(String recipient, String theme, String text){
        enterRecipient(recipient);
        enterTheme(theme);
        enterText(text);
        sendButtonClick();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(newLetterCheckLocator));
    }
}
