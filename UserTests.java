package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.AppointmentsPage;
import Pages.CheckInPage;
import Pages.StaffPage;
import Utils.GuiUtils;
import Utils.Variables;

public class UserTests {
	
	GuiUtils gu = new GuiUtils();
	
	public WebDriver driver;
	//String homepage = "http://sim.kean.edu/~espadajo/index.php";
	String homepage = "http://eve.kean.edu/~espadajo/";
	CheckInPage cip = new CheckInPage();
	AppointmentsPage ap = new AppointmentsPage();
	StaffPage sp = new StaffPage();
		
		@BeforeTest
		public void setUp() throws Exception {
			driver = gu.getBrowserDriver("Chrome");
			driver.manage().window().maximize();
			driver.get(homepage);
		}
		
		@AfterTest
		public void tearDown() throws Exception {
			driver.quit();
		}
		
		@Test
		public void testValidCheckInByWalkIn() throws InterruptedException {
			String actualMessage = cip.validateWalkInMessage(gu, driver, Variables.CAREER_SERVICE_LOCATION, Variables.CONSULTANT_1, 
					Variables.REASON_OTHER, Variables.STUDENT_ID_1, Variables.FIRST_NAME_1, Variables.LAST_NAME_1, Variables.EMAIL_1);
		    
	        String expectedMessage = "Check-In Result\nWalk-In\n" + "Student ID: " + Variables.STUDENT_ID_1 + "\n" + "Name: " + Variables.LAST_NAME_1 + ", " + Variables.FIRST_NAME_1 + "\n"
					+ "Reason: " + Variables.REASON_OTHER + "\n" + "Consultant: " + Variables.CONSULTANT_1 + "\n" + "Location: " + Variables.CAREER_SERVICE_LOCATION + "\n" + "Take a seat please.";
	        
	        System.out.println("\n\nTEST: testValidCheckInByWalkIn\n\nExpected:\n" + expectedMessage + "\n\nActual:\n" + actualMessage + "\n\n");
	        
	        Assert.assertEquals(actualMessage, expectedMessage);     	
		}
		
		@Test
		public void testInvalidCheckInByWalkIn() throws InterruptedException {
			String actualMessage = cip.validateInvalidWalkInMessage(gu, driver);
		    
	        String expectedMessage = "Check-In Result\nWalk-In\nThe following fields cannot be empty!\n\"Reason\"\n\"ID\"\n\"First Name\"\n\"Last Name\"\n\"E-mail\"\n\"Consultant\"\n";
	        
	        System.out.println("\n\nTEST: testInvalidCheckInByWalkIn\n\nExpected:\n" + expectedMessage + "\n\nActual:\n" + actualMessage + "\n\n");
	        
	        Assert.assertEquals(actualMessage, expectedMessage);     	
		}
		
		
		public void testValidMakeAppointment() throws InterruptedException {
			ap.makeAppointment(gu, driver, Variables.CAREER_SERVICE_LOCATION, Variables.CONSULTANT_1, 
					Variables.REASON_OTHER, Variables.STUDENT_ID_1, Variables.FIRST_NAME_1, Variables.LAST_NAME_1, Variables.EMAIL_1, Variables.CELL_PHONE_1);
		}
		
		
		public void testValidCheckInByAppointment() throws InterruptedException {
			//cip.checkInByAppointment(gu, driver, Variables.STUDENT_ID_1, Variables.CONFIRMATION_CODE_1);
		}
		
		
		public void testStuffLogin() throws InterruptedException {
			sp.signInAsStuff(gu, driver, Variables.USERNAME_1, Variables.PASSWORD_1);
		}
		
		@Test
		public void testStaffSetAvaliability() throws InterruptedException {
			sp.signInAsStuff(gu, driver, Variables.USERNAME_1, Variables.PASSWORD_1);
			sp.setAvailability(gu, driver, Variables.JANUARY, Variables.DAY_8, Variables.YEAR_2018, Variables.JANUARY, Variables.DAY_11, 
					Variables.YEAR_2018, Variables.TIME_09, Variables.TIME_13, Variables.DURATION_60);
			Assert.assertTrue(gu.elementExists(driver, Variables.TABLE_VALIDATION_XPATH));
		}

		


}
