package Lesson5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingPage {
    private WebDriver driver;
    @FindBy(xpath = ".//div[@data-react-root]/div/nav/a[2]")
    private WebElement accountSet;

    @FindBy(css = "tr:nth-child(5) > .account_actionlink > a")
    private WebElement passwordSet;

    @FindBy(name = "password")
    private WebElement passwordArea;

    @FindBy(name = "newpass1")
    private WebElement newPasswordArea1;
    @FindBy(name = "newpass2")
    private WebElement newPasswordArea2;
    @FindBy(css = ".b-ljform-field > .b-flatbutton")
    private WebElement saveNewPass;

    public SettingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SettingPage clickAccountSet() {
        accountSet.click();
        return this;
    }

    public SettingPage clickPasswordSet() {
        passwordSet.click();
        return this;
    }

    public SettingPage writePassword(String password) {
        passwordArea.sendKeys(password);
        return this;
    }

    public SettingPage writeNewPassword(String newPassword) {
        newPasswordArea1.sendKeys(newPassword);
        return this;
    }

    public SettingPage writeNewPassword2(String newPassword) {
        newPasswordArea2.sendKeys(newPassword);
        return this;
    }
    public SettingPage saveNewPass() {
        saveNewPass.click();
        return this;
    }


}
