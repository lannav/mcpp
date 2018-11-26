import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;

@RunWith(Parameterized.class)
public class RealJob 
{
		//public static WebDriver driver;
		public String number1;
		public String op;
		public String number2;
		public String exp;
		
		public RealJob(String number1, String op, String number2, String exp)
		{
			this.number1 = number1;
			this.op = op;
			this.number2 = number2;
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
		
		@Parameters (name = "{0} {1} {2} = {3}")
		public static Collection<Object[]> buttons()
		{
			return Arrays.asList(new Object[][]
					{
				{"5","plus","8","13"}, 
				{"15","minus","8","7"}, 
				{"4","mult","7","28"}, 
				{"24","div","4","6"},
					});
		}
	
	@Test
	public void test() 
	{
		Chrome.driver.navigate().refresh();
		char[] num1 = number1.toCharArray();
		
		for(int i = 0; i < num1.length; i++)
			Chrome.driver.findElement(By.id(Character.toString(num1[i]))).click();
		
		Chrome.driver.findElement(By.id(op)).click();
		
		char[] num2 = number2.toCharArray();
		
		for(int i = 0; i < num2.length; i++)
			Chrome.driver.findElement(By.id(Character.toString(num2[i]))).click();
		
		Chrome.driver.findElement(By.id("ravno")).click();
		
		assertEquals(exp, Chrome.driver.findElement(By.id("res")).getAttribute("value"));
	}
}