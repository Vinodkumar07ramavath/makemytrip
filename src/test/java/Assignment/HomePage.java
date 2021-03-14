package Assignment;
import PageObjects.CliclonFlight;
import PageObjects.ExcelData1;
import PageObjects.Price;
import PageObjects.TravelDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class HomePage extends Base {
    ExcelData1 ed=new ExcelData1();
    public static Logger log= LogManager.getLogger(Base.class.getName());
    @BeforeTest
    public void LandingPage() throws IOException, InterruptedException {
        driver = initializeDriver();
        CliclonFlight cf=new CliclonFlight(driver);
        log.info("driver is initialized");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/flights/");
        log.info("Browser is opened");
        Thread.sleep(2000);
    }
    @Test
    public void FromTo() throws IOException, InterruptedException {
        CliclonFlight cf=new CliclonFlight(driver);
        ArrayList<String> data=ed.getData("From City");
        ArrayList<String> data1=ed.getData("Destinations");
        cf.From().click();
        cf.FromEnter().sendKeys(data.get(1));
        cf.FromEnter().sendKeys(Keys.ARROW_DOWN);
        cf.FromEnter().sendKeys(Keys.ENTER);
        cf.TO().click();
        cf.ToEnter().sendKeys(data1.get(1));
        Thread.sleep(2000);
        cf.ToEnter().sendKeys(Keys.ARROW_DOWN);
        cf.ToEnter().sendKeys(Keys.ENTER);
        cf.Departure().click();
        cf.DepartureDate().click();
        cf.ReturnClick().click();
        cf.ReturnDate().click();
        cf.Search().click();
    }
    @Test
    public void PriceSelect() throws IOException, InterruptedException {
        Price p = new Price(driver);
        p.BookNow().click();
        p.ClickBooknow().click();
        Thread.sleep(5000);
        p.ContinueButton().click();
        Thread.sleep(4000);
        p.ClickButton().click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iter = windows.iterator();
        String mainWindow = iter.next();
        String childWindow = iter.next();
        driver.switchTo().window(childWindow);
        p.ClickYes().click();
//        p.ClickProceed().click();
        Thread.sleep(1000);
        p.Proceed().click();
        Thread.sleep(2000);
        TravelDetails td = new TravelDetails(driver);
        ArrayList<String> data = ed.getData("First and middle name");
        ArrayList<String> data1 = ed.getData("LastName");
        ArrayList<String> data2 = ed.getData("Gender");
        td.FirstName().sendKeys(data.get(1));
        td.LastName().sendKeys(data1.get(1));
        td.Male().click();
    }
}