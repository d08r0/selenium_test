package erik.indahouse;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by scrooge on 20.01.18.
 */
public class FrontTest {

    private String searchText = "Куда плыть?";

    @Test
    public void TestTitle() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.yandex.ru");
        System.out.println("Заголовок до поиска: " + driver.getTitle());
        WebElement searchString = driver.findElement(By.id("text"));
        searchString.sendKeys(searchText);
        WebElement searchButton = driver.findElement(By.className("button_theme_websearch"));
        searchButton.submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertThat(driver.getTitle()).startsWith(searchText);
        System.out.println("Заголовок после поиска: " + driver.getTitle());
        driver.quit();
    }

}
