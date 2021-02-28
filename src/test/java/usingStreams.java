import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class usingStreams {
    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        //System.out.println(System.getenv("SE_HOME"));
        System.setProperty("webdriver.chrome.driver", System.getenv("SE_HOME") + "/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://demo-store.seleniumacademy.com/");
    }

    @Test
    public void linksTest() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Links count: " + links.size());

        long count = links.stream().filter(item -> item.isDisplayed()).count();
        System.out.println("Links count: " + count);
    }

    @Test
    public void imgAltTest() {
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Image count: " + images.size());

        List<WebElement> imagesWithoutAlt = images.stream()
                .filter(item -> item.getAttribute("alt") == "")
                .collect(Collectors.toList());

        System.out.println("Images without Alt count: " + imagesWithoutAlt);
    }

    @Test
    public void searchProduct() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Phones");

        WebElement searchButton = driver.findElement(By.className("search-button"));
        searchButton.click();

        assertThat(driver.getTitle())
                .isEqualTo("Search results for: 'Phones'");

        List<WebElement> searchItems = driver.findElements(By.tagName("a"));

        List<String> expectedProductNames = Arrays.asList("MADISON EARBUDS",
                "MADISON OVEREAR HEADPHONES",
                "MP3 PLAYER WITH AUDIO");

        List<String> productNames = searchItems.stream()
                .map(item->item.getText())
                .collect(Collectors.toList());

        assertThat(productNames)
                .isEqualTo(expectedProductNames);

    }

    @Test
    public void searchAndViewProduct(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Phones");
        searchBox.submit();

        assertThat(driver.getTitle())
                .isEqualTo("Search results for: 'Phones'");

        List<WebElement> searchItems = driver.findElements(By.tagName("a"));
        WebElement product = searchItems.stream()
                .filter(item->item.getText().equalsIgnoreCase("ABOUT US"))
                .findFirst()
                .get();

        product.click();

        assertThat(driver.getTitle())
                .isEqualTo("About Us");

    }

    @AfterTest
    public void afterMethod() {
        driver.quit();
    }
}
