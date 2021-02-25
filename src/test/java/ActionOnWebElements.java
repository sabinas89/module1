import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionOnWebElements {

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
    public void elementSendKeysCompositeExample(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(Keys.chord(Keys.SHIFT,"phones"));
        searchBox.submit();
        Assert.assertEquals(driver.getTitle(),"Search results for: 'PHONES'");
    }

    @Test
    public void elementClearExample(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(Keys.chord(Keys.SHIFT,"phones"));
        searchBox.sendKeys(Keys.BACK_SPACE);
        // same as searchBox.clear()
        // Question: will it clear complete string or just the last character, in this case 's'???
    }

    @Test
    public void elementSubmitExampleWithoutException(){
        // WebElement searchBox is part of Form element, therefore no exception will be thrown
        // submit() is applicable only on WebElements which as inside a Form element or on a Form

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(Keys.chord(Keys.SHIFT,"phones"));
        searchBox.submit();
    }

    @Test
    public void elementSubmitExampleWithException(){
        // Below code will throw NoSuchElementException
        try {
            WebElement aboutUsLink = driver.findElement(By.linkText("MY ACCOUNT"));
            aboutUsLink.submit();
        } catch (JavascriptException | NoSuchElementException e){
            System.out.println("Element is not a form");
        }
    }

    @AfterTest
    public void afterMethod(){
        driver.quit();
    }
}
