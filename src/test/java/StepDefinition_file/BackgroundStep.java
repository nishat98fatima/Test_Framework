package StepDefinition_file;

import PageObject.BaseClass;
import Utilities.CommonMethod;
import Utilities.DriverManager;
import Utilities.ReadConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundStep extends BaseClass  {

	@Given("Launch Browser")
	public void BrowserLaunch()throws Throwable {
			CommonMethod.Launch_Browser();
	}
    @When ("URL launch sucessfully")
    public void URL_Launch_Successfully() throws Throwable{
    	CommonMethod.urlOpen();
    	
    }
    @Then ("Close the browser.")
    public void close_browser() throws Throwable {
    	DriverManager.closeDriver(driver);
    	
    }
}
