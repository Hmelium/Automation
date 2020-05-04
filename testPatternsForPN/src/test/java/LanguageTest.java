import org.testng.annotations.Test;
import pages.MainPage;

public class LanguageTest {
  private MainPage mainPage;

  @Test
  public void changeLanguageOfPage() {
    mainPage.changeLanguage();
    mainPage.verifyLanguageIsChanged();
  }
}
