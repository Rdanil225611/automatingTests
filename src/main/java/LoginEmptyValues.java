import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class LoginEmptyValues {

    public String checkLoginFields() throws InterruptedException {
        WebDriver webDriver = new OperaDriver();
        webDriver.get("https://belavia.by/");
        String result;

        try {
            WebElement loginLink = webDriver.findElement(By.xpath("//*[@id=\"select-member\"]"));
            loginLink.click();
            WebElement submit = webDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/ul/li[2]/div/div/div/form/div[4]/div[1]/button"));
            submit.click();
            result = webDriver.findElement(By.xpath("//*[@id=\"select-member\"]/span[2]")).getText();

        } finally {
            Thread.sleep(3000);
            webDriver.close();
        }
        return  result;

    }
}
