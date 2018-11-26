import static org.junit.Assert.*;

import org.junit.Test;

public class pathTest 
{
	@Test
	public void win_tmp() 
	{
		String a = xFile.path("C:/win/tmp/file.exe");
		assertEquals(a, "C:/win/tmp");
	}
	@Test
	public void omin_src() 
	{
		String a = xFile.path("C:/min/src/one.exe");
		assertEquals(a, "C:/min/src");
	}

}
