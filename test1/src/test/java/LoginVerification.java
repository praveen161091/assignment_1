import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class LoginVerification {


    @Test
    public void loginTest() throws Exception {


        PropReader singleton = PropReader.getInstance();
        System.setProperty(singleton.prop.getProperty("driver"), singleton.prop.getProperty("driverPath"));
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.gmail.com/");
        driver.findElement(By.xpath(singleton.prop.getProperty("userid"))).sendKeys("praveenkumar.1610@gmail.com");
        driver.findElement(By.xpath(singleton.prop.getProperty("next"))).click();
        driver.findElement(By.xpath(singleton.prop.getProperty("password"))).sendKeys("abcd");
        driver.findElement(By.xpath(singleton.prop.getProperty("next1"))).click();
        driver.close();


    }

    @Test
    public void linkTest() throws Exception {


        PropReader singleton = PropReader.getInstance();
        System.setProperty(singleton.prop.getProperty("driver"), singleton.prop.getProperty("driverPath"));
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath(singleton.prop.getProperty("link"))).click();
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Gmail - Free Storage and Email from Google";
        Assert.assertEquals(expectedTitle, actualTitle);
        driver.close();


    }

    @Test
    public void urlNavigation() throws Exception {

        PropReader singleton = PropReader.getInstance();
        System.setProperty(singleton.prop.getProperty("driver"), singleton.prop.getProperty("driverPath"));
        ChromeDriver driver = new ChromeDriver();
        //   PropReader driver=PropReader.launchBrowser();
        driver.get("https://www.geeksforgeeks.org/");
        driver.close();

    }

    @Test
    public void menuDropDown() throws Exception {

        PropReader singleton = PropReader.getInstance();
        System.setProperty(singleton.prop.getProperty("driver"), singleton.prop.getProperty("driverPath"));
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.iitd.ac.in/");
        WebElement element = driver.findElement(By.xpath(singleton.prop.getProperty("menu")));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        driver.findElement(By.linkText("DOS")).click();
        driver.close();

    }


    @Test
    public void checkBoxValidation() throws Exception {
        PropReader singleton = PropReader.getInstance();
        System.setProperty(singleton.prop.getProperty("driver"), singleton.prop.getProperty("driverPath"));
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/radio.html");
        WebElement element1 = driver.findElement(By.xpath(singleton.prop.getProperty("checkbox1")));
        element1.click();
        if(element1.isSelected()){
            System.out.println("CheckBox Is Selected ");
        }else
        {
            System.out.println("CheckBox Is Not Selected ");
        }
    }

    @Test
    public void responseValidte() throws Exception{
        PropReader singleton = PropReader.getInstance();
        System.setProperty(singleton.prop.getProperty("driver"), singleton.prop.getProperty("driverPath"));
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://stackoverflow.com/");
        driver.findElement(By.xpath(singleton.prop.getProperty("login"))).click();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(singleton.prop.getProperty("url"), actualURL);
        driver.close();





    }
}

