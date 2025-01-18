package com.e2etests.automation.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;

public class PaymentPage {

	private SeleniumUtils utils;
	
	/* FindBy */
	
	@FindBy(how = How.ID , using = "checkout")
	private WebElement checkoutBtn;
	
	@FindBy(how = How.XPATH , using = "//span[@class='title']")
	private WebElement checkoutPageMessage;

	@FindBy(how = How.ID , using = "first-name")
	private WebElement firstNameInput;
	
	@FindBy(how = How.ID , using = "last-name")
	private WebElement lastNameInput;
	
	@FindBy(how = How.ID , using = "postal-code")
	private WebElement zipCodeInput;
	
	@FindBy(how = How.XPATH , using = "//span[@class='title']")
	private WebElement verificationOverviewPage;
	
	@FindBy(how = How.ID , using = "continue")
	private WebElement continueBtn;
	
	@FindBy(how = How.ID , using = "finish")
	private WebElement finishBtn;
	
	@FindBy(how = How.XPATH , using = "//h2[normalize-space()='Thank you for your order!']")
	private WebElement orderPassedMessage;
	
	public PaymentPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		this.utils = new SeleniumUtils();
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	public WebElement getCheckoutPageMessage() {
		return checkoutPageMessage;
	}

	public WebElement getFirstNameInput() {
		return firstNameInput;
	}

	public WebElement getLastNameInput() {
		return lastNameInput;
	}

	public WebElement getZipCodeInput() {
		return zipCodeInput;
	}

	public WebElement getVerificationOverviewPage() {
		return verificationOverviewPage;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getFinishBtn() {
		return finishBtn;
	}

	public WebElement getOrderPassedMessage() {
		return orderPassedMessage;
	}

	//Methods
	
	public void fillInput(WebElement field, String data) {

		utils.writeText(field, data);
	}
	
	public void click(WebElement btn) {
		utils.waitForElementToBeClickable(btn);
		btn.click();

	}
	
	public void click(String idProduct) {
		WebElement product = Setup.getDriver().findElement(By.id(idProduct));

		utils.waitForElementToBeClickable(product);
		product.click();

	}
	
	public void verificationMessage(WebElement message, String text) {
		utils.assertEquals(message, text);
	}
		
	
	
}
