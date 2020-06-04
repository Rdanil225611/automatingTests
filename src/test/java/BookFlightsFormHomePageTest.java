import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.opera.OperaDriver;

import static org.junit.Assert.*;

public class BookFlightsFormHomePageTest {
    HomePage driver = new HomePage(new OperaDriver());

    @Test
    public void CorrectDataBookFlightsForm() throws InterruptedException {

        driver.open();
        driver.setEnglishPage();
        driver.setFromWay("Minsk (MSQ), BY");
        driver.setToWay("Lviv (LWO), UA");
        driver.setDepartureDate();
        driver.setReturnDate();
        String actual = driver.searchButtonClick();
        driver.close();

        Assert.assertEquals("Minsk - Lviv", actual);


    }

    @Test
    public void setChildrenWithoutParent() throws InterruptedException {

        driver.open();
        driver.setEnglishPage();
        driver.setFromWay("Minsk (MSQ), BY");
        driver.setToWay("Lviv (LWO), UA");
        driver.setDepartureDate();
        driver.setReturnDate();
        driver.setPassengers();
        String actual = driver.searchButtonClick();
        driver.close();
        Assert.assertEquals("Minsk - Lviv", actual);

    }

}