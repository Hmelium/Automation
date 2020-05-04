import core.DriverInitializer;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {
  static WebDriver driver;

  @BeforeTest
  public static void setup() {
    driver = DriverInitializer.setUp();
  }

  @AfterTest
  public static void cleanup() {
    driver.quit();
  }

  @BeforeClass
  public void navigate() {
    driver.get(DriverInitializer.getProperty("url"));
  }
}
