package Lesson5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases {

    private WebDriver driver;
    //private Alert alert;


    @AfterEach
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }

    }


    @Test
    void testCase1() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();

        JavascriptExecutor js = (JavascriptExecutor) driver;


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        options.addArguments("--incognito");

        driver.get("https://www.livejournal.com");


        driver.findElement(By.xpath(".//ul[@class ='s-do'] //a")).click();
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).sendKeys("frl27");
        driver.findElement(By.id("lj_loginwidget_password")).click();
        driver.findElement(By.id("lj_loginwidget_password")).sendKeys("271486Geekbrains");
        driver.findElement(By.name("action:login")).click();


        driver.findElement(By.xpath(".//div[@class='s-header__nav']//a[@data-tour = 'friendsfeed']")).click();

        WebElement Element = driver.findElement(By.xpath(".//div[@class = 'main-footer__lang']//p"));
        js.executeScript("arguments[0].scrollIntoView();", Element);

        driver.findElement(By.xpath(".//div[@class = 'main-footer__lang']//p")).click();
        js.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(By.cssSelector(".s-lang-select li:nth-child(1)")).click();

        Assertions.assertEquals("Entries feed for frl27", driver.getTitle());


    }

    @Test
    void testCase2() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        Actions builder = new Actions(driver);
        //JavascriptExecutor js = (JavascriptExecutor) driver;

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        options.addArguments("--incognito");

        driver.get("https://www.livejournal.com");

        /*Предусловие: пользователь авторизован*/
        driver.findElement(By.xpath(".//ul[@class ='s-do'] //a")).click();
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).sendKeys("frl27");
        driver.findElement(By.id("lj_loginwidget_password")).click();
        driver.findElement(By.id("lj_loginwidget_password")).sendKeys("271486Geekbrains");
        driver.findElement(By.name("action:login")).click();



        /*Шаги*/


        builder.moveToElement(driver.findElement(By.cssSelector(".s-header-item--user"))).perform();
        driver.findElement(By.cssSelector(".s-header-sub-list-item__link--settings")).click();
        driver.findElement(By.xpath(".//div[@data-react-root]/div/nav/a[2]")).click();
        driver.findElement(By.cssSelector("tr:nth-child(5) > .account_actionlink > a")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("271486Geekbrains");
        driver.findElement(By.name("newpass1")).click();
        driver.findElement(By.name("newpass1")).sendKeys("271486Geekbrains@");
        driver.findElement(By.name("newpass2")).click();
        driver.findElement(By.name("newpass2")).sendKeys("271486Geekbrains@");
        driver.findElement(By.cssSelector(".b-ljform-field > .b-flatbutton")).click();


        /*Вернуть систему в исходное состояние*/

        driver.findElement(By.xpath(".//ul[@class ='s-do'] //a")).click();
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).sendKeys("frl27");
        driver.findElement(By.id("lj_loginwidget_password")).click();
        driver.findElement(By.id("lj_loginwidget_password")).sendKeys("271486Geekbrains@");
        driver.findElement(By.name("action:login")).click();
        driver.findElement(By.xpath(".//div[@class='s-header__nav']//a[@data-tour = 'friendsfeed']")).click();
        builder.moveToElement(driver.findElement(By.cssSelector(".s-header-item--user"))).perform();
        driver.findElement(By.cssSelector(".s-header-sub-list-item__link--settings")).click();
        driver.findElement(By.xpath(".//div[@data-react-root]/div/nav/a[2]")).click();
        driver.findElement(By.cssSelector("tr:nth-child(5) > .account_actionlink > a")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("271486Geekbrains@");
        driver.findElement(By.name("newpass1")).click();
        driver.findElement(By.name("newpass1")).sendKeys("271486Geekbrains");
        driver.findElement(By.name("newpass2")).click();
        driver.findElement(By.name("newpass2")).sendKeys("271486Geekbrains");
        driver.findElement(By.cssSelector(".b-ljform-field > .b-flatbutton")).click();

        Assertions.assertEquals("Change Password", driver.getTitle());


    }

    @Test
    void testCase3() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        Actions builder = new Actions(driver);


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        options.addArguments("--incognito");

        driver.get("https://www.livejournal.com");




        /*Предусловие: пользователь авторизован*/
        driver.findElement(By.xpath(".//ul[@class ='s-do'] //a")).click();
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).sendKeys("frl27");
        driver.findElement(By.id("lj_loginwidget_password")).click();
        driver.findElement(By.id("lj_loginwidget_password")).sendKeys("271486Geekbrains");
        driver.findElement(By.name("action:login")).click();

        /*Шаги*/

        builder.moveToElement(driver.findElement(By.cssSelector(".s-header-item--user"))).perform();
        driver.findElement(By.cssSelector(".s-header-sub-list-item__link--messages")).click();
        driver.findElement(By.cssSelector(".inbox-sidebar__button-message")).click();
        driver.findElement(By.id("msg_to")).click();
        driver.findElement(By.id("msg_to")).sendKeys("egoregor27");
        driver.findElement(By.name("msg_subject")).click();
        driver.findElement(By.name("msg_subject")).sendKeys("test");
        driver.findElement(By.name("msg_body")).sendKeys("test");
        driver.findElement(By.cssSelector("button:nth-child(4)")).click();

        Assertions.assertEquals("Compose Message", driver.getTitle());


    }

    @Test
    void testCase4() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        //Actions builder = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        options.addArguments("--incognito");

        driver.get("https://www.livejournal.com");

        WebElement Element = driver.findElement(By.linkText("Пользовательское соглашение"));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(By.linkText("Пользовательское соглашение"));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(By.linkText("Пользовательское соглашение"));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(By.linkText("Пользовательское соглашение"));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.linkText("Пользовательское соглашение"));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);

        /*Пришлось городить такие костыли, т.к страница при вертикальном скролле добавляет длину
        всякий раз когда пролистываешь до самого низа. Сам элемент недоступен для взаимодействия пока вне поля зрения.*/


        driver.findElement(By.linkText("Пользовательское соглашение")).click();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.cssSelector(".main-footer__bottom-links-item:nth-child(3) > .main-footer__bottom-link")).click();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.linkText("Политика конфиденциальности")).click();

        Assertions.assertEquals("Правовая информация", driver.getTitle());

    }

    @Test
    void testCase5() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        ChromeOptions options = new ChromeOptions();
        //Actions builder = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //WebDriverWait wait = new WebDriverWait(driver, 4);


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        options.addArguments("--incognito");

        driver.get("https://www.livejournal.com");


        /*Предусловие: пользователь авторизован*/

        driver.findElement(By.xpath(".//ul[@class ='s-do'] //a")).click();
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).sendKeys("frl27");
        driver.findElement(By.id("lj_loginwidget_password")).click();
        driver.findElement(By.id("lj_loginwidget_password")).sendKeys("271486Geekbrains");
        driver.findElement(By.name("action:login")).click();


        /*Шаги*/

        driver.findElement(By.xpath(".//div[@class='s-header__nav']//a[@data-tour = 'friendsfeed']")).click();
        driver.findElement(By.xpath(".//ul[@class='aside-menu']//a[@target='_blank']")).click();


        List<String> allHandles = new ArrayList(driver.getWindowHandles());
        String currentHandle = allHandles.get(1);

        driver.switchTo().window(currentHandle);

        driver.findElement(By.xpath(".//select[@name='list_groups']/option[@value='1']")).click();

        for (int j = 0; j < 5; j++) {
            driver.findElement(By.xpath(".//input[@value='Подвинуть вниз']")).click(); /*Сместить элемент вниз на 5 позиций*/
        }

        driver.findElement(By.xpath(".//button[@value='Сохранить изменения']")).click();


        /*Вернуть систему в исходное состояние*/

        driver.navigate().back();
        driver.findElement(By.xpath(".//select[@name='list_groups']/option[@value='1']")).click();

        for (int x = 0; x < 5; x++) {
            driver.findElement(By.xpath(".//input[@value='Подвинуть вверх']")).click();
        }

        driver.findElement(By.xpath(".//button[@value='Сохранить изменения']")).click();


    }

}
