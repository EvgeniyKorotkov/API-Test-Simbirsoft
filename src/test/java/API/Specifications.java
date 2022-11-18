package API;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    private final static String TOKEN = "OAuth y0_AgAAAAAvUXwbAADLWwAAAADTwFRJ7nLlQqJxSuWZW4BHqV94hq36Z2I";

    public static RequestSpecification requestSpecification(String url) {
        return new RequestSpecBuilder().setBaseUri(url)
                .addHeader("Authorization", TOKEN)
                .addParam("path", "/")
                .setContentType(ContentType.JSON)
                .build();
    }

        public static ResponseSpecification responseSpec200() {
            return new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .build();
        }
        public static void installSpec(RequestSpecification request, ResponseSpecification response) {
            RestAssured.requestSpecification = request;
            RestAssured.responseSpecification = response;
        }
}

