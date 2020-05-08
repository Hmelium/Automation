package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MainPage {
  private WebDriver driver;
  @FindBy(how = How.CSS, using = "input")
  private WebElement searchButton;
  @FindBy(how = How.CSS, using = ".goods-tile__title")
  private List<WebElement> resultsTitle;

  public MainPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void searchProduct(String product) {
    searchButton.sendKeys(product);
    searchButton.sendKeys(Keys.ENTER);
  }

  public String getFirstResultTitle() {
    new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOfAllElements(resultsTitle));
    return resultsTitle.get(0).getText();
  }
}
