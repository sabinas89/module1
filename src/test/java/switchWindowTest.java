import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class switchWindowTest {

    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", System.getenv("SE_HOME") + "/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.get("http://guidebook.seleniumacademy.com/Window.html");
    }

    @Test
    public void handleWindow() {
        String firstWindow = driver.getWindowHandle();
        System.out.println("First Window Handle is: " + firstWindow);

        WebElement link = driver.findElement(By.linkText("Google Search"));
        link.click();

        String secondWindow = driver.getWindowHandle();
        System.out.println("Second Window Handle is: "+secondWindow);
        System.out.println("Total windows are: "+driver.getWindowHandles().size());
        driver.switchTo().window(firstWindow);
    }

    @AfterMethod
    public void tearDown(){driver.quit();}
}
