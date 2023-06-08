package EthHashArray;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class CreateWallets {
    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        //WebDriverWait wait = new WebDriverWait(driver, 4);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        //options.addArguments("--incognito");
        //options.addArguments("--headless");


        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


        driver.get("file:///C:/Users/freiv/OneDrive/%D0%A0%D0%B0%D0%B1%D0%BE%D1%87%D0%B8%D0%B9%20%D1%81%D1%82%D0%BE%D0%BB/etherwallet-v3.36.0/index.html#generate-wallet");

        int number;


        driver.findElement(By.xpath(".//img[@title='Close']")).click();
        options.addArguments("--headless");

        for (number = 1000; number <= 1002; number++) {

            driver.findElement(By.name("password")).click();
            driver.findElement(By.name("password")).sendKeys("1234567890");
            driver.findElement(By.xpath(".//section[@class='block__main gen__1--inner']/a")).click();
            driver.findElement(By.xpath(".//section[@class='block__main gen__2--inner']/a")).click();
            driver.findElement(By.xpath(".//section[@class='block__main gen__2--inner']/p/a")).click();

            String key = driver.findElement(By.xpath(".//section[@class='block__main gen__3--inner']/textarea")).getText();

            //WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(By.id(".//article[@role='main']//a[@class ='btn btn-default btn-sm']")));
            //element.click();

            driver.findElement(By.xpath(".//article[@role='main']//a[@class ='btn btn-default btn-sm']")).click();
            driver.findElement(By.xpath(".//label[@aria-flowto='aria8']/input")).click();

            driver.findElement(By.xpath(".//div[@class='form-group']/textarea")).sendKeys(key);
            driver.findElement(By.xpath(".//a[@ng-click='decryptWallet()']")).click();

            String address = driver.findElement(By.xpath(".//ul[@class='account-info']/span")).getText();


            //driver.findElement(By.xpath(".//ul[@class='nav-inner']//a[@translate='NAV_SendEther']")).click();
            //driver.findElement(By.xpath(".//ul[@class='nav-inner']//a[@translate='NAV_GenerateWallet_alt']")).click();


            //System.out.println(key);
            FileWriter writerAddress = new FileWriter("C:\\address.txt", true);
            try {

                writerAddress.write(address + "\n");
                writerAddress.flush();

            } catch (IIOException e) {
                System.out.println(e.getMessage());
            }

            FileWriter writer = new FileWriter("C:\\key.txt", true);

            try {

                writer.write(key + "\n");
                writer.flush();


            } catch (IIOException e) {
                System.out.println(e.getMessage());
            }
            driver.findElement(By.xpath(".//ul[@class='nav-inner']//a[@translate='NAV_SendEther']")).click();
            driver.findElement(By.xpath(".//ul[@class='nav-inner']//a[@translate='NAV_GenerateWallet_alt']")).click();
        }



        driver.quit();
    }
}
