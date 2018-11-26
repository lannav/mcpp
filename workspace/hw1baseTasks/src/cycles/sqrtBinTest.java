package cycles;
import static org.junit.Assert.*;

import org.junit.Test;

public class sqrtBinTest 
{

	@Test
	public void bin_9() 
	{
		int res = cycle.bins(9);
		assertEquals(3, res);
	}
	@Test
	public void bin_0() 
	{
		int res = cycle.bins(0);
		assertEquals(0, res);
	}
	@Test
	public void bin_18() 
	{
		int res = cycle.bins(18);
		assertEquals(4, res);
	}
	@Test (expected = IllegalArgumentException.class)
	public void ex_m9() 
	{
		cycle.bins(-9);
	}

}
