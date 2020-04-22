import com.jayway.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class DeleteUser extends MainPostTest {
  @Test(dataProvider = "delete_user", dataProviderClass = RequestData.class)
  public void deleteUser(String username, int status) {
    given()
            .spec(spec)
            .when()
            .delete(username)
            .then()
            .statusCode(status);
  }
}
