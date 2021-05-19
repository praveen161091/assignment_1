import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Properties;
public class PropReader {
    private static PropReader instance = null;
    static Properties prop = null;
    static FileInputStream in = null;
    private PropReader() {

        try {
             in = new FileInputStream("C:\\Users\\praveenkumar\\IdeaProjects\\Assignment1\\test1\\repository.properties");
            prop = new Properties();
            prop.load(in);

        }
        catch (Exception e) {

            System.out.println(e);
        }
    }
    public static PropReader getInstance() throws IOException {

        if (instance == null) {
            instance = new PropReader();
        }

        return instance;
    }
   /* public static PropReader launchBrowser(){
        System.setProperty(prop.getProperty("driver"), prop.getProperty("driverPath"));
        ChromeDriver driver = new ChromeDriver();
        return  driver;
    }*/

}
