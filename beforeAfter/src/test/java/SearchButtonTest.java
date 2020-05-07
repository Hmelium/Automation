import TestData.MainPageData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.Assert.assertTrue;

public class SearchButtonTest extends BaseTest {
  private MainPage mainPage;

  @BeforeMethod
  public void initializePage() {
    mainPage = new MainPage(driver);
  }

  @Test(dataProviderClass = MainPageData.class, dataProvider = "searchData")
  public void verifySearchButtonText(String product) {
    mainPage.searchProduct(product);
    assertTrue(mainPage.getFirstResultTitle().contains(product));
  }
}
