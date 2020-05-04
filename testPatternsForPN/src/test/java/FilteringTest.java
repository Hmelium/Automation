import TestData.MainPageData;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductsPage;

public class FilteringTest extends BaseTest{
  private MainPage mainPage;
  private ProductsPage productsPage;

  @Test(dataProviderClass = MainPageData.class, dataProvider = "filteringData")
  public void verifyFiltering(String food, String minValue, String maxValue) {
    mainPage.selectProdcutCategory(food);
    productsPage.filterProductsInRange(minValue, maxValue);
    productsPage.verifyFilteringByPrice();
  }

  @Test(dataProviderClass = MainPageData.class, dataProvider = "validateFiltering")
  public void validateEnteringCorrectMinFilteringValue(String food, String minValue) {
    mainPage.selectProdcutCategory(food);
    productsPage.enterMinValue(minValue);
    productsPage.verifyValueIsPresented(minValue);
  }

  @Test(dataProviderClass = MainPageData.class, dataProvider = "validateFiltering")
  public void validateEnterinInvalidMinFilteringValue(String food, String minValue) {
    mainPage.selectProdcutCategory(food);
    productsPage.enterMinValue(minValue);
    productsPage.verifyValueIsNotPresented();
  }

}
