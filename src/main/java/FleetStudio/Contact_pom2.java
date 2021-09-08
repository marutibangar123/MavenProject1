package FleetStudio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_pom2
{
	
@FindBy(xpath="//input[@type='text']")	private WebElement Name;
@FindBy(xpath="//input[@type='email']") private WebElement Email;
@FindBy(xpath="(//input[@type='text'])[2]")private WebElement Subject;

public Contact_pom2(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void inpname(String Maruti)
{
	Name.sendKeys(Maruti);
}
public void inpemail(String marutibangar)
{
	Email.sendKeys(marutibangar);
}
public void inpsub(String Cheking)
{
	Subject.sendKeys(Cheking);
}

}

