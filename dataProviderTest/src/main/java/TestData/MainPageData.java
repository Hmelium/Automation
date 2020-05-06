package TestData;

import org.testng.annotations.DataProvider;

public class MainPageData {
  @DataProvider(name = "languageData")
  public Object[][] searchLanguageData(){
    return new Object[][]{
            {"UA", "Знайти"},
            {"RU", "Найти"}
    };
  }
}
