package services;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Register {

    Response response;
    Faker faker=new Faker();
    public String userName;
    public String userID;

    public void userRegister(){

        String password= ConfigurationReader.get("commonPassword");
        userName=faker.name().firstName();

        /*
{
  "userName": "zafer",
  "password": "Zfr123456*"
}
         */

        Map<String, Object> body=new HashMap<>();
        body.put("userName", userName);
        body.put("password", password);

        response= RestAssured.given().contentType(ContentType.JSON)
                .body(body).log().all()
                .when()
                .post("/Account/v1/User").prettyPeek();

        userID=response.path("userID");
        System.out.println("userID = " + userID);
    }

    public void verifyRegister(){

        response.then().statusCode(201);

    }

    public void userRegister1(){


        String password=ConfigurationReader.get("commonPassword");
        String username=faker.name().fullName();

        Map<String, Object> body=new HashMap<>();
        body.put("userName", username);
        body.put("password", password);

        response=given().accept(ContentType.JSON)
                .body(body)
                .when().log().all()
                .post("/Account/v1/User").prettyPeek();

        String userID=response.path("userTd");
        System.out.println("userID = " + userID);


    }

}
