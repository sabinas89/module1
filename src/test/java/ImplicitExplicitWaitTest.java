import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ImplicitExplicitWaitTest {

    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        //System.out.println(System.getenv("SE_HOME"));
        System.setProperty("webdriver.chrome.driver", System.getenv("SE_HOME") + "/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://demo-store.seleniumacademy.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void explicitWaitTest(){
        WebElement element = (new WebDriverWait(driver,20))
                .until((ExpectedCondition<WebElement>) d -> d.findElement(By.name("q")));
        element.sendKeys("Phones");
        element.click();
        assertThat(driver.getTitle())
                .isEqualTo("Search results for: 'Phones'");
    }
}
