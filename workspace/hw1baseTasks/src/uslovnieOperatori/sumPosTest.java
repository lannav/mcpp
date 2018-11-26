package uslovnieOperatori;
import static org.junit.Assert.*;

import org.junit.Test;

public class sumPosTest 
{
	@Test
	public void sum_103() 
	{
		int res = operat.sumPos(1,0,3);
		assertEquals(4, res);
	}
	@Test
	public void sum_m120() 
	{
		int res = operat.sumPos(-1,2,0);
		assertEquals(2, res);
	}
	@Test
	public void sum_1m23() 
	{
		int res = operat.sumPos(1,-2,3);
		assertEquals(4, res);
	}
	@Test
	public void sum_12m3() 
	{
		int res = operat.sumPos(1,2,-3);
		assertEquals(3, res);
	}
	@Test
	public void sum_m1m2m3() 
	{
		int res = operat.sumPos(-1,-2,-3);
		assertEquals(0, res);
	}

}
