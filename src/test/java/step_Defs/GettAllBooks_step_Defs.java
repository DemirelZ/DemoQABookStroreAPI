package step_Defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.GetAllBooks;

public class GettAllBooks_step_Defs {

    GetAllBooks getAllBooks=new GetAllBooks();
    @Given("User should see book list")
    public void user_should_see_book_list() {

        getAllBooks.booksList();
    }


    @Then("User verify the bookStatusCode")
    public void user_verify_the_bookStatusCode() {

        getAllBooks.verifyBookList();
    }
}
