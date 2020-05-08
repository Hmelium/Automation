import TestData.MainPageData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;

public class SearchButtonTest extends BaseTest {
  private MainPage mainPage;

  @BeforeTest
  public void initializePage(){
    mainPage = new MainPage(driver);
  }

  @Test(dataProviderClass = MainPageData.class, dataProvider = "languageData")
  public void verifySearchButtonText(String language, String searchBtnText){
    mainPage.selectLanguage(language);
    mainPage.verifySearchLanguage(searchBtnText);
  }
}
