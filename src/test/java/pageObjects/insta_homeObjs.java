package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class insta_homeObjs {


	public WebDriver driver;
	private WebElement expectMssge;

	public insta_homeObjs(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Instagram_HomePage_obj constructor complete");
	}

	//Objects
	@FindBy(xpath = "/*[@class = 'COOzN ']//*[contains(text(),'Stories')]")
	WebElement Stories_Text;

	@FindBy(xpath = "//*[@aria-label = 'Activity Feed']")
	WebElement ActivityFeed_button;

	@FindBy(xpath = "//*[@aria-label = 'Profile']")
	WebElement Profile_button;

	@FindBy(xpath = "//*[@alt= 'Instagram']")
	WebElement Instagram_icon_button;

	@FindBy(xpath = "//*[contains(@class,'logo') and (@aria-label = 'Instagram')]")
	WebElement Instagram_logo_button;

	@FindBy(xpath = "//*[@placeholder= 'Search']")
	WebElement Search_bar;

	@FindBy(xpath = "//*[@class ='LWmhU _0aCwM']//*[@role ='button']")
	WebElement Search_X_button;


	@FindBy(xpath = "//span[@class='Ap253']")
	WebElement Search_First_item;

	@FindBy(xpath = "//button[@class='dCJp8 ']")
	WebElement foundAccount2MessageList;

	@FindBy(xpath = "//button[text()='Next']")
	WebElement nxtBttnInMessage;

	@FindBy(xpath = "//*[@class='piCib']//button[text() = 'Not Now']")
	WebElement notifNotNow_popUp;


	@FindBy(xpath = "//*[text()='Not Now']")
	WebElement saveloginNotNow;

	@FindBy(xpath = "//h2[contains(text(),'Turn on Notifications')]")
	WebElement TurnOnNotificationMssge;


	@FindBy(xpath = "//section[@class='ltpMr Slqrh']//*[@aria-label='Like']//parent::button")
	WebElement likeHeart;

//	@FindBy(xpath = "//section[@class='ltpMr Slqrh']//*[@aria-label='Like']")
//	WebElement likeHeart;

	@FindBy(xpath = "//*[@aria-label='More options']")
	WebElement moreOptionsEllipse ;

	@FindBy(xpath = "//section[@class='ltpMr Slqrh']//*[@aria-label='Unlike']")
	WebElement unlikeHeart;

	@FindBy(xpath = "//h2[contains(text(),'Sorry, this')]")
	WebElement privatePage;

	@FindBy(xpath = "//h2[contains(text(),'Restricted Video')]")
	WebElement RestrictedVideo;

	@FindBy(xpath = "//*[text()='Top posts']")
	WebElement topPostTxt;

	@FindBy(xpath = "//*[text()='Most recent']")
	WebElement postRecentTxt;


	@FindBy(xpath = "//span[text()='Posts']")
	WebElement accountPostTab;


	@FindBy(xpath = "//button[@class='wpO6b ZQScA']")
	WebElement newMessageIcon;


	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement searchMessageAccount ;

	@FindBy(xpath = "//textarea[@placeholder='Message...']")
	WebElement inputMssgeField ;

	@FindBy(xpath = "//button[text()='Send']")
	WebElement sendMessage ;

	@FindBy(xpath = "//*[contains(@class,'Igw0E     IwRSH       hLiUi       vwCYk')]")
	WebElement messageExistsAlready ;

	@FindBy(xpath = "//article/div[2]//a[@href]")
	WebElement articlePostFeed;


	@FindBy(xpath = "//*[@class='_2dDPU CkGkG']//button//*[@aria-label='Close']//parent::button")
	WebElement xPost;

	@FindBy(xpath = ("//*[@style='overflow: hidden;']"))
	WebElement mainPageHidden;


//actions

	public WebElement xPost()
	{
		return xPost;
	}

	public void Stories_widget()
	{
		Stories_Text.isDisplayed();
	}

	public void ActivityFeed()
	{
		ActivityFeed_button.click();
	}

	public void Profile()
	{
		Profile_button.click();
	}

	public void Instagram_icon()
	{
		Instagram_icon_button.click();
	}
	public boolean InstagramIconVisible() throws InterruptedException {
		Instagram_icon_button.isDisplayed();
		return true;

	}
	public void Instagram_logo()
	{
		Instagram_logo_button.click();
	}
	public void SearchBar(String hashtag)
	{
		Search_bar.sendKeys(hashtag);
	}
	public boolean SearchBarVisible()
	{
		Search_bar.isDisplayed();
		return  true;
	}
	public void Search_X() { Search_X_button.click();}

	public  void chooseFirstOnList(String hashtag) throws InterruptedException {

		Search_First_item
				.findElement(By.xpath("//*[text()='" + hashtag + "']"))
				.click();
		driver.navigate().refresh();
	}

	public boolean searchedItemVisible(String hashtag) throws InterruptedException {

		Search_First_item
				.findElement(By.xpath("//*[text()='" + hashtag + "']"))
				.isDisplayed();
		return true;
	}

	public boolean presentSaveLoginNotNow()
	{
		return saveloginNotNow.isDisplayed();

	}


	public void saveLoginNotNOw() {
		if(this.presentSaveLoginNotNow()) {
			try {

				Thread.sleep(2000);
				ExpectedConditions.elementToBeClickable(saveloginNotNow);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		saveloginNotNow.click();
	}



	public void clickNotif (){
		try {
			Thread.sleep(2000);
			ExpectedConditions.elementToBeClickable(notifNotNow_popUp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		notifNotNow_popUp.click();
	}

	public boolean notififactionMessge ()
	{
		TurnOnNotificationMssge.isDisplayed();
		return true;
	}

	public void accountPostTab()
	{
		try {
			Thread.sleep(2000);
			ExpectedConditions.visibilityOf(accountPostTab);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void clickLikeBttn () throws InterruptedException {
		Thread.sleep(14000);
		ExpectedConditions.elementToBeClickable(likeHeart);
		likeHeart.click();
	}


	public boolean unlikeHeart ()  {
		unlikeHeart.isDisplayed();
		return true;
	}

	public WebElement getLikeHeart(){
		return likeHeart;
	}

	public boolean privatePageMessge () {
		privatePage.isDisplayed();
		return true;
	}

	public boolean RestrictedVideo(){
		RestrictedVideo.isDisplayed();
		return true;
	}

	public boolean topPostTxt(){
		topPostTxt.isDisplayed();
		return true;
	}
	public boolean recentPostTxt()
	{
		postRecentTxt.isDisplayed();
		return true;
	}

	public boolean moreOptionsEllipseDots()
	{
		moreOptionsEllipse.isDisplayed();
		return true;
	}

	public void clickNewMessageicon () throws InterruptedException {
		Thread.sleep(14000);
		ExpectedConditions.elementToBeClickable(newMessageIcon);
		newMessageIcon.click();
	}

	public void setSearchMessageAccount (String user2Message) throws InterruptedException {
		Thread.sleep(14000);
		ExpectedConditions.elementToBeClickable(searchMessageAccount);
		searchMessageAccount.click();
		searchMessageAccount.sendKeys(user2Message);
	}

	public void clickAccountInMssgeList () throws InterruptedException {
		Thread.sleep(14000);
		ExpectedConditions.elementToBeClickable(foundAccount2MessageList);
		foundAccount2MessageList.click();
	}

	public void clickNxtBttn () throws InterruptedException {
		Thread.sleep(14000);
		ExpectedConditions.elementToBeClickable(nxtBttnInMessage);
		nxtBttnInMessage.click();
	}

	public void setMessgeInField (String mssge) throws InterruptedException {
		Thread.sleep(14000);
		ExpectedConditions.elementToBeClickable(inputMssgeField);
		inputMssgeField.click();
		inputMssgeField.sendKeys(mssge);
	}

	public void clickSendMessage () throws InterruptedException {
		Thread.sleep(14000);
		ExpectedConditions.elementToBeClickable(sendMessage);
		sendMessage.click();
	}

	public boolean mssgeExists (String mssgeThatExists) throws InterruptedException { Thread.sleep(5000);
		messageExistsAlready.findElement(By.xpath("//*[text()='" + mssgeThatExists + "']")).isDisplayed();
		return false;
	}

	public WebElement articlePosts () throws InterruptedException { Thread.sleep(5000);

		return articlePostFeed;
	}

	public WebElement mainPageHidden () throws InterruptedException { Thread.sleep(5000);

		return mainPageHidden;
	}

}
