import com.jayway.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreateUser extends MainPostTest{
  @Test(dataProvider = "created_user", dataProviderClass = RequestData.class)
  public void createNewUser(String url, int status, String username, String firstName,
                            String lastName, String email, String password, String phone, String userStat) {
    JsonPath response = given()
            .spec(spec)
            .when()
            .contentType("application/json")
            .body("[{\n" +
                    "\"username\":\"" + username + "\",\n " +
                    "\" firstName\":\"" + firstName +"\",\n " +
                    "\"lastName\":\"" + lastName + "\",\n " +
                    "\"email\":\"" + email + "\",\n " +
                    "\"password\":\"" + password + "\",\n " +
                    "\"phone\":\"" + phone + "\",\n " +
                    "\"userStatus\":\"" + userStat + "\"\n " +
                    "}]")
            .post(url)
            .then()
            .statusCode(status)
            .extract().jsonPath();
    assertThat(response.getString("message"), equalToIgnoringCase("ok"));
  }
}
