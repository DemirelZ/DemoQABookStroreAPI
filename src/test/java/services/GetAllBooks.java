package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class GetAllBooks {

    Response response;
    public void booksList() {

        Map<String, Object> token = new HashMap<>();

        token.put("Authorization", "Bearer " + ConfigurationReader.get("token"));

        response=RestAssured.given().contentType(ContentType.JSON)
                .headers(token)
                .when().log().all()
                .get("/BookStore/v1/Books").prettyPeek();

//        JsonPath jsonPath=response.jsonPath();
//        List<Object> list = jsonPath.getList("books.isbn");
//        System.out.println("list = " + list);


    }

    public void verifyBookList(){

        response.then().statusCode(200);

    }

}
