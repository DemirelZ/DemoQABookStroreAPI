package step_Defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.UpdateBooks;

public class UpdateBook_step_Defs {

    UpdateBooks updateBooks = new UpdateBooks();

    @Given("User should update the collection")
    public void user_should_update_the_collection() {

        updateBooks.updateBook();
    }


    @Then("User should verify the updateStatusCode")
    public void user_should_verify_the_updateStatusCode() {

        updateBooks.verifyUpdateBook();
    }

}
