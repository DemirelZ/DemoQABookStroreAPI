package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DeleteBook {

    Response response;

    public void deleteABook() {

        String body = "{\n" +
                "  \"isbn\": \"" + ConfigurationReader.get("isbn8") + "\",\n" +
                "  \"userId\": \"" + ConfigurationReader.get("userID") + "\"\n" +
                "}";

        Map<String, Object> token = new HashMap<>();
        token.put("Authorization", "Bearer " + ConfigurationReader.get("token"));

        response = given().contentType(ContentType.JSON)
                .headers(token)
                .body(body)
                .when().log().all()
                .delete("/BookStore/v1/Book").prettyPeek();


    }

    public void verifyDeleteBook() {

        response.then().statusCode(204);
    }

}
