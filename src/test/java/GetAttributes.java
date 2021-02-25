import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetAttributes {

    WebDriver driver;

    @BeforeTest
    public void beforeMethod(){
        //System.out.println(System.getenv("SE_HOME"));
        System.setProperty("webdriver.chrome.driver",System.getenv("SE_HOME")+"/chromedriver.exe");
        driver = new ChromeDriver();
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
        
    }

    @AfterTest
    public void afterMethod(){
        driver.quit();
    }
}
