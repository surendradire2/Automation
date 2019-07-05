package pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


// this class creates the page element and the functions to be performed on those objects.

public class SignUpPage {

	public WebDriver driver;
	Select dropdown=null;

	@FindBy(name="firstname")
	public WebElement txtFirstname;

	@FindBy(name="lastname")
	public WebElement txtSurname;

	@FindBy(name="reg_passwd__")
	public WebElement txtPassword;

	@FindBy(name="reg_email__")
	public WebElement txtMobileEmail;

	@FindBy(name="birthday_day")
	public WebElement cmbBirthDay;

	@FindBy(name="birthday_month")
	public WebElement cmbBirthMonth;

	@FindBy(name="birthday_year")
	public WebElement cmbBirthYear;

	@FindBy(xpath="//label[contains(text(),'Female')]")
	public WebElement rdoFemale;

	@FindBy(xpath="//label[contains(text(),'Male')]")
	public WebElement rdoMale;

	@FindBy(name="websubmit")
	public WebElement btnSignUp;

	@FindBy(xpath="(//h2[contains(text(),'Enter the code from the SMS message')])[2]")
	public WebElement lblEnterCodeMessage;
	
	@FindBy(xpath="//span[contains(text(),'user')]")
	public WebElement lblLogedInUserName;
	
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	public WebElement lblLogout;
	
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirstname(String firstname){
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(txtFirstname)).sendKeys(firstname);
	}

	public void enterSurname(String surname){
		txtSurname.sendKeys(surname);
	}

	public void enterMobileOrEmail(String mobile){
		txtMobileEmail.sendKeys(mobile);
	}

	public void enterPassword(String password){
		txtPassword.sendKeys(password);
	}

	public void enterDobDay(String day){
		dropdown=new Select(cmbBirthDay);
		dropdown.selectByVisibleText(day);
	}

	public void enterDobMonth(String month){
		dropdown=new Select(cmbBirthMonth);
		dropdown.selectByVisibleText(month);
	}

	public void enterDobYear(String year){
		dropdown=new Select(cmbBirthYear);
		dropdown.selectByVisibleText(year);
	}

	public void selectGender(String gender){
		if (gender.toLowerCase()=="female") {
			rdoFemale.click();
		}else {
			rdoMale.click();
		}
	}

	public void clickSignUp(){
		btnSignUp.click();
	}
	
	public void verifySignUpSuccessful(){
		conditionalWait(driver, lblLogedInUserName, 20);
		assertTrue(lblLogedInUserName.getText().contains("User"));
	}
	
	public void verifyLogOutDisplayed(){
		conditionalWait(driver, lblLogout, 20);
		assertTrue(lblLogout.getText().contains("User"));
	}
	
	public void conditionalWait(WebDriver driver , WebElement we, int seconds){
		new WebDriverWait(driver,seconds).until(ExpectedConditions.visibilityOf(we));
	}
	
	
}
