package Lesson5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditGroupFriends {

    private WebDriver driver;


    @FindBy(xpath = ".//select[@name='list_groups']/option[@value='1']")
    private WebElement family;

    @FindBy(xpath = ".//input[@value='Подвинуть вниз']")
    private WebElement moveDown;

    @FindBy(xpath = ".//input[@value='Подвинуть вверх']")
    private WebElement moveUp;

    @FindBy(xpath = ".//button[@value='Сохранить изменения']")
    private WebElement saveChanges;

    public EditGroupFriends (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EditGroupFriends clickFamily() {
        family.click();
        return this;
    }
    public EditGroupFriends moveDown() {
        moveDown.click();
        return this;
    }
    public EditGroupFriends moveUp() {
        moveUp.click();
        return this;
    }
    public EditGroupFriends clickSaveChanges() {
        saveChanges.click();
        return this;
    }


}
