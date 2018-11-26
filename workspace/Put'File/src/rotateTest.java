import static org.junit.Assert.*;

import org.junit.Test;

public class rotateTest 
{
	@Test
	public void rotate_0() 
	{
		String a = MyClass.rotate("C:\\x.exe");
		assertEquals(a, "C:/x.exe");
	}
	@Test
	public void rotate_1() 
	{
		String a = MyClass.rotate("C:\\win/x.exe");
		assertEquals(a, "C:/win/x.exe");
	}
	@Test
	public void rotate_2() 
	{
		String a = MyClass.rotate("C:\\win\\bin/x.exe");
		assertEquals(a, "C:/win/bin/x.exe");
	}
	@Test
	public void rotate_many() 
	{
		String a = MyClass.rotate("C:\\win/tmp/src\\bin\\mrt/x.exe");
		assertEquals(a, "C:/win/tmp/src/bin/mrt/x.exe");
	}

}
