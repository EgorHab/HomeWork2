package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestCase4 {
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


        /*Шаги*/

        /*Пришлось городить такие костыли, т.к страница при вертикальном скролле добавляет длину
        всякий раз когда пролистываешь до самого низа. Сам элемент недоступен для взаимодействия пока вне поля зрения.*/

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






    }
}
