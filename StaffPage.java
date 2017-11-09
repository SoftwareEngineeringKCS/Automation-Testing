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

}
