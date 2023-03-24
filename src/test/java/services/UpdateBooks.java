package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdateBooks {

    Response response;
    public void updateBook(){

        String body= "{\n" +
                "  \"userId\": \""+ ConfigurationReader.get("userID") +"\",\n" +
                "  \"isbn\": \""+ConfigurationReader.get("isbn8")+"\"\n" +
                "}";

        Map<String, Object> token = new HashMap<>();
        token.put("Authorization", "Bearer " + ConfigurationReader.get("token"));

        response=given().contentType(ContentType.JSON)
                .pathParam("isbn", ConfigurationReader.get("isbn3"))
                .headers(token)
                .body(body)
                .when().log().all()
                .put("/BookStore/v1/Books/{isbn}").prettyPeek();
    }

    public void verifyUpdateBook(){

        response.then().statusCode(200);

    }


}
