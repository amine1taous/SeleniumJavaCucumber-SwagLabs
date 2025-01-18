package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_objects.PaymentPage;
import com.e2etests.automation.utils.SeleniumUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentStepDefinition {

    private PaymentPage paymentPage;
    private SeleniumUtils utils;

    public PaymentStepDefinition() {
        this.paymentPage = new PaymentPage();
        this.utils = new SeleniumUtils();
    }

    @When("I click on the checkout button")
    public void iClickOnTheCheckoutButton() {
    	paymentPage.click(paymentPage.getCheckoutBtn());
    }
    
    @When("I head toward the checkout page {string}")
    public void iHeadTowardTheCheckoutPage(String checkoutPageMessage) {
    	paymentPage.verificationMessage(paymentPage.getCheckoutPageMessage(), checkoutPageMessage);
    }
    
    @When("I enter a valid data in the firstname field {string}")
    public void iEnterAValidDataInTheFirstnameField(String firstname) {
    	paymentPage.fillInput(paymentPage.getFirstNameInput(), firstname);
    }
    
    @When("I enter a valid data in the lastname field {string}")
    public void iEnterAValidDataInTheLastnameField(String lastname) {
    	paymentPage.fillInput(paymentPage.getLastNameInput(), lastname);
    }
    
    @When("I enter a valid data in the zip field {string}")
    public void iEnterAValidDataInTheZipField(String zipCode) {
    	paymentPage.fillInput(paymentPage.getZipCodeInput(), zipCode);
    }
    
    @When("I click on the continue button")
    public void iClickOnTheContinueButton() {
    	paymentPage.click(paymentPage.getContinueBtn());
    }
    
    @When("I head toward the checkout overview page {string}")
    public void iHeadTowardTheCheckoutOverviewPage(String overviewMessage) {
    	paymentPage.verificationMessage(paymentPage.getVerificationOverviewPage(),overviewMessage);
    }
    
    @When("I click on the finish button")
    public void iClickOnTheFinishButton() {
    	paymentPage.click(paymentPage.getFinishBtn());
    }
    
    @Then("I head toward the completed checkout page {string}")
    public void iHeadTowardTheCompletedCheckoutPage(String orderMessage) {
    	paymentPage.verificationMessage(paymentPage.getOrderPassedMessage(),orderMessage);
    }



}
