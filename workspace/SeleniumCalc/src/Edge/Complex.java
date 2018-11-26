package Edge;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By; 

@RunWith(Parameterized.class)
public class Complex 
{
		//public static WebDriver driver;
		public String btn;

		/*@BeforeClass
		public static void StartBrow()
		{
			System.setProperty("webdriver.Edge.driver", "C:\\Users\\Admin\\eclipse\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("file:///C:\\Users\\Admin\\Desktop\\calc.html");
		}
		
		@AfterClass
		public static void CloseBrow()
		{
			driver.close();
		}*/
		
		public Complex(String btn)
		{
			this.btn = btn;
		}
		
		
		public static String init()
		{
			String res = "";
			for(int i = 0; i < (int)(Math.random()*10 + 1); i++)
			{
				String btn = Integer.toString((int)(Math.random()*10));
				res += btn;
			}
			return res;
		}
		
		@Parameters (name = "complex {0}")
		public static Collection<Object[]> buttons()
		{
			return Arrays.asList(new Object[][]
					{
				{init()}, {init()}, {init()}, {init()},
				{init()}, {init()}, {init()}, {init()},
				{init()}, {init()}, {init()}, {init()},
				{init()}, {init()}, {init()}, {init()},
				{init()}, {init()}, {init()}, {init()},
				{init()}, {init()}, {init()}, {init()},
				{init()}, {init()}, {init()}, {init()},
				{init()}, {init()}, {init()}, {init()},
				{init()}, {init()}, {init()}, {init()},
				{init()}, {init()}, {init()}, {init()},
					});
		}
	
	@Test
	public void test() 
	{
		Edge.driver.navigate().refresh();
		Edge.driver.findElement(By.id("res")).clear();
		char[] mas = this.btn.toCharArray();
		
		for(int i = 0; i < mas.length; i++)
			Edge.driver.findElement(By.id(Character.toString(mas[i]))).click();
		
		assertEquals(btn, Edge.driver.findElement(By.id("res")).getAttribute("value"));
	}
}