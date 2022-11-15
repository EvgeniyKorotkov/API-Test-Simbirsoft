package API;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
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
                .then()
                .body("_embedded.items.name", notNullValue()) // проверяем, что наши поля name не пустые
                .extract().response();
        // преобразуем наш респонс в JsonPath
        JsonPath jsonPath = response.jsonPath();
        // получаем список с именами файлов и папок
        List<String> names = jsonPath.get("_embedded.items.name");
        // перебираем список с именами файлов и папок и печатаем в консоль
        for(int i =0; i <names.size();i++) {
            System.out.println(names.get(i));
        }
    }
}
