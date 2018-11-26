import static org.junit.Assert.*;

import org.junit.Test;

public class driveTest 
{
	@Test
	public void drive_C() 
	{
		String a = xFile.drive("C:/win/tmp/file.exe");
		assertEquals(a, "C");
	}
	@Test
	public void drive_E() 
	{
		String a = xFile.drive("E:/min/src/one.exe");
		assertEquals(a, "E");
	}

}
