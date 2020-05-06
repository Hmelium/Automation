package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MainPage {
  private WebDriver driver;
  private String languageLocator = "//a[contains(.,'%s')]";
  @FindBy(how = How.CSS, using = "form > .search-form__submit")
  private WebElement searchButton;

  public MainPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void selectLanguage(String language){
    WebElement languageElement = driver.findElement(By.xpath(String.format(languageLocator, language)));
    languageElement.click();
  }

  public void verifySearchLanguage(String expectedLanguage){
    assertThat(searchButton.getText(), is(expectedLanguage));
  }
}
