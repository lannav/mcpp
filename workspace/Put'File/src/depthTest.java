import static org.junit.Assert.*;

import org.junit.Test;

public class depthTest 
{
	@Test 
	public void depth_0() 
	{
		int a = MyClass.depth("C:/x.exe");
		assertEquals(a, 0);
	}
	@Test
	public void depth_1() 
	{
		int a = MyClass.depth("C:/win/x.exe");
		assertEquals(a, 1);
	}
	@Test
	public void depth_2() 
	{
		int a = MyClass.depth("C:/win/tmp/x.exe");
		assertEquals(a, 2);
	}
	@Test 
	public void depth_Ex() 
	{
		int a = MyClass.depth("C:/");
		assertEquals(a, 0);
	}
	@Test (expected = IllegalArgumentException.class)
	public void depth_null() 
	{
		MyClass.depth("x.exe");
	}
	@Test
	public void depth_many() 
	{
		int a = MyClass.depth("C:/win/tmp/src/bin/mrt/x.exe");
		assertEquals(a, 5);
	}
	@Test
	public void depth_integr_rotate() 
	{
		int a = MyClass.depth("C:/win\\tmp/src/bin\\mrt/x.exe");
		assertEquals(a, 5);
	}
	@Test (expected = IllegalArgumentException.class)
	public void depth_integr_check() 
	{
		MyClass.depth("C:/win/tm#p/sr::c/bin/mr&t/x.exe");
	}
}
