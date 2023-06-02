package EthHashArray;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyEtherWallet {
    public static void main(String[] args) throws IOException {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver.get("file:///C:/Users/freiv/OneDrive/%D0%A0%D0%B0%D0%B1%D0%BE%D1%87%D0%B8%D0%B9%20%D1%81%D1%82%D0%BE%D0%BB/etherwallet-v3.36.0/index.html#generate-wallet");




        driver.findElement(By.xpath(".//img[@title='Close']")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("1234567890");
        driver.findElement(By.xpath(".//section[@class='block__main gen__1--inner']/a")).click();
        driver.findElement(By.xpath(".//section[@class='block__main gen__2--inner']/a")).click();
        driver.findElement(By.xpath(".//section[@class='block__main gen__2--inner']/p/a")).click();

        String key = driver.findElement(By.xpath(".//section[@class='block__main gen__3--inner']/textarea")).getText();

        //System.out.println(key);
        FileWriter writer = new FileWriter("C:\\key.txt");
        try {
            writer.write(key);
            writer.flush();
        }catch (IIOException e) {
            System.out.println(e.getMessage());
        }


    }
}
