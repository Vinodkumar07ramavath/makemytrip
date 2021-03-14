package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.List;
public class CliclonFlight {
    WebDriver driver;
    public CliclonFlight(WebDriver driver) throws IOException {
        this.driver=driver;
    }
    By login=By.cssSelector("li[class='makeFlex hrtlCenter font10 makeRelative lhUser ']");
    By from= By.xpath("//*[@id='root']/div/div[2]/div/div[1]/div[2]/div[1]/div[1]/label/span");
    By to=By.xpath("//*[@id='root']/div/div[2]/div/div[1]/div[2]/div[1]/div[2]/label/span");
    By fromEnter=By.cssSelector("input[placeholder='From']");
    By toEnter=By.cssSelector("input[placeholder='To']");
    By departure=By.xpath("//*[@id='root']/div/div[2]/div/div[1]/div[2]/div[1]/div[3]/label/span");
    By departureDate=By.cssSelector("div[aria-label='Fri Mar 26 2021']");
    By returnclick=By.xpath("//*[@id='root']/div/div[2]/div/div[1]/div[2]/div[1]/div[4]/div/label/span");
    By returnDate=By.cssSelector("div[aria-label='Sat Mar 27 2021']");
    By search=By.cssSelector("a[class='primaryBtn font24 latoBold widgetSearchBtn ']");
    public WebElement From(){
        return driver.findElement(from);
    }
    public WebElement FromEnter(){
        return driver.findElement(fromEnter);
    }
    public WebElement TO(){
        return driver.findElement(to);
    }
    public WebElement ToEnter(){
        return driver.findElement(toEnter);
    }
    public WebElement Departure(){
        return driver.findElement(departure);
    }
    public WebElement DepartureDate(){return driver.findElement(departureDate);}
    public WebElement ReturnClick(){return driver.findElement(returnclick);}
    public WebElement ReturnDate(){return driver.findElement(returnDate);}
    public WebElement Search(){return driver.findElement(search);}
    public WebElement Login(){return driver.findElement(login);}
}
