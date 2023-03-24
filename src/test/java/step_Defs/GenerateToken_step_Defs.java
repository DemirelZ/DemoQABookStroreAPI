package step_Defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.GenerateToken;

public class GenerateToken_step_Defs {

    GenerateToken generateToken=new GenerateToken();
    @Given("input valid credentials")
    public void input_valid_credentials() {

        generateToken.generateToken();
    }

    @Then("verify token statusCode")
    public void verify_token_statusCode() {

        generateToken.verifyGenerateStatusCode();
    }
}
