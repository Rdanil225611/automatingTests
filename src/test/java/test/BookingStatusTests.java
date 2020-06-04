package test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.UserWithTicketCreator;
import model.UserWithTicket;

import java.sql.DriverManager;

public class BookingStatusTests extends CommonCondition{

    @Test
    public void ticketWithWrongUserData() {
        UserWithTicket userWithTicket = UserWithTicketCreator.wrongUserCode();
        String actual = new HomePage(driver)
                .openPage()
                .bookingStatusButtonClick()
                .setBookingStatusForm(userWithTicket)
                .searchBookFligthButton();
        Assert.assertEquals(actual,"Бронирование не найдено");

    }

}
