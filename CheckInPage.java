package Pages;

import org.openqa.selenium.WebDriver;

import Utils.GuiUtils;
import Utils.Variables;

public class CheckInPage {
	
	public void checkInByWalkIn(GuiUtils gu, WebDriver driver, String location_choice,
			String consultant_choice, String reason_choice, String student_id, String first_name, String last_name, String email) throws InterruptedException {
		gu.clickElementByXpath(driver, Variables.CHECK_IN_TAB_XPATH);
		gu.clickElementByXpath(driver, Variables.WALK_IN_RB_XPATH); //RB = radio-button
		if(location_choice!=null) gu.selectItemFromDropdownByName(driver, Variables.LOCATION, location_choice);
		if(consultant_choice!=null) gu.selectItemFromDropdownByName(driver, Variables.CONSULTANT, consultant_choice);
		if(reason_choice!=null) gu.selectItemFromDropdownByName(driver, Variables.REASON, reason_choice);
		if(student_id!=null) gu.enterTextBoxByXpath(driver, Variables.WALK_IN_TAB_STUDENT_ID_XPATH, student_id);
		if(first_name!=null) gu.enterTextBoxByXpath(driver, Variables.FIRST_NAME_XPATH, first_name);
		if(last_name!=null) gu.enterTextBoxByXpath(driver, Variables.LAST_NAME_XPATH, last_name);
		if(email!=null) gu.enterTextBoxByXpath(driver, Variables.EMAIL_XPATH, email);
		gu.clickElementByName(driver, Variables.SUBMIT_NAME);
	}
	
	public void checkInByAppointment(GuiUtils gu, WebDriver driver, String student_id, String confirmation_number) throws InterruptedException {
		gu.clickElementByXpath(driver, Variables.CHECK_IN_TAB_XPATH);
		gu.clickElementByXpath(driver, Variables.BY_APPOINTMENT_RB_XPATH);
		gu.enterTextBoxByXpath(driver, Variables.BY_APPOINTMENT_TAB_STUDENT_ID_XPATH, student_id);
		gu.enterTextBoxByXpath(driver, Variables.CONFIRMATION_CODE_TB_XPATH, confirmation_number);
		gu.clickElementByName(driver, Variables.SUBMIT_NAME);
	}
	
	public String validateWalkInMessage(GuiUtils gu, WebDriver driver, String location, String consultant, String reason, 
			String student_id, String first_name, String last_name, String email) throws InterruptedException {
		
		checkInByWalkIn(gu, driver, location,
				consultant, reason, student_id, first_name, last_name, email);
		StringBuilder sb = new StringBuilder("");
		sb.append(gu.readElementByXpath(driver, Variables.CHECK_IN_RESULT_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.WALK_IN_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.DIV3_P1_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.DIV3_P2_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.DIV3_P3_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.DIV3_P4_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.DIV3_P5_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.TAKE_SEAT_XPATH));
		
		
		//System.out.println("||||\n" + gu.readElementByXpath(driver, "html/body/div[3]" + "\n|||||"));
		
		return sb.toString();
	}
	
	
	public String validateInvalidWalkInMessage(GuiUtils gu, WebDriver driver) throws InterruptedException {
		
		checkInByWalkIn(gu, driver, null, null, null, null, null, null, null);
		StringBuilder sb = new StringBuilder("");
		sb.append(gu.readElementByXpath(driver, Variables.CHECK_IN_RESULT_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.WALK_IN_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.FIELD_CANNOT_BE_EMPTY_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.DIV3_P1_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.DIV3_P2_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.DIV3_P3_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.DIV3_P4_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.DIV3_P5_XPATH) + "\n");
		sb.append(gu.readElementByXpath(driver, Variables.DIV3_P6_XPATH) + "\n");
		//sb.append(gu.readElementByXpath(driver, Variables.TRY_AGAIN_XPATH));
		return sb.toString();
	}
	
	

}
