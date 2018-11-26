import static org.junit.Assert.*;

import org.junit.Test;

public class fnameTest 
{
	@Test 
	public void fname_0() 
	{
		String a = MyClass.fname("C:/x.exe");
		assertEquals(a, "x.exe");
	}
	@Test
	public void fname_1() 
	{
		String a = MyClass.fname("C:/win/x.exe");
		assertEquals(a, "x.exe");
	}
	@Test
	public void fname_2() 
	{
		String a = MyClass.fname("C:/win/tmp/x.exe");
		assertEquals(a, "x.exe");
	}
	@Test 
	public void fname_Ex() 
	{
		String a = MyClass.fname("C:/");
		assertEquals(a,"");
	}
	@Test
	public void fname_null() 
	{
		String a = MyClass.fname("x.exe");
		assertEquals(a, "x.exe");
	}
	@Test
	public void fname_many() 
	{
		String a = MyClass.fname("C:/win/tmp/src/bin/mrt/x.exe");
		assertEquals(a, "x.exe");
	}
	@Test
	public void fname_integr_rotate() 
	{
		String a = MyClass.fname("E:/win\\tmp/src/bin\\mrt/x.exe");
		assertEquals(a, "x.exe");
	}
	@Test (expected = IllegalArgumentException.class)
	public void fname_integr_check() 
	{
		MyClass.fname("C:/win/tm#p/sr::c/bin/mr&t/x.exe");
	}

}
