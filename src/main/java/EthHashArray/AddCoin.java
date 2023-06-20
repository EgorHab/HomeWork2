package EthHashArray;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AddCoin {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);


        //WebDriverWait wait = new WebDriverWait(driver, 4);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("file://C:/Users/freiv/OneDrive/%D0%A0%D0%B0%D0%B1%D0%BE%D1%87%D0%B8%D0%B9%20%D1%81%D1%82%D0%BE%D0%BB/etherwallet-v3.36.0/index.html");
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //driver.manage().window().setSize(new Dimension(1920, 1080));

        String generalKey = "ad9ff2d9132df9c580631fc4cd645d2fbfce30b3f8f06ca4d71730a40115750d";
        String amount = "0.01";
        Actions actions= new Actions(driver);


        //options.addArguments("--headless");







        driver.findElement(By.xpath(".//img[@title='Close']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//span [@class= 'dropdown dropdown-gas']//i[@class='caret']")).click();
        actions.dragAndDropBy(driver.findElement(By.xpath(".//input[@type='range']")),-82, 0 ).build().perform();
        driver.findElement(By.xpath(".//span [@class= 'dropdown dropdown-gas']//i[@class='caret']")).click();


        //.//input[@type='range']



        driver.findElement(By.xpath(".//a[@translate = 'NAV_SendEther']")).click();
        driver.findElement(By.xpath(".//input[@aria-flowto = 'aria8']")).click();
        driver.findElement(By.xpath(".//textarea[@id='aria6']")).sendKeys(generalKey);
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//a[@class='btn btn-primary ng-scope']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//div[@class = 'input-group']/input")).sendKeys(amount);


        ArrayList<String> wallets = new ArrayList<String>();
        String wal = "C:\\Address.txt";
        File file = new File(wal);
        int number = 0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String hash = scanner.next();
                wallets.add(hash);
                number++;


            }
            //System.out.println(wallets);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения" + wallets);
        }

        for (int i = 925; i <= 1000; i++) {

            driver.findElement(By.xpath(".//div[@class='row form-group']//div[@class='col-xs-11 ng-scope']/input")).sendKeys(wallets.get(i));

            driver.findElement(By.xpath(".//a[@translate='SEND_generate']")).click();

            //Thread.sleep(2000);



            driver.findElement(By.xpath(".//a[@translate='SEND_trans']")).click();
            driver.findElement(By.xpath(".//button [@translate='SENDModal_Yes']")).click();
            driver.findElement(By.xpath(".//div[@class='row form-group']//div[@class='col-xs-11 ng-scope']/input")).clear();

            driver.findElement(By.xpath("//.//i[@class='icon-close']")).click();

            System.out.println(wallets.get(i));

        }

        driver.quit();


    }
}
