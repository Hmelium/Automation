package pages;

import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class MainPage {
  private WebDriver driver;
  @FindBy(how = How.CSS, using = ".prb-menu")
  private List<WebElement> productsList;
  @FindBy(how = How.CSS, using = ".logo-city")
  private WebElement cityName;
  @FindBy(how = How.XPATH, using = "//li[@class='dropdown-inline']")
  private List<WebElement> languageChanger;

  public MainPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void selectProdcutCategory(String product) {
    driver.findElement(By.xpath(String.format("//a[@title='%s']", product)))
            .click();
  }

  public void changeLanguage(){
   WebElement enabledLanguage = languageChanger.stream().filter(WebElement::isEnabled).findFirst().orElse(null);
   enabledLanguage.click();
  }

  public void verifyLanguageIsChanged(){
    assertThat(cityName.getText(), is(driver.findElement(By.xpath(".logo-city")).getText()));
  }

  public void verifyProdctsOnPage(String firstProduct, String secondProduct){
    List<WebElement> productAndAlco = productsList.get(0).findElements(By.cssSelector("li"));
    assertTrue(productAndAlco.contains(firstProduct)&&productAndAlco.contains(secondProduct));
  }
}
