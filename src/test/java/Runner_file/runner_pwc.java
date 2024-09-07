package Runner_file;

import org.testng.annotations.*;
import io.cucumber.testng.*;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"src/test/java/Features_file"},
		glue={"StepDefinition_file"},
		plugin = {"json:results/cucumberjson/cucumber.json"}
		//tags = "@TC_No_02"
		 
		
	)

public class runner_pwc {
	private TestNGCucumberRunner testng_cucumber_runner;
	@BeforeClass(alwaysRun = true)
	public void set_up_class() throws Throwable{
		testng_cucumber_runner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void scenario(PickleWrapper pickle, FeatureWrapper cucumber_feature) {
		testng_cucumber_runner.runScenario(pickle.getPickle());
	}
	
	@DataProvider(name = "features")
	public Object[][] scenarios(){
		if(testng_cucumber_runner == null) {
			System.out.println("Runnner is returning null: dataprovider");
			testng_cucumber_runner = new TestNGCucumberRunner(this.getClass());
		}
		else {
			System.out.println("Runner is not null: dataprovider");
		}
		return testng_cucumber_runner.provideScenarios();
	}
	
	/*@AfterMethod
	public void after_test() throws Throwable{
		try {
			if(Base_class.driver != null) {
				Base_class.driver.quit();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	
	@AfterClass(alwaysRun = true)
	public void tear_down_class() throws Throwable{
		try {
			testng_cucumber_runner.finish();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		

}
