import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class LocatorTypes {

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

    @Test(priority = 1)
    public void navigateToURL() {

        Assert.assertEquals(driver.getTitle(),"Madison Island");
    }

    @Test(priority = 2)
    public void byIdLocatorExample(){
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.clear();
        searchBox.sendKeys("Bags");
        searchBox.submit();
        Assert.assertEquals(driver.getTitle(),"Search results for: 'Bags'");
    }

    @Test(priority = 2)
    public void byNameLocatorExample(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("Phones");
        searchBox.submit();
        Assert.assertEquals(driver.getTitle(),"Search results for: 'Phones'");
    }

    @Test(priority = 2)
    public void byClassNameLocatorExample(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("Electronics");
        WebElement searchButton = driver.findElement(By.className("search-button"));
        searchButton.click();
        Assert.assertEquals(driver.getTitle(),"Search results for: 'Electronics'");
    }

    @Test(priority = 3)
    public void byLinkTestLocatorExample(){
        WebElement myAccountLink = driver.findElement(By.linkText("MY ACCOUNT"));
        myAccountLink.click();
        Assert.assertEquals(driver.getTitle(),"Customer Login");
    }

    @Test(priority = 3)
    public void byPartialLinkTestLocatorExample(){
        WebElement privacyLink = driver.findElement(By.partialLinkText("PRIVACY"));
        privacyLink.click();
        Assert.assertEquals(driver.getTitle(),"Privacy Policy");
    }

    @Test(priority = 1)
    public void byTagNameLocatorExample(){
        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Found Links: "+links.size());

        links.stream()
                .filter(webElement -> webElement.getText().length()>0)
                .forEach(webElement -> System.out.println(webElement.getText()));
    }

    @Test(priority = 2)
    public void byXpathLocatorExample(){
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search']"));
        searchBox.sendKeys("Bags");
        searchBox.submit();
        Assert.assertEquals(driver.getTitle(),"Search results for: 'Bags'");
    }

    @Test(priority = 2)
    public void byCSSSelectorLocatorExample(){
        WebElement searchBox = driver.findElement(By.cssSelector("#search"));
        searchBox.sendKeys("Bags");
        searchBox.submit();
        Assert.assertEquals(driver.getTitle(),"Search results for: 'Bags'");
    }

    @Test
    public void byCSSSelectorLocatorExample1(){
        WebElement aboutUs = driver.findElement(By.cssSelector("a[href*='/about-magento-demo-store/'"));
        aboutUs.click();
        Assert.assertEquals(driver.getTitle(),"About Us");
    }

    @AfterTest
    public void afterMethod(){
        driver.quit();
    }
}
