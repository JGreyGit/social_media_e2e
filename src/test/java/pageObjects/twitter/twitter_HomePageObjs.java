package pageObjects.twitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class twitter_HomePageObjs {

	public WebDriver driver;

	public twitter_HomePageObjs(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
			System.out.println("Twitter_HomePage_obj constructor complete");
		}

	//objects
	@FindBy(xpath = "//span[text()='Home']")
	WebElement homeText;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-13qz1uu']")
	WebElement tweetField;

	@FindBy(xpath = "//div[@data-testid='tweetTextarea_0']")
	WebElement setTweet;

	@FindBy(xpath = "//div[@data-testid='tweetButtonInline']")
	WebElement tweetButton;


	//Action
public Boolean getHomeTextDisplayed()
{
	return homeText.isDisplayed();
}

public void setTweetField(String tweetMessage) throws InterruptedException {
	Thread.sleep(3000);
	setTweet.sendKeys(tweetMessage);

}

public void tweetButtonClick()
{
	tweetButton.click();
}
}
