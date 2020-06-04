package test;

import model.UserWithTicket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.UserWithTicketCreator;

public class CheckInOnlineTests extends CommonCondition {

    @Test
    public void wrongCheckInOnlineData() {
        UserWithTicket userWithTicket = UserWithTicketCreator.wrongUserCode();
        String actual = new HomePage(driver)
                .openPage()
                .checkInOnlineButtonClick()
                .setCheckInOnlineForm(userWithTicket)
                .checkInRulesCheckBox()
                .searchCheckInClick();

        Assert.assertEquals(actual, "Текст слишком длинный");

    }
}
