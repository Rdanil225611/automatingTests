import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

public class ChangeLanguagePage {

    public String checkChangeLanguagePage() throws InterruptedException{
        WebDriver webDriver = new OperaDriver();
        webDriver.get("https://belavia.by/");
        String hotels;

        try {
            WebElement language = webDriver.findElement(By.xpath("//*[@id=\"select-lang\"]"));
            language.click();
            WebElement english = webDriver.findElement(By.xpath("//*[@id=\"lang-menu\"]/div/ul/li[1]/a"));
            english.click();
            hotels = webDriver.findElement(By.xpath("//*[@id=\"navtab\"]/ul/li[4]/a")).getText();
        } finally {
            Thread.sleep(3000);
            webDriver.close();
        }
        return hotels;
    }
}
