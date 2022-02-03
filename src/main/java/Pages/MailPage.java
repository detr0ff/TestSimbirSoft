package Pages;

import Browser.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MailPage {
    private final WebElement mailTable = PageFactory.findElement(By.xpath("//table[@id = ':2a']"));
    private final WebElement writeButton = PageFactory.findElement(By.xpath("//div[@class = 'aic']/div/div"));

    public List<String> getMailsThemes(){
        List<WebElement> mails = mailTable.findElements(By.className("bog"));
        return mails.stream().map(WebElement::getText).toList();
    }

    public void writeMail(String recipient, String theme, String text){
        writeButtonClick();
        NewMailForm newMailForm = new NewMailForm();
        newMailForm.writeMail(recipient, theme, text);
    }

    private void writeButtonClick(){
        writeButton.click();
    }
}
