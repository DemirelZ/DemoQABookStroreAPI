package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AddBook {

    Response response;

    public void addBook(){

        String body="{\n" +
                "  \"userId\": \""+ ConfigurationReader.get("userID") +"\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \""+ConfigurationReader.get("isbn1")+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Map<String, Object> token = new HashMap<>();
        token.put("Authorization", "Bearer " + ConfigurationReader.get("token"));

        response=given().contentType(ContentType.JSON)
                .headers(token)
                .body(body)
                .when().log().all()
                .post("/BookStore/v1/Books").prettyPeek();


    }

    public void verifyAddBook(){

        response.then().statusCode(201);

    }

}
