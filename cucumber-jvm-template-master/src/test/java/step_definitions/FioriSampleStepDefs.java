package step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class FioriSampleStepDefs{
    public WebDriver driver;
    
    public FioriSampleStepDefs()
    {
    	driver = Driver.driver;
    }
    
    //Scenario1
    @Given("I am on the Fiori homepage")
    public void open_Fiori() throws Throwable {
    	driver.get("https://webdisp.mo.sap.corp:26000/sap/bc/ui5_ui5/ui2/ushell/shells/abap/FioriLaunchpad.html?search-client=002&branch=11&tester_epm");
    	Thread.sleep(30000);
    }
    @When("^I Click on Search Button , I Enter a Search Term SAP, the search field, Hit Search Button$")
    public void performSearch() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(".//*[@id='sf']/span")).click();
        Thread.sleep(30000);
        driver.findElement(By.cssSelector("#searchFieldInShell input")).sendKeys("SAP");
        Thread.sleep(30000);
        driver.findElement(By.cssSelector("#searchFieldInShell .searchBtn")).click();
        Thread.sleep(30000);
    }

    @Then("^I should see the search Results$")
    public void validateResults() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	String results = driver.findElement(By.cssSelector(".searchBar .sapMBarContainer.sapMBarPH")).getAttribute("innerText");
    	//System.out.println(results);
    	assertEquals("Search Results (30)",results);
      //assertEquals("http://www.seleniumframework.com/",driver.getCurrentUrl());
    }
    
  //Scenario2
    @Given("^I am on Fiori Homepage$")
    public void i_am_on_Fiori_Homepage() throws Throwable {
    	driver.get("https://webdisp.mo.sap.corp:26000/sap/bc/ui5_ui5/ui2/ushell/shells/abap/FioriLaunchpad.html?search-client=002&branch=11&tester_epm");
    	Thread.sleep(30000);
    }
    
    @When("^I Click on logout Button$")
    public void clickLogout() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("actionsBtn-name")).click();
        Thread.sleep(30000);
        driver.findElement(By.id("logoutBtn")).click();
        Thread.sleep(30000);
        
    }
    
    @Then("^I should see a pop up and click on OK to be logged out of the system$")
    public void validateLogout() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	//System.out.println("Logged Out");
    	if (driver.findElement(By.cssSelector(".sapMBtnContent")).getText().equalsIgnoreCase("OK"))
        	driver.findElement(By.cssSelector(".sapMBtnContent")).click();
        Thread.sleep(30000);
    }
}