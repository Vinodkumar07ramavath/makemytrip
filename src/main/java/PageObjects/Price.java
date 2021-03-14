package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class Price {
    WebDriver driver;
    public Price(WebDriver driver) throws IOException {
        this.driver=driver;
    }
    By booknow=By.cssSelector("div[class='splitviewSticky makeFlex']");
    By clickBooknow=By.xpath("//*[@id='root']/div/div[2]/div[3]/div/div[2]/div/div/div/div[3]/div[1]/div[3]/div/div[2]");
    By continuebutton=By.cssSelector("div[class='multifareFooter']");
    By clickbutton=By.cssSelector("button[class='buttonPrimary buttonBig  lato-black button']");
    By clickYes=By.xpath("//*[@id='insurance-section']/div/div[3]/label[1]/span[2]");
    By clickProceed=By.cssSelector("div[class='append_bottom15 make_relative blocked_traveller_booking']");
    By proceed=By.cssSelector("button[class='fli_primary_btn btn text-uppercase continue_cta ']");
    public WebElement BookNow(){ return driver.findElement(booknow); }
    public WebElement ClickBooknow(){return driver.findElement(clickBooknow);}
    public WebElement ContinueButton(){ return driver.findElement(continuebutton);}
    public WebElement ClickButton(){return driver.findElement(clickbutton);}
    public WebElement ClickYes(){ return driver.findElement(clickYes);}
    public WebElement ClickProceed(){ return driver.findElement(clickProceed);}
    public WebElement Proceed(){return driver.findElement(proceed);}
}
