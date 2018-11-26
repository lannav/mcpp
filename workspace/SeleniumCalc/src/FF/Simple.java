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
public class Simple 
{
		//public static WebDriver driver;
		public String id;
		public String opRes;
		public String exp;
		
		public Simple(String id, String opRes, String exp)
		{
			this.id = id;
			this.opRes = opRes;
			this.exp = exp;
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
		public static Collection<Object[]> buttons()
		{
			return Arrays.asList(new Object[][]
					{
				{"0","res","0"}, 
				{"1","res","1"}, 
				{"2","res","2"}, 
				{"3","res","3"}, 
				{"4","res","4"}, 
				{"5","res","5"},
				{"6","res","6"}, 
				{"7","res","7"}, 
				{"8","res","8"}, 
				{"9","res","9"}, 
				{"plus","op","+"}, 
				{"minus","op","-"},
				{"mult","op","*"}, 
				{"div","op","/"}, 
				{"ravno","op","="}
					});
		}
	
	@Test
	public void test() 
	{
		Firefox.driver.navigate().refresh();
		Firefox.driver.findElement(By.id(id)).click();
		String res = Firefox.driver.findElement(By.id(opRes)).getAttribute("value");
		assertEquals(exp, res);
	}
}
