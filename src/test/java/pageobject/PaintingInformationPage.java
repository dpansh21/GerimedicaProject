package pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaintingInformationPage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//div[@class='art-object-header-image-wrapper']/div[1]/picture/img")
	WebElement image;
	@FindBy(xpath="//button[contains(text(),'Objectgegevens')]")
	WebElement objectinfo;
	
	@FindBy(xpath="//dt[@class='definition-list-item-label' and contains(text(),'F-nummer')]/following-sibling::dd")
	WebElement fnummer;
	
	@FindBy(xpath="//dt[@class='definition-list-item-label' and contains(text(),'JH-nummer')]/following-sibling::dd")
	WebElement jhnummer;
	
	@FindBy(xpath="//dt[@class='definition-list-item-label' and contains(text(),'Inventarisnummer')]/following-sibling::dd")
	WebElement Inventarisnummer;
	
	public PaintingInformationPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public boolean isLaunched() {
		wait.until(ExpectedConditions.visibilityOf(image));
		return objectinfo.getText().toString().contains("Objectgegevens");
	}
	public void clickOnObjectgegevens() {	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", objectinfo);
	}
	public String getFNumber() {
		wait.until(ExpectedConditions.visibilityOf(fnummer));
		return fnummer.getText().toString();
	}
	public String getJHNumber() {
		return jhnummer.getText().toString();
	}
	public String getInvnummer() {
		return Inventarisnummer.getText().toString();
	}
}
