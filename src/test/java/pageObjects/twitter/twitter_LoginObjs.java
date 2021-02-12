package pageObjects.twitter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class twitter_LoginObjs {
	public WebDriver driver;
	public twitter_LoginObjs(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Twitter_Login_obj constructor complete");
	}

	//objects
	@FindBy(xpath = "//input[@name='session[username_or_email]']")
	WebElement userNme;

	@FindBy(xpath = "//input[@name='session[password]']")
	WebElement pssWrd;

	@FindBy(xpath = "//div[contains(@class,'css-18t94o4 css-1dbjc4n r-urgr8i r-42olwf r-sdzlij r-1phboty r-rs99b7 r-1w2pmg r-v')]")
	WebElement login;



	//actions

	public void setUserName(String usrname){

		userNme.clear();
		userNme.sendKeys(usrname);
	}

	public void setPassword(String pssWord){

		pssWrd.clear();
		pssWrd.sendKeys(pssWord);
	}

	public void clickLoginBttn(){

		login.click();
	}

}
