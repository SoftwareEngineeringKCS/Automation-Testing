package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GuiUtils {
	
	/*
	 * get handle for webdriver with a specific browser instance
	 */
	
public WebDriver getBrowserDriver(String browser) {
		
		WebDriver driver = null;
		
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/adnanrahman/Desktop/chromedriver");
			driver = new ChromeDriver();			
		}
		
		return driver;
		//
	
	}
	
	
	public void clickElementByXpath(WebDriver driver, String xpath) throws InterruptedException {
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();
	}
	
	public void clickElementByName(WebDriver driver, String name) throws InterruptedException {
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.name(name));
		element.click();
	}
	
	
	public void selectItemFromDropdownByName(WebDriver driver, String dropdownName, String nameOfItem) throws InterruptedException{
		Thread.sleep(1000);
		Select dropdownElementSelect = new Select(driver.findElement(By.name(dropdownName)));
		dropdownElementSelect.selectByVisibleText(nameOfItem);
	}
	
	public void enterTextBoxByXpath(WebDriver driver, String xpath, String textInput) throws InterruptedException{
		Thread.sleep(1000);
		WebElement textBox = driver.findElement(By.xpath(xpath));
		textBox.click();
		textBox.clear();
		Thread.sleep(1000);
		textBox.sendKeys(textInput);
	}
	
	public boolean elementExists(WebDriver driver, String xpath) throws InterruptedException {
		Thread.sleep(1000);
		WebElement textBox = driver.findElement(By.xpath(xpath));
		boolean exists = textBox.isDisplayed();
		return exists;
	}
	
	public String readElementByXpath(WebDriver driver, String xpath) throws InterruptedException {
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath(xpath));
		String text;
		text = element.getText();
		return text;	
	}
	

}

