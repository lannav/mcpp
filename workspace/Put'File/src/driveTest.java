import static org.junit.Assert.*;

import org.junit.Test;

public class driveTest 
{
	@Test 
	public void drive_0() 
	{
		String a = MyClass.drive("C:/x.exe");
		assertEquals(a, "C");
	}
	@Test
	public void drive_1() 
	{
		String a = MyClass.drive("E:/win/x.exe");
		assertEquals(a, "E");
	}
	@Test
	public void drive_2() 
	{
		String a = MyClass.drive("D:/win/tmp/x.exe");
		assertEquals(a, "D");
	}
	@Test 
	public void drive_Ex() 
	{
		String a = MyClass.drive("A:/");
		assertEquals(a,"A");
	}
	@Test
	public void drive_null() 
	{
		String a = MyClass.drive("x.exe");
		assertEquals(a, "");
	}
	@Test
	public void drive_many() 
	{
		String a = MyClass.drive("F:/win/tmp/src/bin/mrt/x.exe");
		assertEquals(a, "F");
	}
	@Test
	public void drive_integr_rotate() 
	{
		String a = MyClass.drive("E:/win\\tmp/src/bin\\mrt/x.exe");
		assertEquals(a, "E");
	}
	@Test (expected = IllegalArgumentException.class)
	public void drive_integr_check() 
	{
		MyClass.drive("C:/win/tm#p/sr::c/bin/mr&t/x.exe");
	}
}
