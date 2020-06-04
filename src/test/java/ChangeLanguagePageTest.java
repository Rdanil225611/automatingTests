import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeLanguagePageTest {

    @Test
    public void checkChangeLanguagePage() throws InterruptedException {
        ChangeLanguagePage instance = new ChangeLanguagePage();
        String actual = instance.checkChangeLanguagePage();
        assertEquals(actual, "Hotels");
    }
}