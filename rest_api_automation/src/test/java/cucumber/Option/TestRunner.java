package cucumber.Option;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/java/features",
		plugin = {"json:target/jsonReports/cucumber-report.json"},
		glue= {"StepDefinition"}
			
		)
public class TestRunner {
//tags= "@DeletePlace",
	@BeforeClass
	public static void setupclass()
	{
		System.out.println("Before Class is called...");
	}
	
	@Before
	public void setupMethod()
	{
		System.out.println("Before Method is called...");
	}
	
	@After
	public void teardownMethod()
	{
		System.out.println("Tear down method is called...");
	}
	
	@AfterClass
	public static void teardownClass()
	{
		File reportOutputDirectory = new File("target"); //
	    List<String> jsonFiles = new ArrayList<String>();
	    //jsonFiles.add("target/cucumber.json");
	    jsonFiles.add("target/jsonReports/cucumber-report.json");
	    String projectName = "rest_api_automation";
	    String buildNumber = "1.0";

	    Configuration configuration = new Configuration(reportOutputDirectory, 
	    projectName);

	    //configuration.setRunWithJenkins(true);
	    
	    	
	    
	    configuration.setBuildNumber(buildNumber);

	    ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
	    reportBuilder.generateReports();
	}
	
}
