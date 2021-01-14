package page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// ELELMENT LIBRARY
	// By USER_NAME_FIELD = By.id("username");//
	// WebElement USER_NAME_ELEMENT1 = driver.findElement(By.id("username"));//

	// here its idfferent way in pom to declare element //

	@FindBy(how = How.ID, using = "username")
	WebElement USER_NAME_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	WebElement PASSWORD_ELEMENT;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Sign in')]")
	WebElement SIGNIN_BUTTON_ELEMENT;

	// interactive method // this is mostly prefered //

	public void enterCredentials(String userName, String password) {
		USER_NAME_ELEMENT.sendKeys(userName);
		PASSWORD_ELEMENT.sendKeys(password);
	}

	public void enterUserName(String userName) {
		USER_NAME_ELEMENT.sendKeys(userName);

	}

	public void enterPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);

	}

	public void clickSigninButton() {
		SIGNIN_BUTTON_ELEMENT.click();

	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(sourceFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}
}
