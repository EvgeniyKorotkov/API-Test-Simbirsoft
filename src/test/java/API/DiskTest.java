package API;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DiskTest {
    private final static String URL = "https://cloud-api.yandex.net/";

    @Test
    public void checkName() {
        Specifications.installSpec(Specifications.requestSpecification(URL), Specifications.responseSpec200());

        Response response = given()
                .when()
                .get("v1/disk/resources")
                .then().log().all()
                .body("name", notNullValue())
                .extract().response();


    }
}
