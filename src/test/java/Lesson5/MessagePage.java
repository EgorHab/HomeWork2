package Lesson5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePage {
    private WebDriver driver;
    @FindBy(css = ".inbox-sidebar__button-message")
    private WebElement messageNew;

    @FindBy(id = "msg_to")
    private WebElement sendTo;

    @FindBy(name = "msg_subject")
    private WebElement title;

    @FindBy(name = "msg_body")
    private WebElement body;

    @FindBy(css = "button:nth-child(4)")
    private WebElement sendButton;

    public MessagePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public MessagePage clickMessageNew() {
        messageNew.click();
        return this;
    }
    public MessagePage sendToArea(String sendAddress) {
        sendTo.sendKeys(sendAddress);
        return this;
    }
    public MessagePage titleArea(String titleText) {
        title.sendKeys(titleText);
        return this;
    }
    public MessagePage bodyArea(String bodyText) {
        body.sendKeys(bodyText);
        return this;
    }
    public MessagePage clickSendButton() {
        sendButton.click();
        return this;
    }

}
