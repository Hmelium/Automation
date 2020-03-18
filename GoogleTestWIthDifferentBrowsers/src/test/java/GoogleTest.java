import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleTest extends BaseTest {

  private final String expectedLink = "www.softserveinc.com › en-us";
  private final String expectedURL = "https://www.softserveinc.com/en-us";
  private final String url = "https://google.com";

  @Test
  public void ChromeTest(){
    initializeWebDriver(DriverType.CHROME);
    driver.get(url);
    WebElement searchField = driver.findElement(By.xpath(" //input[@name='q']"));
    searchField.sendKeys("SoftServe");
    searchField.submit();
    WebElement searchResult = driver.findElements(By.cssSelector("cite")).get(0);
    Assert.assertEquals(searchResult.getText(), expectedLink);

    searchResult.click();
    Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
  }

  @Test
  public void IETest(){
    initializeWebDriver(DriverType.IE);
    driver.manage().window().fullscreen();
    driver.navigate().to(url);
    WebElement searchField = driver.findElement(By.xpath(" //input[@name='q']"));
    searchField.sendKeys("SoftServe");
    searchField.submit();
    WebElement searchResult = driver.findElements(By.cssSelector("cite")).get(0);
    Assert.assertEquals(searchResult.getText(), expectedLink);

    searchResult.click();
    Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
  }
}
