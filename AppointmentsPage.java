package Pages;

import org.openqa.selenium.WebDriver;

import Utils.GuiUtils;
import Utils.Variables;

public class AppointmentsPage {
	
	public void makeAppointment(GuiUtils gu, WebDriver driver, String location_choice, String consultant_choice, 
			String reason_choice, String student_id, String first_name, String last_name, String email, String cell_phone) throws InterruptedException {
		gu.clickElementByXpath(driver, Variables.APPOINTMENTS_TAB_XPATH);
	    gu.selectItemFromDropdownByName(driver, Variables.LOCATION, location_choice);
		gu.selectItemFromDropdownByName(driver, Variables.CONSULTANT, consultant_choice);
		gu.selectItemFromDropdownByName(driver, Variables.REASON, reason_choice);
		gu.enterTextBoxByXpath(driver, Variables.AP_STUDENT_ID_XPATH, student_id);
		gu.enterTextBoxByXpath(driver, Variables.FIRST_NAME_XPATH, first_name);
		gu.enterTextBoxByXpath(driver, Variables.LAST_NAME_XPATH, last_name);
		gu.enterTextBoxByXpath(driver, Variables.EMAIL_XPATH, email);
		gu.enterTextBoxByXpath(driver, Variables.CELL_PHONE_TB_XPATH, cell_phone);
		gu.clickElementByXpath(driver, Variables.NEXT_BUTTON_XPATH);
			
		}
	}


