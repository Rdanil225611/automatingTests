import javafx.scene.control.DatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private final Wait<WebDriver> wait;


    @FindBy(xpath = "//*[@id=\"select-lang\"]")
    private WebElement language;

    @FindBy(id = ("OriginLocation_Combobox"))
    private WebElement fromWay;

    @FindBy(id = "DestinationLocation_Combobox")
    private WebElement toWay;

    @FindBy(xpath = "//*[@id=\"step-2\"]/div[4]/div/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"step-2\"]/div[2]/div[1]/div/a")
    private WebElement departureDate;

    @FindBy(xpath = "//*[@id=\"step-2\"]/div[2]/div[2]/div/a")
    private WebElement returnDate;

    @FindBy(id = "calendar")
    private WebElement datePickerBookFlights;

   @FindBy(xpath = "//*[@id=\"ui-id-1\"]")
   private WebElement passengers;

    @FindBy(xpath = "//*[@id=\"Passengers\"]/div/div[2]/a[2]")
    private WebElement incrementChildren;


    private WebDriver driver;
    private WebElement date;
    private RemoteWebDriver remoteDriver;
    private WebElement flightSelection;

    public HomePage(WebDriver driver1){
        this.driver = driver1;
        PageFactory.initElements(this.driver,this);
        wait = new WebDriverWait(this.driver,1);
        remoteDriver =(RemoteWebDriver) this.driver;

    }
    void open(){
        driver.get("https://belavia.by/");
        driver.manage().window().maximize();
    }
    void close(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.close();
    }
    void setEnglishPage(){
        language.click();
        WebElement englishLang = driver.findElement(By.xpath("//*[@id=\"lang-menu\"]/div/ul/li[1]/a"));
        englishLang.click();
    }
    void setFromWay(String data){
      fromWay.sendKeys(data);
      //fromWayHidden.sendKeys("MSQ");
        String s1="document.getElementById('OriginLocation').value='MSQ'";
        remoteDriver.executeScript(s1);
    }
    void setToWay(String data) {
        toWay.sendKeys(data);
        //toWayHidden.sendKeys("LWO");
        String s1="document.getElementById('DestinationLocation').value='LWO'";
        remoteDriver.executeScript(s1);
    }
    void setDepartureDate() throws InterruptedException {
       departureDate.click();
       date = driver.findElement(By.xpath("//*[@id=\"calendar\"]/div/div[2]/table/tbody/tr[2]/td[1]/a"));
       date.click();
    }
    void setReturnDate() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(datePickerBookFlights));
        date = driver.findElement(By.xpath("//*[@id=\"calendar\"]/div/div[2]/table/tbody/tr[2]/td[1]/a"));
        date.click();

    }
    void setPassengers(){
        passengers.click();
        incrementChildren.click();

    }
    String searchButtonClick(){
        searchButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(By.xpath("//*[@id=\"body\"]/div/div[2]/div/form/div[1]/div[1]/div[2]")).getText(); // Minsk - Lviv

    }




}
