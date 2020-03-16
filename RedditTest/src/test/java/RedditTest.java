import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RedditTest extends BaseTest {

  private final By searchFieldLocator = new By.ById("header-search-bar");
  private final By firstResultLocator = new By.ById("t3_colc7w");
  private final String searchPhrase = "amplifier";

  @Test
  public void initialDriver(){
    WebDriverWait wait = new WebDriverWait(driver, 3);
    driver.get("https://www.reddit.com/");
    WebElement searchField = driver.findElement(searchFieldLocator);
    searchField.click();
    searchField.sendKeys(searchPhrase);
    searchField.submit();
    wait.until(ExpectedConditions.presenceOfElementLocated(firstResultLocator)).click();
    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    Assert.assertTrue(driver.getCurrentUrl().contains(searchPhrase));
  }
}
