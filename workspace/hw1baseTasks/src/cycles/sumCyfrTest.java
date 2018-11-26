package cycles;
import static org.junit.Assert.*;

import org.junit.Test;

public class sumCyfrTest 
{
	@Test
	public void sum_4213() 
	{
		int res = cycle.sum(4213);
		assertEquals(10, res);
	}
	@Test
	public void sum_0() 
	{
		int res = cycle.sum(0);
		assertEquals(0, res);
	}
	@Test
	public void sum_m57348() 
	{
		int res = cycle.sum(-57348);
		assertEquals(-27, res);
	}

}
