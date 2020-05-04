import TestData.MainPageData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductsPage;

public class PriceTest extends BaseTest {
  private MainPage mainPage;
  private ProductsPage productsPage;

  @BeforeTest
  public void initializePage() {
    mainPage = new MainPage(driver);
    productsPage = new ProductsPage(driver);
  }

  @Test(dataProviderClass = MainPageData.class, dataProvider = "maiPage")
  public void verifySorting(String drink, String food) {
    mainPage.selectProdcutCategory(food);
    mainPage.verifyProdctsOnPage(drink, food);
    productsPage.sortByAscendingPriceOrder();
    productsPage.verifyAscendingSortingByPrice();
    productsPage.sortByDescendingPriceOrder();
    productsPage.verifyDescendingSortingByPrice();
  }
}
