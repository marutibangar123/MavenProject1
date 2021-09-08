package FleetStudio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_pom1
{
	@FindBy(xpath="//a[text()='Contact']")private WebElement Contact;
		
	
	
public Contact_pom1(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void ContactClic()
{
	Contact.click();
}

}
