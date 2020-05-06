import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;

public class LanguageTest extends BaseTest{
  private MainPage mainPage;

  @BeforeTest
  public void initializePage(){
    mainPage = new MainPage(driver);
  }

  @Test
  public void changeLanguageOfPage() {
    mainPage.changeLanguage();
    mainPage.verifyLanguageIsChanged();
  }
}
