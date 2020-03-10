import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BaseTest extends GoogleTest {

  final String expectedLink = "www.softserveinc.com";
  @Test
  public void initialDriver(){
    driver.get("https://www.google.com/");
    WebElement searchField = driver.findElement(By.xpath(" //input[@name='q']"));
    searchField.sendKeys("softserve");
    searchField.submit();
    List<WebElement> searchResults = driver.findElements(By.cssSelector("cite"));
    Assert.assertEquals(searchResults.get(0).getText(), expectedLink);
  }
}
