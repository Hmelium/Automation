package TestData;

import org.testng.annotations.DataProvider;

public class MainPageData {
  @DataProvider(name = "searchData")
  public Object[][] searchLanguageData(){
    return new Object[][]{
            {"Ноутбук"},
            {"Электрочайник"},
            {"Мяч"}
    };
  }
}
