package step_Defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.Authorized;

public class Authorized_step_Defs {

    Authorized authorized = new Authorized();

    @Given("User should be authorized with valid cedentials")
    public void user_should_be_authorized_with_valid_cedentials() {

        authorized.authorizedUser();
    }


    @Then("verify authorized statusCode")
    public void verify_authorized_statusCode() {
        authorized.verifyAuthorizedStatusCode();
    }

}
