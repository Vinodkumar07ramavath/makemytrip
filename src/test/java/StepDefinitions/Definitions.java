package StepDefinitions;

import PageObjects.CliclonFlight;
import PageObjects.ExcelData1;
import PageObjects.Price;
import PageObjects.TravelDetails;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import resources.Base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Definitions extends Base {
    ExcelData1 ed=new ExcelData1();
    public static Logger log= LogManager.getLogger(Base.class.getName());
    @Given("^Navigate to (.+)$")
    public void navigate_to(String url) throws Throwable {
        driver = initializeDriver();
        CliclonFlight cf=new CliclonFlight(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/flights/");
        Thread.sleep(2000);
    }

    @When("^Select the from and To city and enter the date aswell and click the search button$")
    public void select_the_from_and_to_city_and_enter_the_date_aswell_and_click_the_search_button() throws Throwable {
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

    @Then("^print the flight booking is succesfully done$")
    public void print_the_flight_booking_is_succesfully_done() throws Throwable {
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

    @And("^click on th booknow and continue for next process and switch to next child window and continue and enter the personal deatils which are reqired$")
    public void click_on_th_booknow_and_continue_for_next_process_and_switch_to_next_child_window_and_continue_and_enter_the_personal_deatils_which_are_reqired() throws Throwable {
        log.info("the flight is succesfully bpooked");
    }
}
