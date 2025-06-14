package webdriver;

import org.bouncycastle.jce.exception.ExtCertPathBuilderException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic02_selenium_locator {

    WebDriver driver;
    String fullName = "Selenium Locator";

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test
    public void TC_01_ID() throws InterruptedException {
        driver.findElement(By.id("small-searchterms")).sendKeys("Macbook");
        Thread.sleep(3000);
        driver.findElement(By.id("FirstName")).sendKeys("Automation");
        Thread.sleep(3000);
    }

    @Test
    public void TC_02_Class() throws InterruptedException {
        // Nó k lấy hết toàn bộ giá trị ( nếu có khoảng trắng )
        // Nếu giá trị mà k có khoảng trắng thì lấy toàn bộ, có khoảng trắng thì lấy 1 phần (lấy phần nào là duy nhất )
        driver.findElement(By.className("register-next-step-button")).click();
        Thread.sleep(3000);
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("Company"));
        driver.findElement(By.name("Password"));

    }
    @Test
    public void TC_04_Linktext() {
      // Chỉ làm việc với element là link và có text
        // Thẻ a và thuộc tính href ( hiển thị icon hình bàn tay)
        // Phải lấy hết toàn bộ text
       driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.linkText("Wishlist"));

    }
    @Test
    public void TC_05_Partial_Link_Text() {
        // Chỉ làm việc với element là link
        // Có thể lấy toàn bộ text hoặc 1 phần ( hay dùng )
        driver.findElement(By.partialLinkText("Register"));
        driver.findElement(By.partialLinkText("Digital"));


    }
    @Test
    public void TC_06_Tagname() {
        // Tên thẻ ( HTML )
        // Tìm tất cả các element giống nhau ( thẻ của component gống nhau )
        // Tất cả các textbox/checkbox/radio...
        driver.findElement(By.tagName("button"));
        driver.findElement(By.tagName("input"));
    }
    @Test
    public void TC_07_Css() {
        // Css có thể cover được 6 loại ở trên
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#Company"));
        driver.findElement(By.cssSelector("input[id='Company']"));
        driver.findElement(By.cssSelector("button.register-next-step-button"));
        driver.findElement(By.cssSelector("button[class='button-1 register-next-step-button']"));
    }
    @Test
    public void TC_08_Xpath() {
        // Css có thể cover được 7 loại ở trên
        driver.findElement(By.xpath("//input[@id='Company']"));
        driver.findElement(By.xpath("//button[@class='button-1 register-next-step-button']"));
    }
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}