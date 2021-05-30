package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.ConfigReader;

public class MuseumHomePage {
	private WebDriver driver;
	private ConfigReader configReader;
	public static String url;
	
	@FindBy(linkText ="Ontdek de collectie")
	private WebElement OntdekDeCollectiveLink;
	
	@FindBy(xpath = "//button[contains(text(),'Akkoord')]")
	private WebElement acceptbutton;
	
	public MuseumHomePage(WebDriver driver) {
		this.driver = driver;
		configReader = new ConfigReader();
		url = configReader.getvalue("van.gogh.museum.url");
		driver.get(url);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
		if(acceptbutton.isDisplayed()) {
			acceptbutton.click();
		}
	}

	public boolean isLaunched() {
		return driver.getTitle().toString().contains("Van Gogh Museum");
	}
	
	public void clikOnLinkOntdekdecollective() {
		OntdekDeCollectiveLink.click();
	}


}
