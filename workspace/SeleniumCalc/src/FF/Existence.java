package FF;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;

@RunWith(Parameterized.class)
public class Existence 
{
		public String id;
		//public static WebDriver driver;
		
		public Existence(String id)
		{
			this.id = id;
		}
		
		/*@BeforeClass
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
		}*/
		
		@Parameters (name = "button {0}")
		public static Collection<Object[]> exst()
		{
			return Arrays.asList(new Object[][]
					{
						{"0"}, 
						{"1"}, 
						{"2"}, 
						{"3"}, 
						{"4"}, 
						{"5"},
						{"6"}, 
						{"7"}, 
						{"8"}, 
						{"9"}, 
						{"plus"}, 
						{"minus"},
						{"mult"}, 
						{"div"}, 
						{"ravno"}
					});
		}
	
	@Test
	public void existence() 
	{
		assertNotNull(Firefox.driver.findElement(By.id(id)));
	}
}