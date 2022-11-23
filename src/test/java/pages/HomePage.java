package pages;



import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webelements.Checkbox;

public class HomePage extends PageObject{

	@FindBy(name="firstname")
	WebElementFacade Firstname;
	
	@FindBy(id="continents")
	WebElementFacade continentsDropdown;
	
	@FindBy(xpath = "//input[@value='Manual Tester']")
	WebElementFacade manualTesterChkbox;
	
	@FindBy(xpath = "//input[@value='Automation Tester']")
	WebElementFacade automationTesterChkbox;
	
	@FindBy(id = "photo")
	WebElementFacade photoUpload;
	
	@FindBy(xpath = "//div[@class='overflowable-contents']/div/ul/li//a[contains(text(),'Interviews')]")
	WebElementFacade interviewsLabel;
	
	@FindBy(xpath = "//button[text()='Alert Box']")
	WebElementFacade alertBoxButton;
	
	@FindBy(xpath = "//button[text()='Confirm Alert Box']")
	WebElementFacade confirmAlertBoxButton;
	
	@FindBy(xpath = "//button[text()='Prompt Alert Box']")
	WebElementFacade promptAlertBoxButton;
	
	Checkbox manualCheck=new Checkbox(manualTesterChkbox);
	
	Checkbox automationCheck=new Checkbox(automationTesterChkbox);
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void verifyAndEnterDetailsInFields(String text) {
		find("//input[@name='firstname']").sendKeys(text);
		findBy("//input[@name='firstname']").clear();
		$("//input[@name='firstname']").sendKeys("user");//find the element based on XPATH
		//Firstname.sendKeys(text);
		System.out.println(findAll("//a").size());//retruns list of web elements
		System.out.println($$("//input[@name='firstname']").size());//retruns list of web elements
		Firstname.type(text);
		Firstname.typeAndEnter(text);
		Firstname.typeAndTab(text);
		typeInto(Firstname, text);
		Firstname.clear();
		Firstname.click();
		continentsDropdown.selectByIndex(0);
		continentsDropdown.selectByVisibleText("Europe");
		continentsDropdown.containsSelectOption("Africa");
		manualCheck.setChecked(true);
		manualCheck.isChecked();
		System.out.println(automationCheck.isChecked());
		automationCheck.setChecked(false);
		upload("C:\\Users\\kella\\Documents\\ShareX\\Screenshots\\2022-10\\ShareX_xqMB940mhm.png").to(photoUpload);
		evaluateJavascript("arguments[0].scrollIntoView(true);",interviewsLabel);
		withAction().moveToElement(interviewsLabel).build().perform();
		interviewsLabel.isVisible();
		interviewsLabel.isPresent();
		interviewsLabel.shouldBeVisible();//assertion 
		System.out.println(Firstname.hasFocus());
		Firstname.click();
		System.out.println(Firstname.hasFocus());
		System.out.println(Firstname.containsText("First"));
		Firstname.shouldContainText("");
		
		
	}
	
	public void validateAlertHandling() {
		//https://nxtgenaiacademy.com/alertandpopup/
		alertBoxButton.click();
		System.out.println("Alert Text:"+getAlert().getText());
		getAlert().accept();
		confirmAlertBoxButton.click();
		System.out.println("Alert Text:"+getAlert().getText());
		getAlert().dismiss();
		promptAlertBoxButton.click();
		getAlert().sendKeys("Test");
		getAlert().accept();		
	}
		
}
