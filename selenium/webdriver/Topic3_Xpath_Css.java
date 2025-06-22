package webdriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic3_Xpath_Css {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        // arrange
        driver = new FirefoxDriver();
        driver.get("http://live.techpanda.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void Register_01_Emty_Data(){
        driver.get("http://alada.vn/tai-khoan/dang-ky.html");
        // action
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify với dữ liệu mong đợi
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
    }
    @Test
    public void Register_02_Invalid_Email(){
        driver.get("http://alada.vn/tai-khoan/dang-ky.html");
        //action
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe bidden");
        driver.findElement(By.id("txtEmail")).sendKeys("@123@455");
        driver.findElement(By.id("txtCEmail")).sendKeys("@123@455");
        //..
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // assert verify
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập lại email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại email hợp lệ");

    }
    @Test
    public void Register_03_Incorrect_Confirm_Email(){
        driver.get("http://alada.vn/tai-khoan/dang-ky.html");
        //action
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe bidden");
        driver.findElement(By.id("txtEmail")).sendKeys("ntam37285@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("ntam37286@gmail.com");
        //..
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // assert verify
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }
    @Test
    public void Register_04_Invalid_Password(){
        driver.get("http://alada.vn/tai-khoan/dang-ky.html");
        //action
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe bidden");
        driver.findElement(By.id("txtEmail")).sendKeys("ntam37285@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("ntam37285@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("1234");
        //..
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // assert verify
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
    }
    @Test
    public void Register_05_Incorrect_Confirm_Password(){
        driver.get("http://alada.vn/tai-khoan/dang-ky.html");
        //action
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe bidden");
        driver.findElement(By.id("txtEmail")).sendKeys("ntam37285@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("ntam37285@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123457");
        //..
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // assert verify
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");

    }
    @Test
    public void Register_06_Invalid_Phone_Number(){
        driver.get("http://alada.vn/tai-khoan/dang-ky.html");
        //action
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe bidden");
        driver.findElement(By.id("txtEmail")).sendKeys("ntam37285@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("ntam37285@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("123456");
        //..
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // assert verify
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }
}
