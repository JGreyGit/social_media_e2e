package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class insta_loginObjs {

	public WebDriver driver;

	public insta_loginObjs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("insta_loginObjs constructor created");
	}

	//Lets create Objects
////div[@class="piCib"]//button[@class="aOOlW  bIiDR

	@FindBy(xpath =  "//div[@class='piCib']//button[@class='aOOlW  bIiDR  ']")
	WebElement CookiesAccept;

	@FindBy(xpath = "//*[@name='username']")
	WebElement InstaUsrnme;


	@FindBy(xpath = "//*[@name='password']")
	WebElement InstaPsswrd;

	@FindBy(xpath = "//*[text() = 'Log In']")
	WebElement InstaSubmitBttn;
	//So wae now have the objects we need to Login


	//Lets create Actions

	public void cookies_Accept(){
		if(CookiesAccept.isDisplayed()){
			CookiesAccept.click();
		}
	}
	public void setInstaUsrnme(String name){

		InstaUsrnme.clear();
		InstaUsrnme.sendKeys(name);
	}

	public void setInstaPsswrd(String passwrd){

		InstaPsswrd.clear();
		InstaPsswrd.sendKeys(passwrd);
	}

	public void clickSubmitBttn() {
		InstaSubmitBttn.click();
	}


	public boolean loginBttnVisible()
	{
		boolean lgbttnVisible = InstaSubmitBttn.isDisplayed();
		return  lgbttnVisible;
	}

	public boolean Password_verify()
	{
		InstaPsswrd.isDisplayed();
		return true;
	}





}
