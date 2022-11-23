package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import helpers.SerenityWebTestHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class SerenityWebTestStepDefinition {

	@Steps(shared = true) // maintains single object and shared to all
	SerenityWebTestHelper serenityWebTesthelper;

	@Given("Open Website in the browser")
	public void openWebsiteAndEnterText() {
		serenityWebTesthelper.openBrowser();	
	}
	
	@When("Enter the required details in the form")
	public void enterDetailsInTheForm() {
		serenityWebTesthelper.validatebuitinMethods();	
	}
	@Then("verify the alert handling methods")
	public void verifyAlerts() {
		serenityWebTesthelper.validateAlertHandlingMethods();
		
	}

	@Given("user searches {string} in Amazon home page")
	public void openAmazonWebsiteAndSearchItem(String Product) {
		serenityWebTesthelper.searchForProductInAmazon(Product);
		
	}
	@When("user adds first product from the search result to cart")
	public void addFirstProductToCart() {
		serenityWebTesthelper.addFirstproductToCart();
		
	}
	
	@And("user navigates to Cart page")
	public void navigateToCartPage() {
		//serenityWebTesthelper.addProductToCartInamazon();
		serenityWebTesthelper.navigateToCartPage();
	}
	@Then("user validates whether above added product is added in Cart")
	public void validateProductIncart() {
		serenityWebTesthelper.validateProductIncart();
		
	}
	
	@And("user exits from the application")
	public void exitsfromApllication() {
		serenityWebTesthelper.exitsfromApllication();
		
	}
}
