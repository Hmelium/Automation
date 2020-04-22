import com.jayway.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GetUser extends MainPostTest {
  @Test(dataProvider = "get_user", dataProviderClass = RequestData.class)
  public void getNewUser(String username, int status) {
    JsonPath response = given()
            .spec(spec)
            .when()
            .get(username)
            .then()
            .statusCode(status)
            .extract().jsonPath();
    assertThat(response.getString("userName"), is(username));
  }
}
