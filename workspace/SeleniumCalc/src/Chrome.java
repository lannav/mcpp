import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Suite.class)
@SuiteClasses({ Existence.class, Simple.class, Complex.class, RealJob.class })
public class Chrome 
{
	public static WebDriver driver;
	
	@BeforeClass
	public static void StartBrow()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:\\Users\\Admin\\Desktop\\calc.html");
	}
	
	@AfterClass
	public static void CloseBrow()
	{
		driver.close();
	}
}