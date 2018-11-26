package uslovnieOperatori;
import static org.junit.Assert.*;

import org.junit.Test;

public class chetNechetTest 
{

	@Test
	public void chet() 
	{
		int res = operat.chetNech(5, 2);
		assertEquals(7, res);
	}
	@Test
	public void nechet() 
	{
		int res = operat.chetNech(2, 7);
		assertEquals(14, res);
	}

}
