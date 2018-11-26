package uslovnieOperatori;
import static org.junit.Assert.*;

import org.junit.Test;

public class maxTest 
{
	@Test
	public void max_103() 
	{
		int res = operat.max(1,0,3);
		assertEquals(7, res);
	}
	@Test
	public void max_223() 
	{
		int res = operat.max(2,2,3);
		assertEquals(15, res);
	}
	@Test
	public void max_1m83() 
	{
		int res = operat.max(1,-8,3);
		assertEquals(-1, res);
	}
	@Test
	public void max_m103() 
	{
		int res = operat.max(-1,0,3);
		assertEquals(5, res);
	}
}
