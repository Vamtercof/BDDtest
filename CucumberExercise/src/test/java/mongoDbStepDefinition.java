import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepsDefinition.dbConnection;
import stepsDefinition.hooks;

import java.util.logging.Logger;

public class mongoDbStepDefinition extends dbConnection {
    ExtentTest scenarioDef;


    public mongoDbStepDefinition(){
        this.scenarioDef = hooks.scenarioDef;
    }





}
