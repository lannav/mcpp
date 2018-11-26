import static org.junit.Assert.*;

import org.junit.Test;

public class pathTest 
{

	@Test 
	public void path_0() 
	{
		String a = MyClass.path("C:/x.exe");
		assertEquals(a, "C:");
	}
	@Test
	public void path_1() 
	{
		String a = MyClass.path("C:/win/x.exe");
		assertEquals(a, "C:/win");
	}
	@Test
	public void path_2() 
	{
		String a = MyClass.path("C:/win/tmp/x.exe");
		assertEquals(a, "C:/win/tmp");
	}
	@Test 
	public void path_Ex() 
	{
		String a = MyClass.path("C:/");
		assertEquals(a,"C:");
	}
	@Test
	public void path_null() 
	{
		String a = MyClass.path("x.exe");
		assertEquals(a, "");
	}
	@Test
	public void path_many() 
	{
		String a = MyClass.path("C:/win/tmp/src/bin/mrt/x.exe");
		assertEquals(a, "C:/win/tmp/src/bin/mrt");
	}
	@Test
	public void path_integr_rotate() 
	{
		String a = MyClass.path("E:/win\\tmp/src/bin\\mrt/x.exe");
		assertEquals(a, "E:/win/tmp/src/bin/mrt");
	}
	@Test (expected = IllegalArgumentException.class)
	public void path_integr_check() 
	{
		MyClass.path("C:/win/tm#p/sr::c/bin/mr&t/x.exe");
	}

}
