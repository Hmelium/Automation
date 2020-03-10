import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest {

  public WebDriver driver;

  @BeforeTest
  public void init(){
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.addArguments("enable-automation");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-infobars");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-browser-side-navigation");
    options.addArguments("--disable-gpu");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @AfterTest
  public  void close(){
    driver.quit();
  }
}
