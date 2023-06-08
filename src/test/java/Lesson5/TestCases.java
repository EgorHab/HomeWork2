package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases {

    public String password = "271486Geekbrains";
    public String userName = "frl27";
    public String newPassword = "271486Geekbrains@";
    public String sendAddress = "egoregor27";


    private WebDriver driver;
    //private Alert alert;


    @AfterEach
    public void cleanUp() {
        if (driver != null) {
            //driver.quit();
        }

    }


    @Test
    void testCase1() {
        WebDriverManager.chromedriver().setup();


        driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        LiveJournalPage liveJournalPage = new LiveJournalPage(driver);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        options.addArguments("--incognito");
        //options.addArguments("--headless");

        driver.get("https://www.livejournal.com");


        liveJournalPage.clickLogIn();
        liveJournalPage.writeUserArea(userName);
        liveJournalPage.writePasswordArea(password);
        liveJournalPage.clickSubmitAuthorization();


        liveJournalPage.clickFriends();


        js.executeScript("arguments[0].scrollIntoView();", liveJournalPage.listOfLanguages);
        liveJournalPage.clickListLang();
        js.executeScript("arguments[0].scrollIntoView();", liveJournalPage.listOfLanguages);
        liveJournalPage.clickEnglishLanguage();

        Assertions.assertEquals("Entries feed for frl27", driver.getTitle());


    }

    @Test
    void testCase2() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        LiveJournalPage liveJournalPage = new LiveJournalPage(driver);
        SettingPage settingPage = new SettingPage(driver);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        options.addArguments("--incognito");

        driver.get("https://www.livejournal.com");

        /*Предусловие: пользователь авторизован*/

        liveJournalPage.clickLogIn();
        liveJournalPage.writeUserArea(userName);
        liveJournalPage.writePasswordArea(password);
        liveJournalPage.clickSubmitAuthorization();



        /*Шаги*/


        liveJournalPage.callDropDownList();
        liveJournalPage.clickSettingDropDown();
        settingPage.clickAccountSet();
        settingPage.clickPasswordSet();
        settingPage.writePassword(password);

        settingPage.writeNewPassword(newPassword);
        settingPage.writeNewPassword2(newPassword);


        settingPage.saveNewPass();


        /*Вернуть систему в исходное состояние*/

        liveJournalPage.clickLogIn();
        liveJournalPage.writeUserArea(userName);
        liveJournalPage.writePasswordArea(newPassword);
        liveJournalPage.clickSubmitAuthorization();
        liveJournalPage.callDropDownList();
        liveJournalPage.clickSettingDropDown();
        settingPage.clickAccountSet();
        settingPage.clickPasswordSet();
        settingPage.writePassword(newPassword);
        settingPage.writeNewPassword(password);
        settingPage.writeNewPassword2(password);
        settingPage.saveNewPass();


        Assertions.assertEquals("Change Password", driver.getTitle());


    }

    @Test
    void testCase3() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        LiveJournalPage liveJournalPage = new LiveJournalPage(driver);
        MessagePage messagePage = new MessagePage(driver);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        options.addArguments("--incognito");

        driver.get("https://www.livejournal.com");




        /*Предусловие: пользователь авторизован*/

        liveJournalPage.clickLogIn();
        liveJournalPage.writeUserArea(userName);
        liveJournalPage.writePasswordArea(password);
        liveJournalPage.clickSubmitAuthorization();


        /*Шаги*/

        liveJournalPage.callDropDownList();
        liveJournalPage.clickMessageDropDown();

        messagePage.clickMessageNew();
        messagePage.sendToArea(sendAddress);
        messagePage.titleArea("test");
        messagePage.bodyArea("test");

        messagePage.clickSendButton();

        Assertions.assertEquals("Compose Message", driver.getTitle());


    }

    @Test
    void testCase4() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        LiveJournalPage liveJournalPage = new LiveJournalPage(driver);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        options.addArguments("--incognito");

        driver.get("https://www.livejournal.com");


        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", liveJournalPage.userAgreement);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", liveJournalPage.userAgreement);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", liveJournalPage.userAgreement);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", liveJournalPage.userAgreement);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", liveJournalPage.userAgreement);

        /*Пришлось городить такие костыли, т.к страница при вертикальном скролле добавляет длину
        всякий раз когда пролистываешь до самого низа. Сам элемент недоступен для взаимодействия пока вне поля зрения.*/


        liveJournalPage.clickUserAgreement();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        liveJournalPage.clickHelp();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        liveJournalPage.clickPrivacyPolicy();

        Assertions.assertEquals("Правовая информация", driver.getTitle());

    }

    @Test
    void testCase5() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        ChromeOptions options = new ChromeOptions();
        LiveJournalPage liveJournalPage = new LiveJournalPage(driver);
        EditGroupFriends editGroupFriends = new EditGroupFriends(driver);
        //JavascriptExecutor js = (JavascriptExecutor) driver;


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        options.addArguments("--incognito");

        driver.get("https://www.livejournal.com");


        /*Предусловие: пользователь авторизован*/

        liveJournalPage.clickLogIn();
        liveJournalPage.writeUserArea(userName);
        liveJournalPage.writePasswordArea(password);
        liveJournalPage.clickSubmitAuthorization();


        /*Шаги*/

        liveJournalPage.clickFriends();
        liveJournalPage.clickFilterSet();


        List<String> allHandles = new ArrayList(driver.getWindowHandles());
        String currentHandle = allHandles.get(1);

        driver.switchTo().window(currentHandle);

        editGroupFriends.clickFamily();

        for (int j = 0; j < 5; j++) {
            editGroupFriends.moveDown();
        }

        editGroupFriends.clickSaveChanges();


        /*Вернуть систему в исходное состояние*/

        driver.navigate().back();
        editGroupFriends.clickFamily();

        for (int x = 0; x < 5; x++) {
            editGroupFriends.moveUp();
        }

        editGroupFriends.clickSaveChanges();


    }

}
