package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetUserByID {

    Response response;
    public void getUser(){

        Map<String, Object> token = new HashMap<>();
        token.put("Authorization", "Bearer " + ConfigurationReader.get("token"));

        response=given().contentType(ContentType.JSON)
                .pathParam("id", ConfigurationReader.get("userID"))
                .headers(token)
                .when().log().all()
                .get("/Account/v1/User/{id}").prettyPeek();

    }
     public void verifyUser(){

        response.then().statusCode(200);

     }

}
