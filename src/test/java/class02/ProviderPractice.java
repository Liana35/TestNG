package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProviderPractice {
    //    Test Scenario:
//    navigate to syntax HRMS
//    login into the website using the following credentials and check for correct errors
//    a.username ="Admin"  , password="12345"  ---> Error Message ="Invalid credentials"
//    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
//    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
//    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"



    public static WebDriver driver;

    @DataProvider(name="dataBase")
    public Object[][] data(){
       Object [][] loginData={
               {"Admin", "12345", "Invalid credentials"},
               {"ABCD", "Hum@nhrm123", "Invalid credentials"},
               {"Admin", "", "Password cannot be empty"},
               {"", "Hum@nhrm123", "Username cannot be empty"}

       }; return loginData;
    }

    @Test (dataProvider ="dataBase")
    public void invalidCredentials(String userName, String password, String errorMsg){
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        WebElement error = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualError= error.getText();
        Assert.assertEquals(actualError,errorMsg);
    }



    @BeforeMethod
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
