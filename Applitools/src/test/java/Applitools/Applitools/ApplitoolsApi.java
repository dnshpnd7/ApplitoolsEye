package Applitools.Applitools;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.exceptions.TestFailedException;
import com.applitools.eyes.selenium.Eyes;


public class ApplitoolsApi {
	
	public static void main(String[] args) {

	    //Use Chrome browser
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dinu\\eclipse-workspace\\Applitools\\Applitools\\TestData\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();

	  // Initialize the eyes SDK and set your private API key.
	  Eyes eyes = new Eyes();

	  // Set the API key from the env variable. Please read the "Important Note"
	  // section above.
	  eyes.setApiKey("tBBIXCftWNFv109cAaI45n6ZRmETknqRuziCeMtL0UEHo110");

	  try {


	   // Start the test by setting AUT's name, window or the page name that's being tested, viewport width and height
	   eyes.open(driver, "appName","windowName", new RectangleSize(800, 600));

	   // Navigate the browser to the "ACME" demo app
	   driver.get("https://demo.applitools.com");

	   // Visual checkpoint #1.
	   eyes.checkWindow("Login window");

	      //🌟 Note: You can have multiple "checkWindow" to create multiple test steps within a test.🌟  
	      //For example, you may want to test errors in the login window after clicking a login button,
	      //In that case, you may add the following before you call eyes.close(). 
	      //This will create a test with two test steps.
	      //driver.click("login");
	      //eyes.checkWindow("Login Window Error");

	   // End the test.
	   eyes.close();

	  } catch (TestFailedException e) {
	    System.out.println("\n" + e + "\n");
	  } finally {

	   // Close the browser.
	   driver.quit();

	   // If the test was aborted before eyes.close was called, ends the test as
	   // aborted.
	   eyes.abortIfNotClosed();

	   // End main test
	   System.exit(0);
	  }

	 }
	}

