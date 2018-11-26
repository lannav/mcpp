

import org.junit.Test;

public class checkTest 
{
	@Test (expected = IllegalArgumentException.class)
	public void check_1() 
	{
		MyClass.check("C:/win/t#mp/x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void check_2() 
	{
		MyClass.check("C:/wi%n/tmp/x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void check_3() 
	{
		MyClass.check("C:/w&in/tmp/x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void check_4() 
	{
		MyClass.check("C:/win*/tmp/x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void check_5() 
	{
		MyClass.check("C:/win/tm|p/x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void check_7() 
	{
		MyClass.check("C:/win/t<mp/x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void check_8() 
	{
		MyClass.check("C:/wi>n/tmp/x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void check_9() 
	{
		MyClass.check("C:/win/tmp?/x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void check_10() 
	{
		MyClass.check("C:/win/nul/tmp/x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void check_11() 
	{
		MyClass.check("C:/win/tmp/aux/x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void check_12() 
	{
		MyClass.check("C:/con/win/tmp/x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void check_13() 
	{
		MyClass.check("C:/win/tmp/exe/com1/x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void check_14() 
	{
		MyClass.check("C:/win/lpt1/x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void check_15() 
	{
		MyClass.check("C:/win/bi:n/x.exe");
	}
}
