package step_Defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.hu.De;
import services.DeleteBook;

public class DeleteBook_step_Defs {

    DeleteBook deleteBook = new DeleteBook();

    @Given("User should delete a book")
    public void user_should_delete_a_book() {

        deleteBook.deleteABook();

    }


    @Then("User should verify deleteStatusCode")
    public void user_should_verify_deleteStatusCode() {

        deleteBook.verifyDeleteBook();
    }
}
