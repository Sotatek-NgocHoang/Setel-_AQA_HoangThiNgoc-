package hongngoc.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Webs {
    public String name = "";
    public int price = 0;

}

public class SignInTest {
    private WebDriver driver;

    @Test
    public List<WebElement> testBase() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.ebay.com/");

        System.out.println(driver.getTitle());


        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("iphone 11");
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

        boolean checkText = driver.findElement(By.xpath("//span[contains(text(),'iphone 11')]")).isDisplayed();
        if (checkText == true) {
            System.out.println("Hien thi dung ket qua search");
        }

        List<WebElement> vs = driver.findElements(By.className("s-item__pl-on-bottom"));



        return vs;


    }

    @Test
    public List<WebElement> testBase2() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 11");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

        boolean checkText = driver.findElement(By.xpath("//span[contains(text(),'iphone 11')]")).isDisplayed();
        if (checkText == true) {
            System.out.println("Hien thi dung ket qua search");
        }


        List<WebElement> ng = driver.findElements(By.className("s-asin"));



        return ng;

    }

    @Test
    public void testBase5() throws InterruptedException {
        List<WebElement> ng = this.testBase2();

        ArrayList<Webs> arrayList = new ArrayList<Webs>();

        for (WebElement product : ng) {
            List<WebElement> hoa = product.findElements(By.className("a-size-medium"));

            Webs tg6 = new Webs();

            for (WebElement tg1 : hoa) {
                tg6.name = tg1.getText();
                break;
   

            }

            List<WebElement> hoa1 = product.findElements(By.className("a-price-whole"));

            for (WebElement tg2 : hoa1) {

                tg6.price = changeprice(tg2.getText());

 
            }

            arrayList.add(tg6);


        }

        List<WebElement> vs = this.testBase();

        for (WebElement product : vs) {
            List<WebElement> vd = product.findElements(By.className("s-item__title"));
            Webs tg6 = new Webs();
            for (WebElement tg : vd) {
                tg6.name = tg.getText();
                break;
                //System.out.println(tg.getText());
            }

            List<WebElement> pr = product.findElements(By.className("s-item__price"));

            for (WebElement tg : pr) {

                tg6.price = changeprice(tg.getText());

                //System.out.println(tg.getText());
                break;

            }
            arrayList.add(tg6);
        }


        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).name);
            System.out.println(arrayList.get(i).price);
            System.out.println("===============================");
        }
    }


    public int changeprice(String price) {
        int number;
        if (price == null) {
            return 0;
        }
        try {
            int d = Integer.parseInt(price);
            return d*22681;
        } catch (NumberFormatException nfe) {

            String ary[] = price.split(" ");

            String strNew1 = ary[0].replace(".", "-");

            String ary1[] = strNew1.split("-");

            String strNew = ary1[0].replace(",", "");
            return Integer.parseInt(strNew);
        }
    }
}
