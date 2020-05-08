package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProductsPage {
  private static final String productsPriceLocator = ".catalog-list li .avg-price";

  private WebDriver driver;
  private int minValueForFiltering;
  private int maxValueForFiltering;

  @FindBy(how = How.CSS, using = productsPriceLocator)
  private List<WebElement> lstProdcuts;
  @FindBy(how = How.CSS, using = ".dropdown-sorting")
  private WebElement sortingDropDown;
  @FindBy(how = How.XPATH, using = ".//a[@data-sort='price']")
  private WebElement ascendingPriceSorting;
  @FindBy(how = How.XPATH, using = "//a[@data-sort='price_desc']")
  private WebElement descendingPriceSorting;
  @FindBy(how = How.CSS, using = "#price-min")
  private WebElement minPrcingValue;
  @FindBy(how = How.CSS, using = "#price-max")
  private WebElement maxPrcingValue;
  private List<Integer> ascendingPriceSortingLst = new ArrayList<>();
  private List<Integer> descendingPriceSortingLst = new ArrayList<>();
  private List<Integer> filteredLst = new ArrayList<>();

  public ProductsPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void verifyAscendingSortingByPrice() {
    List<Integer> sortedList = lstProdcuts.stream()
            .map(c -> getPrice(c.getText()))
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
    assertThat(sortedList, is(ascendingPriceSortingLst));
  }

  public void verifyDescendingSortingByPrice() {
    List<Integer> sortedList = lstProdcuts.stream()
            .map(c -> getPrice(c.getText()))
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
    assertThat(sortedList, is(descendingPriceSortingLst));
  }

  public void verifyFilteringByPrice() {
    List<Integer> filteredList = lstProdcuts.stream()
            .map(c -> getPrice(c.getText()))
            .filter(c -> c > minValueForFiltering && c < maxValueForFiltering)
            .collect(Collectors.toList());
    assertThat(filteredList, is(filteredLst));
  }

  public void sortByAscendingPriceOrder() {
    sortingDropDown.click();
    ascendingPriceSorting.click();
    ascendingPriceSortingLst = driver.findElements(By.cssSelector(productsPriceLocator))
            .stream()
            .map(c -> getPrice(c.getText()))
            .collect(Collectors.toList());
  }

  public void sortByDescendingPriceOrder() {
    sortingDropDown.click();
    descendingPriceSorting.click();
    descendingPriceSortingLst = driver.findElements(By.cssSelector(productsPriceLocator))
            .stream()
            .map(c -> getPrice(c.getText()))
            .collect(Collectors.toList());
  }

  public void filterProductsInRange(String minValue, String maxValue) {
    minPrcingValue.click();
    minPrcingValue.sendKeys(minValue);
    minValueForFiltering = Integer.parseInt(minValue);
    maxPrcingValue.click();
    maxPrcingValue.sendKeys(maxValue);
    maxPrcingValue.sendKeys(Keys.ENTER);
    maxValueForFiltering = Integer.parseInt(maxValue);
    filteredLst = driver.findElements(By.cssSelector(productsPriceLocator))
            .stream()
            .map(c -> getPrice(c.getText()))
            .collect(Collectors.toList());
  }

  public void enterMinValue(String minValue) {
    minPrcingValue.click();
    minPrcingValue.sendKeys(minValue);
  }

  public void verifyValueIsPresented(String minValue) {
    assertThat(minPrcingValue.getText(), is(minValue));
  }

  public void verifyValueIsNotPresented() {
    assertThat(minPrcingValue.getText(), is(""));
  }

  int getPrice(String text) {
    return Integer.parseInt(text.replaceAll(" грн", ""));
  }
}
