package step_Defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.GetUserByID;

public class GetUserByID_step_Defs {

    GetUserByID getUserByID = new GetUserByID();

    @Given("user should see the book list")
    public void user_should_see_the_book_list() {

        getUserByID.getUser();

    }


    @Then("user should verify the bookStatusCode")
    public void user_should_verify_the_bookStatusCode() {

        getUserByID.verifyUser();

    }

}
