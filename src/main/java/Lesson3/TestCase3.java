package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestCase3 {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();


        Actions builder = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ChromeOptions options = new ChromeOptions();
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


    }
}
