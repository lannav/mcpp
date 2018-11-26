import static org.junit.Assert.*;

import org.junit.Test;

public class fnameTest 
{
	@Test
	public void file() 
	{
		String a = xFile.fname("C:/win/tmp/file.exe");
		assertEquals(a, "file.exe");
	}
	@Test
	public void one() 
	{
		String a = xFile.fname("C:/win/tmp/one.exe");
		assertEquals(a, "one.exe");
	}

}
