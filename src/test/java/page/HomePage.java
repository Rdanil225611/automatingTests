package page;

import model.UserWithTicket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.select.Evaluator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.jws.soap.SOAPBinding;
import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();

    private static final  String baseURL = "https://belavia.by/";
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(xpath = "//*[@id=\"navtab\"]/ul/li[1]/a")
    private WebElement bookFlightButton;

    @FindBy(xpath = "//*[@id=\"navtab\"]/ul/li[3]/a")
    private WebElement bookingStatusButton;

    @FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div[1]/div[2]/a")
    private WebElement supportLink;

    @FindBy(id = "tripCasePnr")
    private WebElement reservationCode;

    @FindBy(id = "wciPnr")
    private WebElement reservationCodeCheckIn;

    @FindBy(id = "wciLastName")
    private WebElement lastnameCheckIn;

    @FindBy(xpath = "//*[@id=\"wci_form\"]/div[2]/div[1]/label")
    private WebElement checkInRulesCheckbox;

    @FindBy(id="wciButton")
    private WebElement searchCheckInButton;

    @FindBy(id = "tripCaseLastName")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"trip-case\"]/form/div[2]/div/button")
    private WebElement searchBookFlightButton;

    @FindBy(xpath = "//*[@id=\"navtab\"]/ul/li[2]/a")
    private WebElement searchCheckInForm;

    String actualResult = null;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HomePage openPage() {
        driver.navigate().to(baseURL);
        logger.info("openPAge");
        return this;
    }

    public HomePage bookingStatusButtonClick() {
        bookingStatusButton.click();
        logger.info("Click by Booking Status button");
        return this;
    }
    public HomePage setBookingStatusForm(UserWithTicket user){
        reservationCode.sendKeys(user.getTicketId());
        lastName.sendKeys(user.getUserLastName());
        logger.info("Booking Status Form - user code : " + user.getTicketId() + " user lastname : " + user.getUserLastName());
        return this;
    }
    public String searchBookFligthButton(){
        searchBookFlightButton.click();
        logger.info("Search button click at Booking Status form");
        System.out.println(driver.getCurrentUrl());
        //wait.until(ExpectedCondition.. findElement(By.id("recordLocator")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actualResult = driver.findElement(By.xpath("//*[@id=\"body\"]/div/div/div/form/div/div[1]/div/div[1]/div/span")).getText(); //Бронирование не найдено
        logger.info("result of wrong Booking Status code : " + actualResult);
        return actualResult;
    }
    public HomePage checkInOnlineButtonClick(){
        searchCheckInForm.click();
        return this;
    }
    public HomePage setCheckInOnlineForm(UserWithTicket user){
        reservationCodeCheckIn.sendKeys(user.getTicketId());
        lastnameCheckIn.sendKeys(user.getUserLastName());
        return this;
    }
    public HomePage checkInRulesCheckBox(){
        checkInRulesCheckbox.click();
        return  this;
    }
    public String searchCheckInClick(){
        searchCheckInButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actualResult = driver.findElement(By.xpath("//*[@id=\"pnr_error\"]")).getText(); //Текст слишком длинный
        return  actualResult;
    }



}
