package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
public class TravelDetails {
    WebDriver driver;
    public TravelDetails(WebDriver driver) throws IOException {
        this.driver=driver;
    }
    By firstName= By.cssSelector("input[placeholder='First & Middle Name']");
    By lastName=By.cssSelector("input[placeholder='Last Name']");
    By female=By.cssSelector("label[tabindex='0']");
    By male=By.cssSelector("label[tabindex='1']");
    public WebElement FirstName(){
        return driver.findElement(firstName);
    }
    public WebElement LastName(){
        return driver.findElement(lastName);
    }
    public WebElement Male(){
        return driver.findElement(male);
    }
    public WebElement Female(){
        return driver.findElement(female);
    }
}
