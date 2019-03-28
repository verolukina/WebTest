import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest {
    public WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "\\Users\\vlukina.REKSOFT\\Downloads\\Telegram Desktop\\WebTest2\\WebTest\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testSearch() {
        driver.get("http://www.cnn.com/");
        WebElement searchButton = driver.findElement(By.id("menu"));
        searchButton.click();
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.click();
        searchBox.sendKeys("NFLFake");
        searchBox.submit();

        Assert.assertTrue(
                "Results are found",
                findElement()
        );
    }

    public boolean findElement(){
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[2]/div/div[3]/div/h3"));
        return errorMessage.isDisplayed();
    }
}
