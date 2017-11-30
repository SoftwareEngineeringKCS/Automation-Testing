package Pages;

import org.openqa.selenium.WebDriver;

import Utils.GuiUtils;
import Utils.Variables;

public class StaffPage {
	
	public void signInAsStuff(GuiUtils gu, WebDriver driver, String username, String password) throws InterruptedException {
		gu.clickElementByXpath(driver, Variables.STAFF_TAB_XPATH);
		gu.enterTextBoxByXpath(driver, Variables.USERNAME_TB_XPATH, username);
		gu.enterTextBoxByXpath(driver, Variables.PASSWORD_TB_XPATH, password);
		gu.clickElementByXpath(driver, Variables.SIGN_IN_B_XPATH);
	}
	
	//Set availability for mon, tues, wed
	public void setAvailability(GuiUtils gu, WebDriver driver, String start_month, String start_day, String start_year, 
			String end_month, String end_day, String end_year, String start_time, String end_time, String duration) throws InterruptedException {
		gu.clickElementByXpath(driver, Variables.SET_AVAILABILITY_RB_XPATH);
		gu.selectItemFromDropdownByName(driver, Variables.START_MONTH_NAME, start_month);
		gu.selectItemFromDropdownByName(driver, Variables.START_DAY_NAME, start_day);
		gu.enterTextBoxByXpath(driver, Variables.START_YEAR_XPATH, start_year);
		gu.selectItemFromDropdownByName(driver, Variables.END_MONTH_NAME, end_month);
		gu.selectItemFromDropdownByName(driver, Variables.END_DAY_NAME, end_day);
		gu.enterTextBoxByXpath(driver, Variables.END_YEAR_XPATH, end_year);
		gu.selectItemFromDropdownByName(driver, Variables.START_TIME_NAME, start_time);
		gu.selectItemFromDropdownByName(driver, Variables.END_TIME_NAME, end_time);
		gu.clickElementByXpath(driver, Variables.MONDAY_CB_XPATH);
		gu.clickElementByXpath(driver, Variables.TUESDAY_CB_XPATH);
		gu.clickElementByXpath(driver, Variables.WEDNESDAY_CB_XPATH);
		gu.selectItemFromDropdownByName(driver, Variables.DURATION_NAME, duration);
		
		gu.clickElementByName(driver, Variables.SET_AVAILABILITY_B_NAME);
		gu.clickElementByXpath(driver, Variables.SET_AVAILABILITY_BACK_XPATH);
	}

}
