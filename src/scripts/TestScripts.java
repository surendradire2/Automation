package scripts;
import org.testng.annotations.Test;
import common.PropertyFileHandler;
import common.base;
import pages.SignUpPage;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestScripts extends base{
	WebDriver driver=null;
	SignUpPage signup=null;
	PropertyFileHandler prop=null;

	@BeforeMethod
	public void beforeMethod() {
		prop=new PropertyFileHandler();
		driver = launchApplication();
		signup=new SignUpPage(driver);
	}

	@Test
	public void Test_001() {

		String name=base.getReandomName();

		// Enter first name 
		signup.enterFirstname(name);
		
		// Enter surname 
		signup.enterSurname(name);

		// Enter mobile no
		signup.enterMobileOrEmail(base.getRandomMobileNo());

		// Enter password
		signup.enterPassword(base.getRandomPassword());

		// Select day of birth date
		signup.enterDobDay(base.getRandomBirthDay());

		// Select month of birth date
		signup.enterDobMonth(base.getRandomBirthMonth());

		// Select year of birth date
		signup.enterDobYear(base.getRandomBirthYear());

		// Select gender
		signup.selectGender(base.getRandomGender());

		// Click on sign-up button
		signup.clickSignUp();

		// Verify user is logged in or not by user name
		signup.verifySignUpSuccessful();  
		
		// Note : please comment this step above and uncomment the step below. After click on sign-up button user navigating to 
		// a page where either we can see the user name or the logout link. I could have handled this in better way but I am running sort of time.

		// Verify user is logged in or not by log out link
		// signup.verifyLogOutDisplayed();

	}

	@AfterMethod
	public void afterMethod() {
		driver=null;
		signup=null;
	}
}
