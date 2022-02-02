package Pages;

import Browser.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MailPage {
    private final WebElement MAIL_TABLE = WebDriverFactory.getDriver().findElement(By.xpath("//table[@id = ':2a']"));
    private final WebElement WRITE_BUTTON = WebDriverFactory.getDriver().findElement(By.xpath("//div[@class = 'aic']/div/div"));

    public List<String> getMailsThemes(){
        List<WebElement> mails = MAIL_TABLE.findElements(By.className("bog"));
        return mails.stream().map(WebElement::getText).toList();
    }

    public void writeButtonClick(){
        WRITE_BUTTON.click();
    }

    public void writeMail(String recipient, String theme, String text){
        writeButtonClick();
        NewMailForm newMailForm = new NewMailForm();
        newMailForm.writeMail(recipient, theme, text);
    }

}
