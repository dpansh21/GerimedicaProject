package stepdef;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.Utils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.CollectionPage;
import pageobject.MuseumHomePage;
import pageobject.PaintingInformationPage;
import io.cucumber.java.Scenario;



public class TestStepDef {
	private WebDriver driver;
	private Scenario scenario;
	private MuseumHomePage museumHomePage;
	private CollectionPage collectionPage;
	private PaintingInformationPage paintingInformationPage;
	private Utils utils;
	
	public void ApiStepDefinition() throws IOException{
		
	}
	@Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
        driver = new ChromeDriver();
        museumHomePage = new MuseumHomePage(driver);
        collectionPage = new CollectionPage(driver);
        utils = new Utils();
        paintingInformationPage = new PaintingInformationPage(driver);
    }
			
	@Given("User launch given museum website")
	public void getBaseURL() throws IOException {
		Assert.assertTrue(museumHomePage.isLaunched());
		byte[] fileContent = utils.takeScreenshot(driver, "HomePage");
		scenario.attach(fileContent,"image/png", "HomePage");
		scenario.log("Successfully launched the url of Van Gogh Museum"); 
	}
	
	@When("click on Ontdek de collective link")
	public void clickonOntdekdecollectivelink(){
		museumHomePage.clikOnLinkOntdekdecollective();
		scenario.log("Successfully clicked on the link Ontdek de collective");
	}
	@Then("Verify the collection page")
	public void Verifythecollectionpage() throws IOException {
		Assert.assertTrue(collectionPage.isLaunched());
		byte[] fileContent = utils.takeScreenshot(driver, "CollectionPage");
		scenario.attach(fileContent,"image/png", "CollectionPage");
		scenario.log("Successfully landed on the collections page");
	}
	
	@Then("Search the painting from search box")
	public void SearchPainting(DataTable dataTable) throws Throwable{
		List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
		String paintingName = data.get(0).get("PaintingName");
		Assert.assertTrue(collectionPage.isLaunched());
		collectionPage.clickOnSearchIcon();
		collectionPage.setSearchPainting(paintingName);
		collectionPage.clickOnSearchBoxIcon();	
	}
	
	@And("Verify the search results")
	public void Verifytheresults() throws IOException {
		String searchresult=collectionPage.getSearchResult();
		byte[] fileContent = utils.takeScreenshot(driver, "SearchResult");
		scenario.attach(fileContent,"image/png", "SearchResult");
		String[] arrResult = searchresult.split(" ");
		int result = Integer.parseInt(arrResult[0]);
		Assert.assertTrue(result>700);
		scenario.log("Successfully validated the result found more than 700");
	}
	
	@Then("Select First Result")
	public void SelectFirstResult() {
		collectionPage.selectFirstResult();
	}
	
	@And("Verify the painting")
	public void Verifythepainting(DataTable dataTable) throws Throwable{
		List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
		String fNumber = data.get(0).get("FNumber");
		String jhNumber = data.get(0).get("JHNumber");
		String invNumber = data.get(0).get("InvNumber");
		Assert.assertTrue(paintingInformationPage.isLaunched());
		byte[] fileContent = utils.takeScreenshot(driver, "FirstPainting");
		scenario.attach(fileContent,"image/png", "FirstPainting");
		paintingInformationPage.clickOnObjectgegevens();
		String fetchFnumber=paintingInformationPage.getFNumber();
		Assert.assertEquals(fetchFnumber,fNumber);
		scenario.log("Successfully validated the fnumber as : " + fNumber);
		String fetchedJhNumber=paintingInformationPage.getJHNumber();
		Assert.assertEquals(fetchedJhNumber,jhNumber);
		scenario.log("Successfully validated the JHnumber as : " + jhNumber);
		String fetchedInvNumber=paintingInformationPage.getInvnummer();
		Assert.assertEquals(fetchedInvNumber,invNumber);
		scenario.log("Successfully validated the invoicenumber as : " + invNumber);
	}
	
	@After
	public void after() {
		driver.close();
	}

}
