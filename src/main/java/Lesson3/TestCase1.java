package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class TestCase1 {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ChromeOptions options = new ChromeOptions();
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
        driver.findElement(By.cssSelector(".s-lang-select li:nth-child(1)")).click();

    }

}

