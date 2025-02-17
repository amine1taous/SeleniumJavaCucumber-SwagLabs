package com.e2etests.automation.step_definitions;


import com.e2etests.automation.page_objects.AuthenticationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationStepDefinition {
	
	private AuthenticationPage authenticationPage;
	
	public AuthenticationStepDefinition() {
		this.authenticationPage = new AuthenticationPage();
	}
	

	@Given("I connect to the swagLabs application")
	public void iConnectToTheSwagLabsApplication() {
		authenticationPage.goToURL();
	}
	
	@When("I enter a valid data for the username field {string}")
	public void iEnterAValidDataForTheUsernameField(String username) {
		authenticationPage.fillInput(authenticationPage.getUserNameInput(),username);
	}
	
	@When("I enter a valid data for the password field {string}")
	public void iEnterAValidDataForThePasswordField(String password) {
		authenticationPage.fillInput(authenticationPage.getPasswordInput(),password);
	}
	
	@When("I click on the Login button")
	public void iClickOnTheLoginButton() {
		authenticationPage.click(authenticationPage.getLoginButton());
	}
	
	@Then("I head toward the inventory page {string}")
	public void iHeadTowardTheInventoryPage(String verifMsg) {
		authenticationPage.verificationMessage(authenticationPage.getSuccessLoginMessage(),verifMsg);
	}
	
	@Then("I receive an error message for locked users {string}")
	public void iReceiveAnErrorMessageForLockedUsers(String errorMessage) {
		authenticationPage.verificationMessage(authenticationPage.getErrorLoginMessage(),errorMessage);
	}


	@Then("I receive an error message for invalid users {string}")
	public void iReceiveAnErrorMessageForInvalidUsers(String errorMessage) {
		authenticationPage.verificationMessage(authenticationPage.getErrorLoginMessage(),errorMessage);
	}


	@When("I click on the menu Icon")
	public void iClickOnTheMenuIcon() {
		authenticationPage.click(authenticationPage.getMenuIcon());
	}
	
	@When("I click on the logout button")
	public void iClickOnTheLogoutButton() {
		authenticationPage.click(authenticationPage.getLogoutButton());
	}
	
	@Then("I head toward the authentication Page {string}")
	public void iHeadTowardTheAuthenticationPage(String successLogoutMsg) {
		authenticationPage.verificationMessage(authenticationPage.getSuccessLogoutMessage(),successLogoutMsg);
	}






}
