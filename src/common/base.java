package common;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	PropertyFileHandler pro=new PropertyFileHandler();
	WebDriver driver=null;

	/*
	 * These functions are written to set chrome desired capabilities and launch the facebook page 
	 * @return webdriver
	 * @param  nothing
	 * @throws exception
	 */

	public WebDriver launchApplication(){
		try {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");

			driver= new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(pro.readProperties("url"));

		} catch(Exception e) {
			System.out.println("Exception raised during launching facebook : "+ e);
		}
		return driver;
	}

	/*
	 * These functions are written to generate random data for sign-up page
	 * @return string
	 * @param  nothing
	 * @throws exception
	 */

	public static String getReandomName(){
		String strCharsApplicable="abcdefghijklmnopqrstuvwxyz";
		return "user" + RandomStringUtils.random(10, strCharsApplicable);
	}

	public static String getRandomMobileNo(){
		return "04" + RandomStringUtils.randomNumeric(8);
	}

	public static String getRandomPassword(){
		return RandomStringUtils.randomAlphanumeric(9)+"1";
	}

	public static String getRandomBirthDay(){
		int max = 28;
		int min = 1;
		int  day = min + (int)(Math.random() * ((max - min) + 1));
		return Integer.toString(day);
	}

	public static String getRandomBirthMonth(){
		String strMonth= null;
		int max = 12;
		int min = 1;
		strMonth = Integer.toString(min + (int)(Math.random() * ((max - min) + 1)));

		switch(strMonth) {
		case "1" :
			strMonth="Jan";
			break; 
		case "2" :
			strMonth="Feb";
			break; 
		case "3" :
			strMonth="Mar";
			break; 
		case "4" :
			strMonth="Apr";
			break; 
		case "5" :
			strMonth="May";
			break; 
		case "6" :
			strMonth="Jun";
			break; 
		case "7" :
			strMonth="Jul";
			break; 
		case "8" :
			strMonth="Aug";
			break; 
		case "9" :
			strMonth="Sept";
			break; 
		case "10" :
			strMonth="Oct";
			break; 

		case "11" :
			strMonth="Nov";
			break; 

		case "12" :
			strMonth="Dec";
			break; 

		default : 
			System.out.println("Wrong month parameter passed in getRandomBirthMonth function");
		}
		return strMonth;
	}

	public static String getRandomBirthYear(){
		int max = 2018;
		int min = 1922;
		int  year = min + (int)(Math.random() * ((max - min) + 1));
		return Integer.toString(year);
	}

	public static String getRandomGender(){
		String strGender=null;
		List<String> lstGenderList =Arrays.asList("female", "male"); 
		Random rand = new Random();
		strGender=lstGenderList.get(rand.nextInt(lstGenderList.size()));
		return  strGender;
	}

}

