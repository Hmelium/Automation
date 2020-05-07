import core.DriverInitializer;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
  static WebDriver driver;

  @AfterMethod
  public static void cleanup() {
    driver.quit();
  }

  @BeforeMethod
  public void navigate() {
    driver = DriverInitializer.setUp();
    driver.manage().window().maximize();
    driver.get(DriverInitializer.getProperty("url"));
  }
}
