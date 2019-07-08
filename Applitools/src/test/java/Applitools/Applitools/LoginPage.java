package Applitools.Applitools;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;


	public class LoginPage {
	WebDriver driver;
	Eyes eyes;
	String testName;

	@Before

	public void Setup()
	{
	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dinu\\eclipse-workspace\\Applitools\\Applitools\\TestData\\geckodriver.exe");
	 WebDriver browser=new FirefoxDriver();
	 eyes =new Eyes();
	 eyes.setApiKey("tBBIXCftWNFv109cAaI45n6ZRmETknqRuziCeMtL0UEHo110");
	 driver=eyes.open(browser,"the-internet",testName,new RectangleSize(800,600));
	}

	@Rule
	public TestWatcher watcher=new TestWatcher()
	{
	 @Override
	 protected void  starting(Description description)
	 {
	  testName=description.getDisplayName();
	 }
	 
	};

	@After
	public void TearDown()
	{
	 eyes.abortIfNotClosed();
	 driver.quit();
	}

	@Test
	public void LoginWithValidCredentials()
	{
	 driver.navigate().to("https://the-internet.herokuapp.com/login");
	 eyes.checkWindow("Login Form");
	 driver.findElement(By.xpath("//*[@name='username']")).sendKeys("tomsmith");
	 driver.findElement(By.xpath("//*[@name='password']")).sendKeys("SuperSecretPassword!");
	 driver.findElement(By.xpath("//*[@class='radius']")).click();
	 eyes.checkWindow("logged in");
	 eyes.close();
	}

	}

