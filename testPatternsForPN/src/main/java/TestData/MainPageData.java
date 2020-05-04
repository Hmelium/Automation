package TestData;

import org.testng.annotations.DataProvider;

public class MainPageData {
  @DataProvider(name = "maiPage")
  public Object[][] categoryData(){
    return new Object[][]{
            {"Вино", "Рис"}
    };
  }

  @DataProvider(name = "filtering")
  public Object[][] filtersData(){
    return new Object[][]{
            {"Рис", "10", "100"}
    };
  }

  @DataProvider(name = "validateFiltering")
  public Object[][] validateFiltersData(){
    return new Object[][]{
            {"Рис", "sad"},
            {"Рис", "15"}
    };
  }
}
