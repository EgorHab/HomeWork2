package Lesson5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveJournalPage {
    private WebDriver driver;



    @FindBy(xpath = ".//a[@class='s-logo-link']")
    private WebElement mainPage;

    @FindBy(css = ".s-header-item__link--login")
    private WebElement logIn;

    @FindBy(id = "user")
    private WebElement userField;

    @FindBy(id = "lj_loginwidget_password")
    private WebElement passwordField;

    @FindBy(name = "action:login")
    private WebElement submitAuthorization;

    @FindBy(xpath = ".//div[@class='s-header__nav']//a[@data-tour = 'friendsfeed']")
    private WebElement friends;

    @FindBy(xpath = ".//div[@class = 'main-footer__lang']//p")
    public WebElement listOfLanguages;

    @FindBy(css = ".s-lang-select li:nth-child(1)")
    private WebElement englishLanguage;

    @FindBy(css = ".s-lang-select li:nth-child(1)")
    private WebElement russianLanguage;

    @FindBy(css = ".s-header-item--user")
    private WebElement dropDownList;

    @FindBy(css = ".s-header-sub-list-item__link--settings")
    private WebElement settingDropDown;
    @FindBy(css = ".s-header-sub-list-item__link--messages")
    private WebElement messagesDropDown;

    @FindBy(linkText = "Пользовательское соглашение")
    public WebElement userAgreement;

    @FindBy(css = ".main-footer__bottom-links-item:nth-child(3) > .main-footer__bottom-link")
    private WebElement help;

    @FindBy(linkText = "Политика конфиденциальности")
    private WebElement privacyPolicy;

    @FindBy(xpath = ".//ul[@class='aside-menu']//a[@target='_blank']")
    private WebElement filterSet;

    public LiveJournalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LiveJournalPage clickMainPage() {
        mainPage.click();
        return this;
    }

    public LiveJournalPage clickLogIn() {
        logIn.click();
        return this;
    }

    public LiveJournalPage writeUserArea(String userName) {
        userField.sendKeys(userName);
        return this;
    }

    public LiveJournalPage writePasswordArea(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LiveJournalPage clickSubmitAuthorization() {
        submitAuthorization.click();
        return this;
    }

    public LiveJournalPage clickFriends() {
        friends.click();
        return this;
    }

    public LiveJournalPage clickListLang() {
        listOfLanguages.click();
        return this;
    }

    public LiveJournalPage clickEnglishLanguage() {
        englishLanguage.click();
        return this;
    }

    public LiveJournalPage clickRussianLanguage() {
        russianLanguage.click();
        return this;
    }

    public LiveJournalPage callDropDownList() {
        Actions builder = new Actions(driver);
        builder.moveToElement(dropDownList).perform();
        return this;
    }

    public LiveJournalPage clickSettingDropDown() {
        settingDropDown.click();
        return this;
    }

    public LiveJournalPage clickMessageDropDown() {
        messagesDropDown.click();
        return this;
    }

    public LiveJournalPage clickUserAgreement() {
        userAgreement.click();
        return this;
    }

    public LiveJournalPage clickHelp() {
        help.click();
        return this;
    }

    public LiveJournalPage clickPrivacyPolicy() {
        privacyPolicy.click();
        return this;
    }

    public LiveJournalPage clickFilterSet() {
        filterSet.click();
        return this;
    }


}
