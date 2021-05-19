import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    public static void main(String [] args){
        try {
            Properties prop = new Properties();
            InputStream input = new FileInputStream("repository.properties");
            // load a properties file
            prop.load(input);
        }catch(Exception  e)
        {
            System.out.println(e);
        }
    }



}
