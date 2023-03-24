package step_Defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.AddBook;

public class addBook_step_Defs {

    AddBook addBook=new AddBook();
    @Given("User should add new book")
    public void user_should_add_new_book() {

        addBook.addBook();
    }


    @Then("user should verify the addStatusBookCode")
    public void user_should_verify_the_addStatusBookCode() {

        addBook.verifyAddBook();
    }
}
