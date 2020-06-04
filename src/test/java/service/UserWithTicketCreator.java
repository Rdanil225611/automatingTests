package service;

import model.UserWithTicket;
public class UserWithTicketCreator {

    private static final String TESTDATA_USER_CODE = "testdata.user.code";
    private static final String TESTDATA_USER_LASTNAME = "testdata.user.lastname";

    public static UserWithTicket wrongUserCode(){
        return new UserWithTicket(TestDataReader.getTestData(TESTDATA_USER_CODE), TestDataReader.getTestData(TESTDATA_USER_LASTNAME));
    }
}
