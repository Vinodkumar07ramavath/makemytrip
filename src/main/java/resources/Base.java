package resources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class Base
{
    public WebDriver driver;
  public WebDriver initializeDriver() throws IOException {
      Properties prop=new Properties();
      FileInputStream fis=new FileInputStream("C:\\Users\\india\\IdeaProjects\\Assignments\\src\\main\\java\\resources\\data.properties");
      prop.load(fis);
      String browserName=prop.getProperty("browser");
      if(browserName.equals("chrome")){
          System.setProperty("webdriver.chrome.driver","C://Program Files//chromeDriver.exe");
          driver=new ChromeDriver();
      }
      else if(browserName.equals("firefox")){
          System.setProperty("webdriver.gecko.driver","C://woProgram Filesrk//geckodriver.exe");
          driver=new FirefoxDriver();
      }
      else if(browserName.equals("IE")){
          System.setProperty("webdriver.ie.driver","C://Program Files//IEDriverServer.exe");
          driver=new InternetExplorerDriver();
      }
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      return driver;
  }
}
