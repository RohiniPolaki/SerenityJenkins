package helpers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import pages.AmazonPage;
import pages.HomePage;

public class SerenityWebTestHelper {

	HomePage homepage;
	AmazonPage amazonPage;

	@Step
	public void validatebuitinMethods() {
		homepage.open();
		// homepage.openUrl(null);
		homepage.getDriver().manage().window().maximize();
		homepage.enterFirstName("Test");
		System.out.println("Done");
	}

	@Step
	public void validateAlertHandlingMethods() {
		homepage.openUrl("https://nxtgenaiacademy.com/alertandpopup/");
		homepage.getDriver().manage().window().maximize();
		homepage.validateAlertHandling();
		System.out.println("Done");
	}

	@Step
	public void searchForProductInAmazon(String product) {
		amazonPage.openUrl("https://www.amazon.in/");
		amazonPage.getDriver().manage().window().maximize();
		amazonPage.searchTheItem(product);
	}
	@Step
	@When("user adds first product from the search result to cart")
	public void addFirstproductToCart() {
		amazonPage.addProductToCart();
		//serenityWebTesthelper.addProductToCartInamazon();
		
	}
	@Step
	@And("user navigates to Cart page")
	public void navigateToCartPage() {
		//serenityWebTesthelper.addProductToCartInamazon();
		amazonPage.navigateToCartPage();
	}
	@Step
	@Then("user validates whether above added product is added in Cart")
	public void validateProductIncart() {
		//serenityWebTesthelper.addProductToCartInamazon();
		amazonPage.validateProductAddedInCart();	
	}
	@Step
	@And("user exits from the application")
	public void exitsfromApllication() {
		//serenityWebTesthelper.addProductToCartInamazon();
		amazonPage.exitFromApplication();
	}

}
