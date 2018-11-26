package cycles;
import static org.junit.Assert.*;

import org.junit.Test;

public class sqrtTest 
{
	@Test
	public void sqrt_9() 
	{
		int res = cycle.sqrt(9);
		assertEquals(3, res);
	}
	@Test
	public void sqrt_0() 
	{
		int res = cycle.sqrt(0);
		assertEquals(0, res);
	}
	@Test
	public void sqrt_18() 
	{
		int res = cycle.sqrt(18);
		assertEquals(4, res);
	}
	@Test (expected = IllegalArgumentException.class)
	public void sqrt_m9() 
	{
		cycle.sqrt(-9);
	}
}
