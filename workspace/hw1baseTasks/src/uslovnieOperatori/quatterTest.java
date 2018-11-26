package uslovnieOperatori;
import static org.junit.Assert.*;

import org.junit.Test;

public class quatterTest 
{

	@Test
	public void quatter_1() 
	{
		int res = operat.quatter(-1,2);
		assertEquals(1, res);
	}
	@Test
	public void quatter_2() 
	{
		int res = operat.quatter(1,2);
		 assertEquals(2, res);
	}
	@Test
	public void quatter_3() 
	{
		int res = operat.quatter(1,-2);
		assertEquals(3, res);
	}
	@Test
	public void quatter_4() 
	{
		int res = operat.quatter(-1,-2);
		assertEquals(4, res);
	}
	@Test (expected = IllegalArgumentException.class)
	public void Ex0_1() 
	{
		operat.quatter(0,1);
	}
	@Test (expected = IllegalArgumentException.class)
	public void Ex1_0() 
	{
		operat.quatter(1,0);
	}
	@Test (expected = IllegalArgumentException.class)
	public void Ex0_0() 
	{
		operat.quatter(0,0);
	}

}
