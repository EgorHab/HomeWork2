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

public class ByTicket {
    String contractAddress = "0x699427Bfe45E245cc2e81EbeDe21d535992Cc40C";
    String amount = "0.00012";
    String data = "0x67dd74ca0000000000000000000000000000000000000000000000000000000000000017";
    String gas = "1000000";
     String privateKeys = "C:\\key.txt";


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        Actions actions = new Actions(driver);
        options.addArguments("start-maximized");
        ByTicket byTicket = new ByTicket();
        File file = new File(byTicket.privateKeys);

        ArrayList<String> key = new ArrayList<String>();


        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String addKeyToArrayList = scanner.next();
                key.add(addKeyToArrayList);

            }
            //System.out.println(key);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения" + key);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("file:///C:/Users/freiv/OneDrive/%D0%A0%D0%B0%D0%B1%D0%BE%D1%87%D0%B8%D0%B9%20%D1%81%D1%82%D0%BE%D0%BB/etherwallet-v3.36.0/index.html#generate-wallet");

        driver.findElement(By.xpath(".//img[@title='Close']")).click();




        driver.findElement(By.xpath(".//span [@class= 'dropdown dropdown-gas']//i[@class='caret']")).click();
        actions.dragAndDropBy(driver.findElement(By.xpath(".//input[@type='range']")),-82, 0 ).build().perform();
        driver.findElement(By.xpath(".//span [@class= 'dropdown dropdown-gas']//i[@class='caret']")).click();



        driver.findElement(By.xpath(".//a[@translate = 'NAV_SendEther']")).click();
        driver.findElement(By.xpath(".//input[@aria-flowto = 'aria8']")).click();
        driver.findElement(By.xpath(".//i[@class= 'icon-close']")).click();





        driver.findElement(By.xpath(".//textarea[@id='aria6']")).sendKeys(key.get(0));
        driver.findElement(By.xpath(".//a[@class='btn btn-primary ng-scope']")).click();
        driver.findElement(By.xpath(".//div[@class = 'input-group']/input")).sendKeys(byTicket.amount);
        driver.findElement(By.xpath(".//div[@class='row form-group']//div[@class='col-xs-11 ng-scope']/input")).sendKeys(byTicket.contractAddress);

        driver.findElement(By.xpath(".//input[@ng-model='tx.gasLimit']")).clear();
        driver.findElement(By.xpath(".//input[@ng-model='tx.gasLimit']")).sendKeys(byTicket.gas);
        driver.findElement(By.xpath(".//p[@translate = 'TRANS_advanced']")).click();

        driver.findElement(By.xpath(".//input[@ng-model= 'tx.data']")).sendKeys(byTicket.data);
        driver.findElement(By.xpath(".//a[@translate='SEND_generate']")).click();
        driver.findElement(By.xpath(".//a[@translate='SEND_trans']")).click();
        driver.findElement(By.xpath(".//button [@translate='SENDModal_Yes']")).click();
        driver.findElement(By.xpath("//.//i[@class='icon-close']")).click();

        driver.findElement(By.xpath(".//span[@ng-show='wd'] ")).click();

        driver.findElement(By.xpath(".//textarea[@id='aria6']")).clear();

        for (int i = 181; i <= 1000; i++) {

            driver.findElement(By.xpath(".//textarea[@id='aria6']")).sendKeys(key.get(i));
            driver.findElement(By.xpath(".//a[@class='btn btn-primary ng-scope']")).click();
            //driver.findElement(By.xpath(".//div[@class = 'input-group']/input")).sendKeys(byTicket.amount);
            //driver.findElement(By.xpath(".//div[@class='row form-group']//div[@class='col-xs-11 ng-scope']/input")).sendKeys(byTicket.contractAddress);

            //driver.findElement(By.xpath(".//input[@ng-model='tx.gasLimit']")).clear();
            //driver.findElement(By.xpath(".//input[@ng-model='tx.gasLimit']")).sendKeys(byTicket.gas);
            Thread.sleep(2000);
            driver.findElement(By.xpath(".//p[@translate = 'TRANS_advanced']")).click();

            //driver.findElement(By.xpath(".//input[@ng-model= 'tx.data']")).sendKeys(byTicket.data);
            driver.findElement(By.xpath(".//a[@translate='SEND_generate']")).click();
            driver.findElement(By.xpath(".//a[@translate='SEND_trans']")).click();
            driver.findElement(By.xpath(".//button [@translate='SENDModal_Yes']")).click();
            driver.findElement(By.xpath("//.//i[@class='icon-close']")).click();

            driver.findElement(By.xpath(".//span[@ng-show='wd'] ")).click();

            driver.findElement(By.xpath(".//textarea[@id='aria6']")).clear();

            System.out.println(key.get(i));


        }
        driver.quit();
    }
}
