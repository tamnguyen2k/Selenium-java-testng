package javaSDET;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.ArrayList;

public class Topic01_Datatype {
    //2 nhóm kiểu dữ liệu
    //cách khai báo
    //Access modifier phạm vi truy cập (private/public/protected/default)

    //cách 1: Access Modifier - kiểu dữ liệu - tên biến - giá trị của biến ( ngoài hàm/trong hàm)
    public char cName='b';

    //cách 2.1 - Access Modifier - kiểu dữ liệu - tên biến
    private char cAddress;

    //cách 2.2 tên biến - giá trị gán sau ( hàm)
     public void clickToElement(){
         cAddress = 'c';
     }

    //nhóm 1 kiểu dữ liệu nguyên thủy/ prinitive  type
    //char (ký tự) : khi khởi tạo nằm trong dấu ''
    char cZip = 'b';
    //số nguyên: byte/short/int/long:: số nguyên, khi khởi tạo k nằm trong dấu gì
    byte bNumber = 120;
    short iNumber = 3500;
    long lNumber = 3456666;
    //số thực: float/double. khi khởi tạo k nằm trong dấu gì
    float fNumber = 13.5f;
    double dNumber = 22.343d;
    //Logic: boolean. khi khởi tạo k nằm trong dấu gì
    boolean gender = false;
    //nhóm 2 kiểu dữ lệu tham chiếu/reference type/non prinitive
    //string. khi gán giá trị nằm trong dấu ""
    String fullName = "Automation FC";
    //class
    FirefoxDriver fDriver = new FirefoxDriver();
    Actions action = new Actions(fDriver);
    Topic01_Datatype topic01 = new Topic01_Datatype();
    //Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    //Array
    String[] studenName = {"Hiền", "Nam", "An"};
    int[] studenPhone = {98754588, 333687181, 234466789};
    //List/Set/Queue
    //Map
    //Object
    Object name = "tâm";
    Object phone = 234;
    Object isDisplay = true;
    //convention: quy tắc khi lập trình
    // tên biến/tên hàm: viết dưới dạng camel case
    // khi viết 1 tên biến thì chữ cái đầu tiên luôn viết thường, chữ cái tiếp theo luôn viết hoa
    // name/address/city/zipCode
    //clickToElement/getUserName/getPhoneNumber
}
