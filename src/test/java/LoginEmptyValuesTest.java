import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginEmptyValuesTest {

    @Test
    public void checkLoginFields() throws InterruptedException {
        LoginEmptyValues instance = new LoginEmptyValues();
        String actual = instance.checkLoginFields();
        assertEquals(actual, "Войти");
    }
}