import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationTest {

    WebDriver driver;

    @BeforeTest
    public void beforeMethod(){
        System.out.println(System.getenv("SE_HOME"));
        System.setProperty("webdriver.chrome.driver",System.getenv("SE_HOME")+"/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void navigateToURL() {
        driver.get("https://www.google.com");
        Assert.assertEquals(driver.getTitle(),"Google");
    }


    @AfterTest
    public void afterMethod(){
        driver.quit();
    }
}
