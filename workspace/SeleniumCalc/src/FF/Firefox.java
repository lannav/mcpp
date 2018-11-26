package FF;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Suite.class)
@SuiteClasses({ Existence.class, Simple.class, Complex.class, RealJob.class, })
public class Firefox 
{
	public static WebDriver driver;
	
	@BeforeClass
	public static void StartBrow()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\eclipse\\lib\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("file:///C:\\Users\\Admin\\Desktop\\calc.html");
	}
	
	@AfterClass
	public static void CloseBrow()
	{
		driver.close();
	}
}