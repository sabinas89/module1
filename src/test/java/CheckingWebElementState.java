import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckingWebElementState {

    WebDriver driver;

    @BeforeTest
    public void beforeMethod(){
        //System.out.println(System.getenv("SE_HOME"));
        System.setProperty("webdriver.chrome.driver",System.getenv("SE_HOME")+"/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://demo-store.seleniumacademy.com/");
    }

    @Test
    public void elementIsDisplayedExample(){
        WebElement searchBox = driver.findElement(By.name("q"));
        System.out.println("Search Box is Displayed: "+searchBox.isDisplayed());
    }

    @Test
    public void elementIsEnabledExample(){
        WebElement searchButton = driver.findElement(By.className("search-button"));
        System.out.println("Search Box is Enabled: "+searchButton.isEnabled());
    }

    @Test
    public void elementIsSelectedExample(){
        WebElement searchBox = driver.findElement(By.name("q"));
        // isSelected() can be used only on Radio buttons, options in select and checkbox web elements
        System.out.println("Search Box is Selected: "+searchBox.isSelected());
    }

    @AfterTest
    public void afterMethod(){
        driver.quit();
    }
}
