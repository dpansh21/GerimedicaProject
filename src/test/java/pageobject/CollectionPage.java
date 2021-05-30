package pageobject;

import java.time.Duration;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CollectionPage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath ="//h1[contains(text(),'Collectie')]")
	WebElement collectionPage;
	
	@FindBy(xpath ="//button[@class='main-navigation-desktop-item btn-icon']")
	WebElement searchIcon;
	
	@FindBy(id = "Q")
	WebElement searchBox;
	
	@FindBy(xpath = "//button[@class='search-input-button btn-icon']")
	WebElement searchBoxIcon;
	
	@FindBy(xpath = "//p[@class='search-results-total']")
	WebElement searchResult;
	
	@FindBy(xpath = "//section[@class='search-results-art-objects grid-row']/div[1]/article/a/div[1]")
	WebElement firstSearchResult;
		
	public CollectionPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	public boolean isLaunched() {
		wait.until(ExpectedConditions.visibilityOf(collectionPage));
		return collectionPage.getText().toString().contains("Collectie");
	}
	
	public void clickOnSearchIcon() {
		wait.until(ExpectedConditions.visibilityOf(searchIcon));
		try {
			searchIcon.click();	
		}catch(StaleElementReferenceException e) {
			searchIcon.click();	
		}
	}
	public void setSearchPainting(String paintingName) {
		searchBox.clear();
		searchBox.sendKeys(paintingName);
	}
	public void clickOnSearchBoxIcon() {
		searchBoxIcon.click();
	}
	public String getSearchResult() {
		wait.until(ExpectedConditions.visibilityOf(searchResult));
		return searchResult.getText().toString();
	}
	public void selectFirstResult() {
		wait.until(ExpectedConditions.visibilityOf(firstSearchResult));
		firstSearchResult.click();
	}

}
