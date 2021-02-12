package stepDefinition.twitter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import pageObjects.twitter.twitter_HomePageObjs;
import pageObjects.twitter.twitter_LoginObjs;
import utils.driveFactory;
import utils.readProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import static org.openqa.selenium.support.PageFactory.initElements;

public class twitterPostStepDef extends driveFactory {
	private static readProperties configProperties = new readProperties("./src/test/Resources/config/config.properties");

	twitter_LoginObjs twitterLObjs;
	twitter_HomePageObjs twitterHObjs;


	@Given("User navigates to url")
	public void user_navigates_to_url() {


		System.out.println("Initialiasing driver");
		twitterLObjs = initElements(driver, twitter_LoginObjs.class);
		twitterHObjs = initElements(driver, twitter_HomePageObjs.class);
	}

	@When("user enter ([^\"]*) and ([^\"]*)")
	public void user_enter_learnhow_makeup_and_Joshua(String userName, String passWord) {
		twitterLObjs.setUserName(userName);
		twitterLObjs.setPassword(passWord);
	}

	@When("user clicks the login button")
	public void user_clicks_the_login_button() {
		twitterLObjs.clickLoginBttn();

	}

	@Then("user is taken to home page with profile displayed")
	public void user_is_taken_to_home_page_with_profile_displayed() {

		Assert.assertTrue(twitterHObjs.getHomeTextDisplayed());

	}

	@Then("user inserts text into tweet text field  and posts tweet")
	public void user_inserts_text_into_text_field_and_posts_tweet() throws InterruptedException, IOException {


		File src = new File("//Users//Joe.obasogie//Desktop//Nerd/emailDatabase//JGreySocialMediaList_Messages.xls");
		FileInputStream fis = new FileInputStream(src);
		// XSSFWorkbook wb = new XSSFWorkbook(fis); //we use XSSWorkbook when the excel format is xlsx
		HSSFWorkbook wb = new HSSFWorkbook(fis); // >>> we use HSSWorkbook when the excel format is xls

		HSSFSheet mssgeSheet = wb.getSheetAt(4);

		int rowcount = mssgeSheet.getLastRowNum();


		System.out.println("Total rows is " + rowcount);



		for (int i = 1; i < rowcount; i++) {
			//Get me excel data
			String mssge = mssgeSheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Message to send: " + mssge);

			Thread.sleep(3000);

			//continue with Twitter

			twitterHObjs.setTweetField(mssge);

			//Post at random time
			Random randomWait = new Random();
			long randomClick = randomWait.nextInt(Math.toIntExact((long) (Math.random() * 60000)));
			System.out.println("random time: " + randomClick);

			Thread.sleep(randomClick);

			//twitterHObjs.tweetButtonClick();

			Thread.sleep(12000);
			Date date = java.util.Calendar.getInstance().getTime();
			System.out.println("message posted at: " + date);

		}
		wb.close();
		System.out.println("Post complete");

	}




	/*  driver.get("https://www.instagram.com/direct/inbox/");
        //ReadExcel data

        File src = new File("//Users//Joe.obasogie//Desktop//Nerd/emailDatabase//chau_codes//chau_codes_xls.xls");
        FileInputStream fis = new FileInputStream(src);
        // XSSFWorkbook wb = new XSSFWorkbook(fis); //we use XSSWorkbook when the excel format is xlsx
        HSSFWorkbook wb = new HSSFWorkbook(fis); // >>> we use HSSWorkbook when the excel format is xls
        HSSFSheet userNameSheet =  wb.getSheetAt(0);
        HSSFSheet mssgeSheet =  wb.getSheetAt(3);

        int rowcount =userNameSheet.getLastRowNum();

        System.out.println("Total rows is " + rowcount);


        for (int i = 1; i < rowcount; i++) {
            //Get me excel data
            String user2Message = userNameSheet.getRow(i).getCell(0).getStringCellValue();
            System.out.println("userName count: " + i + " userName ID is: " + user2Message);

            String mssge = mssgeSheet.getRow(1).getCell(1).getStringCellValue();
            System.out.println("Message to send: " + mssge);

            Thread.sleep(3000);

            //continue with Instagram
            IHOpage.clickNewMessageicon();

            IHOpage.setSearchMessageAccount(user2Message);

            IHOpage.clickAccountInMssgeList();
            IHOpage.clickNxtBttn();
            Thread.sleep(4000);

            IHOpage.setMessgeInField(mssge);
            IHOpage.clickSendMessage();
            Thread.sleep(12000);
            System.out.println(user2Message + ": has been sent a message");

        }

        wb.close();
        System.out.println("Messages complete");

    }

	 */
}
