import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetElementProperties {

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
    public void elementGetAttributesExample(){
        WebElement searchBox = driver.findElement(By.name("q"));
        System.out.println("Name of the box is: "+searchBox.getAttribute("name"));
        System.out.println("Id of the box is: "+searchBox.getAttribute("id"));
        System.out.println("Class of the box is: "+searchBox.getAttribute("class"));
        System.out.println("Placeholder of the box is: "+searchBox.getAttribute("placeholder"));
    }

    @Test
    public void elementGetTextExample(){
        WebElement siteNotice = driver.findElement(By.className("global-site-notice"));
        System.out.println("Complete text is: "+siteNotice.getText());
    }

    @Test
    public void elementGetCssValueExample(){
        WebElement searchBox = driver.findElement(By.name("q"));
        System.out.println("Font of the box is: "+searchBox.getCssValue("font-family"));
    }

    @Test
    public void elementGetLocationExample(){
        WebElement searchBox = driver.findElement(By.id("search"));
        System.out.println("Location of the box is: "+searchBox.getLocation());
        // Return type of getLocation() is Point type
    }

    @Test
    public void elementGetSizeExample(){
        WebElement searchBox = driver.findElement(By.name("q"));
        System.out.println("Size of the box is: "+searchBox.getSize());
        // Return type of getSize() is Dimension type
    }

    @Test
    public void elementGetTagNameExample(){
        WebElement searchBox = driver.findElement(By.name("q"));
        System.out.println("HTML Tag of the box is: "+searchBox.getTagName());
    }

    @AfterTest
    public void afterMethod(){
        driver.quit();
    }
}
