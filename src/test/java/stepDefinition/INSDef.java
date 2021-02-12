package stepDefinition;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.insta_homeObjs;
import pageObjects.insta_loginObjs;
import utils.*;


import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.PageFactory.initElements;

public class INSDef extends driveFactory {

	private static readProperties configProperties = new readProperties("./src/test/Resources/config/config.properties");
	insta_homeObjs IHOpage;
	insta_loginObjs ILOpage;

	@Given("user enters correct ([^\"]*)")
	public void user_enters_correct_usrname(String usrname) throws Exception {

		System.out.println("Initialiasing driver");
		IHOpage = initElements(driver, insta_homeObjs.class);
		ILOpage = initElements(driver, insta_loginObjs.class);

		ILOpage.cookies_Accept();

		ILOpage.setInstaUsrnme(usrname);

	}

	@Then("user types ([^\"]*)")
	public void user_enters_passwrd(String passwrd) {
		ILOpage.setInstaPsswrd(passwrd);
	}

	@Then("user clicks on Sign In button")
	public void clicks_on_Login_button() throws InterruptedException {

		ILOpage.clickSubmitBttn();
	}

	@Then("use is taken to instagram Home page with logo displayed")
	public void use_is_taken_to_instagram_Home_page_with_logo_displayed() throws InterruptedException {

		try {
			IHOpage.saveLoginNotNOw();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(2000);

//		IHOpage.notififactionMessge();
//		IHOpage.clickNotif();

		Assert.assertTrue(IHOpage.InstagramIconVisible());
		IHOpage.Instagram_icon();
	}

	@When("user inserts in search field a ([^\"]*)")
	public void user_types_in_search_field_a_hashtag(String hshtag) {
		Assert.assertTrue(IHOpage.SearchBarVisible());
		IHOpage.SearchBar(hshtag);
	}

	@When("navigates to ([^\"]*)")
	public void clicks_on_hashtag(String searchHshTag) throws InterruptedException {
		IHOpage.chooseFirstOnList(searchHshTag);
	}

	@Then("is able to like multiple posts from collection")
	public void is_able_to_like_multiple_posts_from_collection() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWait wait = new WebDriverWait(driver, 10);

		List<WebElement> posts = driver.findElements(By.xpath("//article/div[2]//a[@href]"));
		System.out.println("total posts: " + posts.size());

		for (int i = 0; i < posts.size(); i++) {


			WebElement post = posts.get(i);

			System.out.println(post.getAttribute("href"));
			Thread.sleep(1000);

			post.click();

			wait.until(ExpectedConditions.elementToBeClickable(IHOpage.mainPageHidden()));
			Thread.sleep(5000);


			WebElement isLikable = IHOpage.getLikeHeart();
			Thread.sleep(2000);

			if (isLikable.isDisplayed()) {

				Thread.sleep(1000);

				System.out.println("liking post...");

				Thread.sleep(1000);

				Random randomWait = new Random();

				long randomClick = randomWait.nextInt(Math.toIntExact((long) (Math.random() * 60000)));
				System.out.println("random time: " + randomClick);

				Thread.sleep(randomClick);

				IHOpage.getLikeHeart().click();
				Thread.sleep(1000);
				//	wait.until(ExpectedConditions.elementToBeClickable(IHOpage.xPost())).click();
			} else {
				try {
					if (IHOpage.unlikeHeart()) {
						System.out.println("unable to like post");
						wait.until(ExpectedConditions.elementToBeClickable(IHOpage.xPost())).click();
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(IHOpage.xPost())).click();
			}

			Thread.sleep(1000);

			wait.until(ExpectedConditions.elementToBeClickable(IHOpage.xPost())).click();
		}
	}
}

