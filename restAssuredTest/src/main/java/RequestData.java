import org.testng.annotations.DataProvider;

public class RequestData {
  protected static final int SUCCESS_STATUS = 200;
  protected static final String CREATE_USER_URL = "createWithArray";
  protected static final String UPDATED_USER = "Hulk";

  @DataProvider(name = "created_user")
  public static Object[][] createdUserData() {
    return new Object[][]{{
            CREATE_USER_URL,
            SUCCESS_STATUS,
            "Hmelium",
            "Bohdan",
            "Miedviediev",
            "test@mailinator.com",
            "test123",
            "777888",
            "0"
    }};
  }

  @DataProvider(name = "updated_user")
  public static Object[][] updatedUserData() {
    return new Object[][]{{
            CREATE_USER_URL,
            SUCCESS_STATUS,
            UPDATED_USER,
            "Hulk",
            "Hogan",
            "test@mailinator.com",
            "test123",
            "777888",
            "0"
    }};
  }

  @DataProvider(name = "get_user")
  public static Object[][] getUserData() {
    return new Object[][]{{
            UPDATED_USER,
            SUCCESS_STATUS
    }};
  }

  @DataProvider(name = "delete_user")
  public static Object[][] deleteUserData() {
    return new Object[][]{{
            UPDATED_USER,
            SUCCESS_STATUS
    }};
  }
}
