package pages;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AmazonPage extends PageObject{

	
	@FindBy(id = "twotabsearchtextbox")
	WebElementFacade enterText;
	
//	@FindBy(id = "add-to-cart-button")
//	WebElementFacade addTocart;
	
	@FindBy(name = "dropdown_selected_size_name")
	WebElementFacade selectSize;
	
	@FindBy(xpath = "//*[@title='Add to Shopping Cart']")
	WebElementFacade addTocart;
	
	
	@FindBy(xpath = "//*[@id='nav-cart-count']")
	WebElementFacade cartCount;
	
	public AmazonPage(WebDriver driver) {
		super(driver);
	}
	
	public void searchTheItem(String text) {
		enterText.isVisible();
		enterText.typeAndEnter(text);
	}
		
	public void addProductToCart() {	
		String currentWindow=getDriver().getWindowHandle();
		$("//span[text()='Mens Revolution 6 Nn Running Shoe']").isVisible();
		$("//span[text()='Mens Revolution 6 Nn Running Shoe']").click();
		Set<String> windows=getDriver().getWindowHandles();
		windows.remove(currentWindow);
		String newWindow="";
		for (String string : windows) {
			newWindow=string;
		}
		getDriver().switchTo().window(newWindow);
		selectSize.isClickable();
		selectSize.selectByVisibleText(" 6 UK (6.5 US) ");
		addTocart.waitUntilEnabled();
		evaluateJavascript("arguments[0].scrollIntoView(true);",addTocart);
		withAction().moveToElement(addTocart).build().perform();
		addTocart.click();
	}
	
	public void navigateToCartPage() {
		cartCount.waitUntilVisible();
	}
	
	public void validateProductAddedInCart() {
		String count=cartCount.getText();
		assertEquals("1", count);
	}
	
	public void exitFromApplication() {
		getDriver().quit();
	}
}
